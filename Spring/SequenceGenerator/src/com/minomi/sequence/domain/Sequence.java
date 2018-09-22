package com.minomi.sequence.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
