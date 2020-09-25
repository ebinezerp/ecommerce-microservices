package ecommerce.configurationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class EcommerceConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceConfigurationServiceApplication.class, args);
	}

}
