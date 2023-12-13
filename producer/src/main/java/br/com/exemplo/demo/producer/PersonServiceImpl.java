package br.com.exemplo.demo.producer;

import br.com.exemplo.demo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private Objects objects;
    private final String urlQueue;
    private final QueueMessagingTemplate template;

    public PersonServiceImpl(@Value("${queue.url}") String urlQueue,
                             QueueMessagingTemplate template) {
        this.urlQueue = urlQueue;
        this.template = template;
    }

    @Override
    public void sendPersonMessage(Person person) {
        log.info("Messagem enviada com sucesso");
        template.convertAndSend(urlQueue, person);
    }
}