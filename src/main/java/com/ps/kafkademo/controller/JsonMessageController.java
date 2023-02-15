package com.ps.kafkademo.controller;

import com.ps.kafkademo.kafka.KafkaJsonProducer;
import com.ps.kafkademo.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class JsonMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/jsonpublish")
    public ResponseEntity<String> publish(@RequestBody Employee employee) {
        kafkaJsonProducer.sendMessage(employee);
        return ResponseEntity.ok("Json Message Sent to Topic");
    }
}
