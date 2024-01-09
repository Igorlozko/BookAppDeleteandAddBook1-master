package ie.atu.bookappmoremicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:.env")
public class BookAppMoreMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAppMoreMicroServicesApplication.class, args);
	}

}
