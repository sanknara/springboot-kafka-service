package com.springboot.kafkaservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    
    // Property Injection
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("understandingApacheKafka", message);
    }
    
    
}