package com.ps.kafkademo.kafka;

import com.ps.kafkademo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, Employee> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee employeeData) {

        LOGGER.info(String.format("Message Sent -> %s", employeeData.toString()));

        Message<Employee> message = MessageBuilder.withPayload(employeeData)
                .setHeader(KafkaHeaders.TOPIC, "PsTopic_json")
                .build();

        kafkaTemplate.send(message);
    }
}
