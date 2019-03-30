package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-19.
 */

@Entity
@Table
public class Member {

    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER) // 다대일 관계라는 매핑정보, 다중성을 나타내는 어노테이션은 필수!!!
    @JoinColumn(name = "TEAM_ID") // 외래키를 매핑할 때 사용 생략 가능
    private Team team;

    @Column(name = "NAME", length = 10)
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lasModifiedDate;

    @Embedded
    private Period period;

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

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLasModifiedDate(Date lasModifiedDate) {
        this.lasModifiedDate = lasModifiedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLasModifiedDate() {
        return lasModifiedDate;
    }

    public String getDescription() {
        return description;
    }
}
