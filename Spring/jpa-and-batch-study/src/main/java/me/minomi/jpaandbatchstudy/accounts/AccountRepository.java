package me.minomi.jpaandbatchstudy.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByName(String name);
}
