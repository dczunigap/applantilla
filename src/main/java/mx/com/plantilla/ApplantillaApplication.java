package mx.com.plantilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@SpringBootApplication
@RestController
/*@EnableAutoConfiguration*/
public class ApplantillaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApplantillaApplication.class, args);
	}
}
