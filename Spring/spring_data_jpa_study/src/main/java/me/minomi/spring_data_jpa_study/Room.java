package me.minomi.spring_data_jpa_study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@Entity
@Table(name = "rooms") // 생략할 경우 class 명을 대문자로 변경된 것이 지정
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "id") // 생략할 경우 프로퍼티 명을 대문자로 변경된 것이 지정
    private Integer roomId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Equipment> equipments;

}
