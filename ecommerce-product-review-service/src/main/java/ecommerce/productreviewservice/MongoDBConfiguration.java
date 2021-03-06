package ecommerce.productreviewservice;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "ecommerce.productreviewservice.repository")
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		return "product_review";
	}

	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/product_review");
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(clientSettings);
	}

	@Override
	protected Collection<String> getMappingBasePackages() {
		return Arrays.asList("ecommerce.productservice.model");

	}

	@Override
	protected boolean autoIndexCreation() {
		return true;
	}

}
