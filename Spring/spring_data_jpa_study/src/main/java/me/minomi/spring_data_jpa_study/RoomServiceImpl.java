package me.minomi.spring_data_jpa_study;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@Service
public class RoomServiceImpl implements RoomService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Room getRoom(Integer id) {
        Room room = Optional.ofNullable(entityManager.find(Room.class, id)).orElse(Room.NULL_OBJ);
        return room;
    }

    @Transactional
    @Override
    public Room createRoom(String roomName) {
        Room room = new Room();
        room.setName(roomName);
        entityManager.persist(room);
        return room;
    }

    @Transactional
    @Override
    public Room updateRoomName(Integer id, String roomName) {
        Room room = getRoom(id);
        room.setName(roomName);
        return room;
    }

    @Transactional
    @Override
    public void deleteRoom(Integer id) {
        Room room = getRoom(id);
        entityManager.remove(room);
    }
}
