package com.example.ChatApplication.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String sender;
    private String content;
    private String timeStamp;

}
