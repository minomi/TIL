package me.minomi.springmvcstudy.batch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-19.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime updatedDate, UserStatus status);
}
