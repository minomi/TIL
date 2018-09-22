package com.minomi.sequence.dao;

import com.minomi.sequence.domain.Sequence;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */

@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

    private final Map<String, Sequence> sequenceMap = new HashMap<>();
    private final Map<String, AtomicInteger> values = new HashMap<>();

    public SequenceDaoImpl() {
        sequenceMap.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequenceMap.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        AtomicInteger value = values.get(sequenceId);
        return value.getAndIncrement();
    }
}
