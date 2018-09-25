package com.minomi.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 22..
 */
public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    @Autowired
    @Qualifier("datePrefixGenerator")
    private PrefixGenerator prefixGenerator;

    public SequenceGenerator() { }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Required
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    @Required
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public String getSequence() {
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
        return builder.toString();
    }
}
