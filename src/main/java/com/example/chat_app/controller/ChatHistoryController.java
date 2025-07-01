package com.example.chat_app.controller;

import com.example.chat_app.entity.ChatMessage;
import com.example.chat_app.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class ChatHistoryController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getAllMessages() {
        return ResponseEntity.ok(chatMessageService.getAllMessages());
    }
} 