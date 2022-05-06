package vn.techmaster.demosession.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender emaillSender ;

    public void sendMail(String email, String text) {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setText("Mã xác nhận : " + text);

        // Send Message!
        emaillSender.send(message);
    }
}
