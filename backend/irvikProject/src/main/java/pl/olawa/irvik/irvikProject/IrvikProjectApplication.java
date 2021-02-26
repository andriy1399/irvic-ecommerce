package pl.olawa.irvik.irvikProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olawa.irvik.irvikProject.dao.UserSecurityController;
import pl.olawa.irvik.irvikProject.domain.User;
import pl.olawa.irvik.irvikProject.service.EmailService;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class IrvikProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(IrvikProjectApplication.class, args);
	}

}
