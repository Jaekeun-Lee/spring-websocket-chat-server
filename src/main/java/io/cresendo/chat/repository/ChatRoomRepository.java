package io.cresendo.chat.repository;

import io.cresendo.chat.dto.ChatRoom;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        List chatRoomList = new ArrayList<>(chatRooms.values());
        Collections.reverse(chatRoomList);
        return chatRoomList;
    }

    public ChatRoom findChatRoomById(String chatRoomId) {
        return chatRooms.get(chatRoomId);
    }

    public ChatRoom createChatRoom(String roomName) {
        ChatRoom chatRoom = new ChatRoom(roomName);
        chatRooms.put(chatRoom.getChatRoomId(), chatRoom);
        return chatRoom;
    }


}
