package pl.olawa.irvik.irvikProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class IrvikProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrvikProjectApplication.class, args);
	}

}
