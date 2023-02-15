package com.ps.kafkademo.kafka;

import com.ps.kafkademo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "PsTopic_json", groupId = "myGroup")
    public void consume(Employee employee) {
        LOGGER.info(String.format("Json Message received -> %s", employee));
    }

}
