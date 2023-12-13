package br.com.exemplo.demo;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        /*
        Este codigo abaixo, é caso você nao consiga criar a fila pelo cli da amazon, que e o ideal, caso nao consiga descomente o codigo abaixo
        mas, caso tenha cli use esse comando no terminal para criar a fila:
             aws --endpoint-url http://localhost:9324 sqs create-queue --queue-name person_queue

         */

//        AmazonSQSAsyncClient amazonSQSAsyncClient = (AmazonSQSAsyncClient) AmazonSQSAsyncClientBuilder.standard()
//                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration
//                        ("http://localhost:9324", "us-east-1"))
//                .build();
//
//        CreateQueueRequest createQueueRequest = new CreateQueueRequest();
//        createQueueRequest.setQueueName("person_queue");
//
//        amazonSQSAsyncClient.createQueue(createQueueRequest);
//
//        System.out.println("Fila criada com sucesso!");


    }

}