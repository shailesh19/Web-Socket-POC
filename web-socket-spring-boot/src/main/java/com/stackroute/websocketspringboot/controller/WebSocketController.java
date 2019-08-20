package com.stackroute.websocketspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send/message")
    public void processMessageFromClient(String message) {
        this.messagingTemplate.convertAndSend("/chat",new SimpleDateFormat("HH:mm:ss")
                .format(new Date())+" "+ message);
    }
}
