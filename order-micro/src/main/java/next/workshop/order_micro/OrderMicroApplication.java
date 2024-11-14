package next.workshop.order_micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroApplication.class, args);
	}

}
