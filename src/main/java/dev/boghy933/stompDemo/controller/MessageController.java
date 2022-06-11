package dev.boghy933.stompDemo.controller;

import dev.boghy933.stompDemo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/time/{city}")
    public Message getMessage(final Message message) throws InterruptedException {
        Thread.sleep(1000);
        return new Message("Message is: " + message.getMessage());
    }
}
