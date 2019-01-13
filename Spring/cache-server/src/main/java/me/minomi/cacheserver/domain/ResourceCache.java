package me.minomi.cacheserver.domain;

import lombok.Data;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */

@Data
public class ResourceCache {
    public static final ResourceCache EMPTY_RESOURCE_CACHE = new ResourceCache();

    public enum Status {
        GENESIS,
        FETCHING,
        CACHED;
    }

    private String url;
    private long timeLastCacheHit;
    private Status status;

    public boolean isEmpty() {
        return this.equals(EMPTY_RESOURCE_CACHE);
    }

    public boolean isCached() {
        return !isEmpty() && status.equals(Status.CACHED);
    }
}
