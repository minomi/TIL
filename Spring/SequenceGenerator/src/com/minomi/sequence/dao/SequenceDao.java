package com.minomi.sequence.dao;

import com.minomi.sequence.domain.Sequence;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */
public interface SequenceDao {
    public Sequence getSequence(String sequenceId);
    public int getNextValue(String sequenceId);
}
