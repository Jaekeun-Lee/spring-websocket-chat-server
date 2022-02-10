package io.cresendo.chat.config.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cresendo.chat.dto.ChatMessage;
import io.cresendo.chat.dto.ChatRoom;
import io.cresendo.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        log.info("payload : {}", payload);

//        TextMessage textMessage = new TextMessage("Welcome chatting server!");
//        session.sendMessage(textMessage);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom chatRoom = chatService.findChatRoomById(chatMessage.getChatRoomId());
        chatRoom.handleActions(session, chatMessage, chatService);

    }
}
