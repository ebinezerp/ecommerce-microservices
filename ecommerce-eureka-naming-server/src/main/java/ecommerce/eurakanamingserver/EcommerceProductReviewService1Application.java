package ecommerce.eurakanamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcommerceProductReviewService1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceProductReviewService1Application.class, args);
	}

}
