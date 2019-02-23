package me.minomi.jpaandbatchstudy.accounts;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */

@Entity
@EqualsAndHashCode(of = {"id"})
@Data
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime updatedDate;

    public Account changeInactive() {
        this.status = Status.INACTIVE;
        return this;
    }
}
