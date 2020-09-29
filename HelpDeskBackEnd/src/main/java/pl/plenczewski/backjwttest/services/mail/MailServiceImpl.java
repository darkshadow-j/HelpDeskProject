package pl.plenczewski.backjwttest.services.mail;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class MailServiceImpl implements MailService {


    private JavaMailSender emailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @After("@annotation(CreateNewTicketAspect)")
    @Override
    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("p.lenczewski94@gmail.com");
        message.setTo("p.lenczewski94@gmail.com");
        message.setSubject("Nowe zgloszenie");
        message.setText("Zgloszenie");
        emailSender.send(message);
    }
}
