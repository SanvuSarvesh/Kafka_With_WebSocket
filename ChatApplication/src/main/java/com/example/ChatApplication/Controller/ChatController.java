package com.example.ChatApplication.Controller;

import com.example.ChatApplication.PayLoad.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/api/send", consumes = "application/json",
            produces = "application/json")
    public String sendMessage(@RequestBody Message message) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String newObject = objectMapper.writeValueAsString(message);
        message.setTimeStamp(LocalDateTime.now().toString());
        try {
            kafkaTemplate.send("chatApp", newObject);
        }
        catch (Exception exception){
            exception.printStackTrace();
            //throw new RuntimeException(exception);
        }
        return "We are getting output.";
    }

    @MessageMapping("/send-message")
    @SendTo("chatApp/myGroup")
    public Message chatMessage( Message message){
        // sending this message to the members
        return message;
    }

}
