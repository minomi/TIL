package me.minomi.jpaandbatchstudy.accounts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() {
        assertNotNull(dataSource);
        assertNotNull(jdbcTemplate);
        assertNotNull(accountRepository);
    }

    @Test
    public void save() {
        Account account = new Account();
        account.setName("minho");
        account.setPassword("pass");
        accountRepository.save(account);
    }
}