package br.com.exemplo.demo;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		AmazonSQSAsyncClient amazonSQSAsyncClient = (AmazonSQSAsyncClient) AmazonSQSAsyncClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration
						("http://localhost:9324", "us-east-1"))
				.build();

        List<String> queueNames = Arrays.asList("new_test_queue_0", "new_test_queue_1", "new_test_queue_2");

        for (String queueName : queueNames) {
            CreateQueueRequest createQueueRequest = new CreateQueueRequest();
            createQueueRequest.setQueueName(queueName);

            amazonSQSAsyncClient.createQueue(createQueueRequest);

            System.out.println("Fila criada com sucesso: " + queueName);
        }
    }
}