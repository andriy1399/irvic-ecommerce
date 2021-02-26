package pl.olawa.irvik.irvikProject.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.olawa.irvik.irvikProject.service.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String to, String body, String topic) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = body;
        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject(topic);
        helper.setFrom("kostikzhora@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
