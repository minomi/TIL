package me.minomi.spring_data_jpa_study;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */
public interface RoomService {
    Room getRoom(Integer id);
    Room createRoom(String roomName);
    Room updateRoomName(Integer id, String roomName);
    void deleteRoom(Integer id);
}
