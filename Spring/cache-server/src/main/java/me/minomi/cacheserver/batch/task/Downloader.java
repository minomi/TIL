package me.minomi.cacheserver.batch.task;

import me.minomi.cacheserver.components.MemCacheQueue;
import me.minomi.cacheserver.domain.ResourceCache;
import me.minomi.cacheserver.service.ResourceCacheService;
import me.minomi.cacheserver.util.FileUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */

@Service
public class Downloader {
    private MemCacheQueue<String> memCacheQueue;
    private ResourceCacheService resourceCacheService;

    public Downloader(MemCacheQueue<String> memCacheQueue, ResourceCacheService resourceCacheService) {
        this.memCacheQueue = memCacheQueue;
        this.resourceCacheService = resourceCacheService;
    }

    @Async("Downloader")
    public void download() {
        memCacheQueue.getSubSet(10).parallelStream().forEach(resourceURL -> {
            ResourceCache resourceCache = resourceCacheService.readResourceCache(resourceURL);
            if (resourceCache.isEmpty()) {
                // log error
                return;
            }

            try {
                File cachedFile = FileUtil.getFile(resourceURL);
                if (cachedFile.exists()) {
                    resourceCacheService.updateCacheHitTime(resourceURL);
                    return;
                }
                resourceCacheService.updateCacheStatus(resourceURL, ResourceCache.Status.FETCHING);
                FileUtil.copyURLToFile(resourceURL);
                resourceCacheService.updateCacheStatus(resourceURL, ResourceCache.Status.CACHED);
            } catch (IOException e) {
                resourceCacheService.removeResourceCache(resourceURL);
            }
        });
    }
}
