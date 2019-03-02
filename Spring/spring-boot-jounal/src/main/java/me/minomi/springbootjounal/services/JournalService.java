package me.minomi.springbootjounal.services;

import me.minomi.springbootjounal.domain.Journal;
import me.minomi.springbootjounal.persistance.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-01.
 */

@Service
public class JournalService {

    private JournalRepository journalRepository;

    public List<Journal> findAllJournals() {
        return journalRepository.findAll();
    }

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }
}
