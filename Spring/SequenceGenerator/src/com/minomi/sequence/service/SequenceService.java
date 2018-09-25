package com.minomi.sequence.service;

import com.minomi.sequence.dao.SequenceDao;
import com.minomi.sequence.domain.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */

@Component
public class SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    public SequenceService(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public void setSequenceDao(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public String generate(String sequenceId) {
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}
