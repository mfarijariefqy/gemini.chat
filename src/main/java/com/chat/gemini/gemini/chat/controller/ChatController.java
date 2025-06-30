package com.chat.gemini.gemini.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.gemini.gemini.chat.dto.ChatRequest;
import com.chat.gemini.gemini.chat.dto.ChatResponse;
import com.chat.gemini.gemini.chat.service.GeminiService;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = geminiService.getChatResponse(request.getMessage());
        return new ChatResponse(reply);
    }

    @GetMapping("/test")
    public String getTest() {
        return "Hello, Gemini!";
    }

    
}
