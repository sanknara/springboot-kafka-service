package com.springboot.kafkaservice.controller;

import com.springboot.kafkaservice.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    
    @Autowired
    private KafkaProducer kafkaProducer;
    
    // http://localhost:8080/api/v1/kafka/publishMessage?message=Hello
    @GetMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
