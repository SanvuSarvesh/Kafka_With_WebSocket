package com.example.ChatApplication.PayLoad;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = "chatApp", groupId = "myGroup")
    public void listen(Message message) throws Exception{
        System.out.println("Sending via kafka listener : ");
        ObjectMapper objectMapper = new ObjectMapper();
        String newMessage = objectMapper.writeValueAsString(message);
        simpMessagingTemplate.convertAndSend("topic/group",newMessage);
    }
}
