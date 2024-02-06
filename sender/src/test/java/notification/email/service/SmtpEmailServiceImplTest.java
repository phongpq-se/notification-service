package notification.email.service;

import notification.dto.notifier.email.EmailRequest;
import notification.email.config.JavaMailConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = JavaMailConfiguration.class)
public class SmtpEmailServiceImplTest {
    private SmtpEmailServiceImpl smtpEmailService;

    private final String fromEmail = "support@ppq.org";
    private final String sendToEmail = "phongpham.dev@gmail.com";
    private final String sendToEmail01 = "phongpham.iuh@gmail.com";

    @BeforeEach
    public void setUp() {
        smtpEmailService = new SmtpEmailServiceImpl(createJavaMailSender());
    }

    @Test
    public void sendMailWithNullReq() {
        var rs = smtpEmailService.sendEmail(null, null);
        assertFalse(rs);
    }

    @Test
    public void sendEmailBcc() {
        var emailReq = EmailRequest.builder()
                .from(fromEmail)
                .bcc(List.of(sendToEmail))
                .subject("Test send email")
                .body("Hello world")
                .build();
        var rs = smtpEmailService.sendEmail(emailReq, null);
        assertTrue(rs);
    }

    @Test
    public void sendEmailWhenToSizeGreaterThanOne() {
        var emailReq = EmailRequest.builder()
                .from(fromEmail)
                .to(List.of(sendToEmail, sendToEmail01))
                .subject("Test send email")
                .body("Hello world")
                .build();
        var rs = smtpEmailService.sendEmail(emailReq, null);
        assertTrue(rs);
    }

    @Test
    public void sendEmailCc() {
        var emailReq = EmailRequest.builder()
                .from(fromEmail)
                .to(List.of(sendToEmail))
                .cc(List.of(sendToEmail01))
                .subject("Test send email")
                .body("Hello world")
                .build();
        var rs = smtpEmailService.sendEmail(emailReq, null);
        assertTrue(rs);
    }

    @Test
    public void buildWhenJustHasTo() {
        var emailReq = EmailRequest.builder()
                .from(fromEmail)
                .to(List.of(sendToEmail))
                .subject("Test send email")
                .body("Hello world")
                .build();
        var rs = smtpEmailService.sendEmail(emailReq, null);
        assertTrue(rs);
    }

    public JavaMailSender createJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("phongpham.dev@gmail.com");
        mailSender.setPassword("kyqn jbqa aeea mlzl");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
