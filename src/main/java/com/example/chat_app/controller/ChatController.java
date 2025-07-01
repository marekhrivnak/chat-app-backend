package com.example.chat_app.controller;

import com.example.chat_app.entity.ChatMessage;
import com.example.chat_app.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessageDto messageDto) {
        ChatMessage message = ChatMessage.builder()
                .sender(messageDto.getSender())
                .content(messageDto.getContent())
                .timestamp(LocalDateTime.now())
                .build();
        ChatMessage saved = chatMessageService.saveMessage(message);
        return saved;
    }

    public static class ChatMessageDto {
        private String sender;
        private String content;

        public ChatMessageDto() {}

        public ChatMessageDto(String sender, String content) {
            this.sender = sender;
            this.content = content;
        }

        public String getSender() { return sender; }
        public void setSender(String sender) { this.sender = sender; }
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
} 