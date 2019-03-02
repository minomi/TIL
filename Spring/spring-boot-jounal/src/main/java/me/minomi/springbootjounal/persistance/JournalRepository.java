package me.minomi.springbootjounal.persistance;

import me.minomi.springbootjounal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-01.
 */

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    public List<Journal> findByTitleContaining(String word);
}
