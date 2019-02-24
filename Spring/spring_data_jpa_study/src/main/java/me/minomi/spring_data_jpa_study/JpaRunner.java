package me.minomi.spring_data_jpa_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    RoomService roomService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Room 생성");
        Room newRoom = roomService.createRoom("새로운 방");
        System.out.println("생성된 Room : " + newRoom.getName());

        System.out.println("Room 가져오기");
        Room room = roomService.getRoom(newRoom.getRoomId());
        System.out.println(room);

        System.out.println("Room 이름 변경");
        Room updatedRoom = roomService.updateRoomName(newRoom.getRoomId(), "새로운 방 이름");
        System.out.println("변경 된 이름 : " + updatedRoom);

        System.out.println("Room 삭제");
        roomService.deleteRoom(newRoom.getRoomId());
    }
}
