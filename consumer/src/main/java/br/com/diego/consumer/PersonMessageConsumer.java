package br.com.diego.consumer;

import br.com.diego.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableSqs
public class PersonMessageConsumer {

    @SqsListener(value = "${cloud.aws.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receivePersonMessage(Person personMessage) {
        log.info("Mensagem recebida: {}", personMessage);

    }

}
