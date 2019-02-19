package me.minomi.springmvcstudy.batch;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-19.
 */

@Table
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = {"idx", "email"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    public User changeInactive() {
        status = UserStatus.INACTIVE;
        return this;
    }
}
