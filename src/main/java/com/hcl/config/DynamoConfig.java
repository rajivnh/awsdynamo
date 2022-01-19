package com.hcl.config;

import javax.annotation.PostConstruct;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.hcl.model.Music;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.hcl.persistence")
public class DynamoConfig {
	private AmazonDynamoDB amazonDynamoDB;
	
	@Bean
    public AmazonDynamoDB amazonDynamoDB() {
        amazonDynamoDB = AmazonDynamoDBClientBuilder
        		.standard()
        		.withEndpointConfiguration(new EndpointConfiguration("http://localhost:8000", "us-east-1"))
        		.build();
        
        return amazonDynamoDB;
    }
	
	@PostConstruct
	private void setup() {
		try {
			DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
	
			CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Music.class);
			
			tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
			
			amazonDynamoDB.createTable(tableRequest);		
		} catch(Exception e) {
			
		}
	}
}
