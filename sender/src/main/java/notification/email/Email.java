package notification.email;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class Email {
    private static Properties props = null;
    private String host;
    private String port;
    private String userName;
    private String password;
    private String fromEmail;
    private static Email instance;

    public static Email getInstance() {
        if (null == instance) {
            synchronized (Email.class){
                if (null == instance) {
                    instance = new Email();
                }
            }
        }
        return instance;
    }

    private boolean sendEmail(Session session, MimeMessage message) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("");
        return true;
    }
}
