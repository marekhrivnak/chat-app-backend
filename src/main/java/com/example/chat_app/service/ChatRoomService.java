package com.example.chat_app.service;

import com.example.chat_app.entity.ChatRoom;
import com.example.chat_app.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatRoom createRoom(String name) {
        if (chatRoomRepository.existsByName(name)) {
            throw new IllegalArgumentException("Room name already exists");
        }
        ChatRoom room = new ChatRoom();
        room.setName(name);
        return chatRoomRepository.save(room);
    }
} 