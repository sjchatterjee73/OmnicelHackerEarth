package driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"controller", "abstraction", "datas", "persistence"})
public class OmnicelRestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmnicelRestProjectApplication.class, args);
	}

}
