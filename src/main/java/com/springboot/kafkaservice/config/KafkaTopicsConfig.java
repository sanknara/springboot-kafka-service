package com.springboot.kafkaservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {
    @Bean
    public NewTopic designConceptsTopic(){
        return TopicBuilder.name("understandingApacheKafka")
                .build();
    }
    
    @Bean
    public NewTopic userDataTopic(){
        return TopicBuilder.name("userData").build();
    }
}
