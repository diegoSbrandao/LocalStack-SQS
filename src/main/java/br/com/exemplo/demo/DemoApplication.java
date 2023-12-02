package br.com.exemplo.demo;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		AmazonSQSAsyncClient amazonSQSAsyncClient = (AmazonSQSAsyncClient) AmazonSQSAsyncClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration
						("http://localhost:9324", "us-east-1"))
				.build();

		CreateQueueRequest createQueueRequest = new CreateQueueRequest();
		createQueueRequest.setQueueName("new_test_queue");

		amazonSQSAsyncClient.createQueue(createQueueRequest);

		System.out.println("Fila criada com sucesso!");


	}

}
