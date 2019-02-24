package me.minomi.spring_data_jpa_study;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(this.getEquipmentsInRoom(1));
    }

    @Transactional
    public List<Equipment> getEquipmentsInRoom(Integer roomId) {
        Room room = entityManager.find(Room.class, roomId);
        return room.getEquipments();
    }
}
