package com.springboot.kafkaservice.kafka;

import com.springboot.kafkaservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
    
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    
    public void sendJsonMessage(User userData){
        
        LOGGER.info(String.format("JSON Message sent -> %s", userData.toString()));
        
        Message<User> message = MessageBuilder
                .withPayload(userData).setHeader(KafkaHeaders.TOPIC, "userData")
                .build();
        
        kafkaTemplate.send(message);
    }
    
    
}
