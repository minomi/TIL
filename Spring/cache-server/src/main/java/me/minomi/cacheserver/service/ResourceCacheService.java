package me.minomi.cacheserver.service;

import me.minomi.cacheserver.components.MemCacheQueue;
import me.minomi.cacheserver.domain.ResourceCache;
import me.minomi.cacheserver.repository.ResourceRepository;
import me.minomi.cacheserver.service.exceptions.NotFoundResourceException;
import me.minomi.cacheserver.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static me.minomi.cacheserver.domain.ResourceCache.EMPTY_RESOURCE_CACHE;
import static me.minomi.cacheserver.domain.ResourceCache.Status.GENESIS;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */

@Service
public class ResourceCacheService {

    private MemCacheQueue<String> memCacheQueue;
    private ResourceRepository resourceRepository;
    private static final int TIMEOUT = 3 * 60 * 1000; // 3 min
    private static final int INTERVAL = 1000; // 1sec

    public ResourceCacheService(MemCacheQueue<String> memCacheQueue, ResourceRepository resourceRepository) {
        this.memCacheQueue = memCacheQueue;
        this.resourceRepository = resourceRepository;
    }

    public ResourceCache readResourceCache(String resourceURL) {
        ResourceCache resourceCache = getResourceCache(resourceURL);
        updateCacheHitTime(resourceURL);
        return resourceCache;
    }

    public File getResource(String resourceURL) {
        ResourceCache resourceCache = getResourceCache(resourceURL);
        try {
            if (resourceCache.isCached()) {
                File cachedFile = FileUtil.getFile(resourceURL);

                if (cachedFile.exists()) {
                    updateCacheHitTime(resourceURL);
                    return cachedFile;
                }

                // log 캐시 되었지만 실제로 파일이 없음
            }

            createCacheResource(resourceURL);
            waitForDownload(resourceURL);;
            return FileUtil.getFile(resourceURL);
        } catch (IOException e) {

        } catch (NotFoundResourceException e) {

        }

        return new File("/qweqweqw");
    }

    public void createCacheResource(String resourceURL) {
        final ResourceCache resourceCacheForEmptyCheck = getResourceCache(resourceURL);
        if (!resourceCacheForEmptyCheck.equals(EMPTY_RESOURCE_CACHE)) {
            // log warn
            return;
        }

        final ResourceCache resourceCache = new ResourceCache();
        resourceCache.setUrl(resourceURL);
        resourceCache.setStatus(GENESIS);
        resourceCache.setTimeLastCacheHit(System.currentTimeMillis());
        memCacheQueue.add(resourceURL);
        resourceRepository.save(resourceCache);
        // log create cache
    }

    public void updateCacheHitTime(String resourceURL) {
        ResourceCache resourceCache = getResourceCache(resourceURL);
        if (resourceCache.equals(EMPTY_RESOURCE_CACHE)) {
            // log warn
            return;
        }

        // log cache hit
        resourceCache.setTimeLastCacheHit(System.currentTimeMillis());
        resourceRepository.save(resourceCache);
    }

    public void updateCacheStatus(final String resourceURL, final ResourceCache.Status status) {
        final ResourceCache resourceCache = getResourceCache(resourceURL);
        if (resourceCache.isEmpty()) {
            //log warn
            return;
        }

        resourceCache.setStatus(status);
        resourceRepository.save(resourceCache);
        //log update
    }

    /**
     * Downloader 가 resource 를 다운받아 줄때까지 재시도
     * @param resourceURL
     */
    private void waitForDownload(final String resourceURL) throws NotFoundResourceException {
        long t1 = System.currentTimeMillis();

        while (true) {
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                // log error
                Thread.currentThread().interrupt();
            }

            ResourceCache resourceCache = getResourceCache(resourceURL);

            if (resourceCache.isEmpty()) {
                // log error
                throw new NotFoundResourceException();
            }

            if (resourceCache.isCached()) {
                // log cached
                break;
            }

            long t2 = System.currentTimeMillis();
            if (t2 - t1 > TIMEOUT) {
                // log error
                removeResourceCache(resourceURL);
                break;
            }
        }
    }

    public void removeResourceCache(String resourceURL) {
        ResourceCache resourceCache = getResourceCache(resourceURL);
        if (resourceCache.isEmpty()) {
            // log warn
            return;
        }

        resourceRepository.deleteById(resourceURL);
        memCacheQueue.remove(resourceURL);
        // log delete
    }

    private ResourceCache getResourceCache(String resourceURL) {
        return resourceRepository.findById(resourceURL).orElse(EMPTY_RESOURCE_CACHE);
    }
}
