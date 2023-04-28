package com.example.ChatApplication.Kafka;

import com.example.ChatApplication.PayLoad.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;
//import org.springframework.kafka.support.KafkaConstants;


import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConsumer {
//    @Bean
//    ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String ,Message> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    @Bean
//    public ConsumerFactory<String,Message> consumerFactory(){
//        return new DefaultKafkaConsumerFactory<>(consumerConfiguration(),
//                new StringDeserializer(), new JsonDeserializer<>(Message.class) );
//    }

//    @Bean
//    public Map<String , Object> consumerConfiguration(){
//        Map<String,Object> configurations = new HashMap<>();
//        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//        configurations.put(ConsumerConfig.GROUP_ID_CONFIG,"myGroup");
//        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return configurations;
//    }

    /*In Consumer Config, similar to Producer Config we are setting the
    * deserializer for key and value.
    *
    * GROUP_ID_CONFIG to set the Kafka consumer group ID
    *
    * AUTO_OFFSET_RESET_CONFIG to set the Offset Configuration. In this project,
    * we are using the value "earliest" so that we will get all the values in the queue from
    * the beginning.Instead, we can also use "latest" to get only the latest value.
    *
    * */


//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
//    @KafkaListener(topics = "chatApp",groupId = "myGroup")
//    public void receiveMessage(String message){
//        logger.info(String.format("Message Received %s : "+ message));
//    }

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "chatApp", groupId = "myGroup")
    public void listen(Message message){
        System.out.println("Sending via kafka listener : ");
        //simpMessagingTemplate.convertAndSend("topic/group",message);

    }
}
