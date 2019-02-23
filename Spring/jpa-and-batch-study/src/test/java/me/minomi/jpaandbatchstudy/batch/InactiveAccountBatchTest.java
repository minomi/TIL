package me.minomi.jpaandbatchstudy.batch;

import me.minomi.jpaandbatchstudy.accounts.Account;
import me.minomi.jpaandbatchstudy.accounts.AccountRepository;
import me.minomi.jpaandbatchstudy.accounts.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InactiveAccountBatchTest {

    @Autowired
    JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void 휴면_회원_전환_테스트() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        assertEquals(0,
                accountRepository.findByUpdatedDateBeforeAndStatusEquals(
                        LocalDateTime.now().minusYears(1),
                        Status.ACTIVE)
                        .size());
    }

}
