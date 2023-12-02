package br.com.exemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fila")
public class QueueController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.fila.new_test_queue}")
    private String uriQueue;

    @PostMapping
    public ResponseEntity<String> createQueue(@RequestBody String mensagem){
        queueMessagingTemplate.send(uriQueue, MessageBuilder.withPayload(mensagem).build());
        return ResponseEntity.ok("Solicitação enviada com sucesso.");
    }
}