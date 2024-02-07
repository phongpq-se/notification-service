package notification.email.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author phongpq
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaMailConfiguration.class)
@TestPropertySource(properties = """
        ppq_mail_server_password=password test
        """)
public class JavaMailConfigurationTest {

    @Autowired
    JavaMailConfiguration javaMailConfiguration;

    @Test
    public void getPasswordValue() {
        var password = javaMailConfiguration.getPassword();
        System.out.println(password);
        assertThat(password).isNotEmpty();
    }
}
