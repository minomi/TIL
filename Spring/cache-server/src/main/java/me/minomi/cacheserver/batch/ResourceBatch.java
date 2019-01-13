package me.minomi.cacheserver.batch;

import me.minomi.cacheserver.batch.task.Downloader;
import me.minomi.cacheserver.components.MemCacheQueue;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-13.
 */

@Service
public class ResourceBatch {

    private Downloader downloader;
    private MemCacheQueue<String> memCacheQueue;

    public ResourceBatch(Downloader downloader, MemCacheQueue<String> memCacheQueue) {
        this.downloader = downloader;
        this.memCacheQueue = memCacheQueue;
    }

    @Scheduled (cron = "0/1 * * * * ?")
    public void download() {
        if (memCacheQueue.isEmpty()) {
            return;
        }
        downloader.download();
    }
}
