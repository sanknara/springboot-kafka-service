package com.springboot.kafkaservice.controller;

import com.springboot.kafkaservice.kafka.JsonKafkaProducer;
import com.springboot.kafkaservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;
    
    
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
    
    
}
