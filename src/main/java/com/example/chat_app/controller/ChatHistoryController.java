package com.example.chat_app.controller;

import com.example.chat_app.entity.ChatMessage;
import com.example.chat_app.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatHistoryController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getMessagesByRoom(@RequestParam Long roomId) {
        List<ChatMessage> messages = chatMessageService.getAllMessages().stream()
            .filter(m -> m.getRoomId().equals(roomId))
            .toList();
        return ResponseEntity.ok(messages);
    }

    @PostMapping
    public ResponseEntity<ChatMessage> postMessage(@RequestBody ChatMessageDto dto) {
        ChatMessage message = ChatMessage.builder()
            .sender(dto.getSender())
            .content(dto.getContent())
            .timestamp(LocalDateTime.now())
            .roomId(dto.getRoomId())
            .build();
        ChatMessage saved = chatMessageService.saveMessage(message);
        return ResponseEntity.ok(saved);
    }

    public static class ChatMessageDto {
        private String sender;
        private String content;
        private Long roomId;
        public String getSender() { return sender; }
        public void setSender(String sender) { this.sender = sender; }
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
        public Long getRoomId() { return roomId; }
        public void setRoomId(Long roomId) { this.roomId = roomId; }
    }
} 