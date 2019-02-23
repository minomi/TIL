package me.minomi.jpaandbatchstudy.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime updated, Status status);
}
