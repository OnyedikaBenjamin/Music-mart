package africa.musicmart.Email;

import africa.musicmart.exception.GenericException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService implements EmailSender{

    private final JavaMailSender javaMailSender;
    @Override
    public void send(String to,String email) throws GenericException{
        try {
            MimeMessage mailMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mailMessage,"utf-8");
            mimeMessageHelper.setSubject("Confirm your email address");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom("sobamboolusola1152@gmail.com");
            mimeMessageHelper.setText(email,true);
            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            log.info("Problem 1:" + e.getMessage());
            throw new RuntimeException(e);
        } catch (MailException e) {
            log.info("Problem 2:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    }

