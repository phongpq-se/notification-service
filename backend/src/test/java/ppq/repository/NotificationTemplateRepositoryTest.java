package ppq.repository;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ppq.config.SessionFactoryInitializerConfiguration;
import pqq.CassandraConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author phongpq
 */
@SpringBootTest
public class NotificationTemplateRepositoryTest {

    @Autowired
    private NotificationTemplateRepository repository;

    @Test
    public void findAllTest() {
        var rs = IterableUtils.toList(repository.findAll());
        System.out.println(rs.size());
        assertThat(rs.size()).isGreaterThanOrEqualTo(0);
    }
}
