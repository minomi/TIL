package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-19.
 */

@Entity(name = "MEMBERS")
@Table(name = "MEMBERS",
        uniqueConstraints = @UniqueConstraint(name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}))
public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lasModifiedDate;

    @Lob
    private String description;


    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
