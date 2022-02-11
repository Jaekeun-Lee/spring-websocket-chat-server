package io.cresendo.chat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class ChatRoom {
    private String chatRoomId;
    private String roomName;


    public ChatRoom(String roomName) {
        this.chatRoomId = UUID.randomUUID().toString();
        this.roomName = roomName;
    }

    @Builder
    public ChatRoom(String chatRoomId, String roomName) {
        this.chatRoomId = chatRoomId;
        this.roomName = roomName;
    }
}
