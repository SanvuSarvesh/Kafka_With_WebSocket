package com.example.ChatApplication.Kafka;

import com.example.ChatApplication.PayLoad.Message;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        kafkaTemplate.send("chatApp", message);
    }


//
//    @Bean
//    public ProducerFactory<String, Message> producerFactory(){
//        return new DefaultKafkaProducerFactory<>(producerConfigurations());
//    }
//
//    @Bean
//    public Map<String,Object> producerConfigurations(){
//        Map<String,Object> configurations = new HashMap<>();
//        // this line is to set the server address on which kafka is running
//        configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//
//        // these two lines are to deserialize the key and value from the kafka
//        configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return configurations;
//
//    }
//
//    @Bean
//    public KafkaTemplate<String,Message> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }

//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
//    private KafkaTemplate<String,String> kafkaTemplate;
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    public void sendMessage(String message){
//        logger.info(String.format("Message sent %s : " +message));
//        kafkaTemplate.send("chatApp",message);
//    }

}
