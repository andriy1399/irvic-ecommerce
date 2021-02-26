package pl.olawa.irvik.irvikProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.olawa.irvik.irvikProject.service.EmailService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/sendEmail")
    public  void sendEmail(String to, String body, String topic) throws MessagingException {
        emailService.sendEmail(to,body,topic);
    }

}
