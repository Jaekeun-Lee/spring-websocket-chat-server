package io.cresendo.chat.dto;

import io.cresendo.chat.cd.MessageType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChatMessage {
    private MessageType type;
    private String chatRoomId;
    private String sender;
    private String message;
}
