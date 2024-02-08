package ppq.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ppq.domain.NotificationTemplate;
import pqq.CassandraConfig;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author phongpq
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        CassandraConfig.class,
        SessionFactoryInitializerConfiguration.class
})
public class SessionFactoryInitializerConfigurationTest {
    @Autowired
    CqlTemplate cqlTemplate;

    @Test
    public void countFromNotificationTemplateTable() {
        var rs = cqlTemplate.queryForList("SELECT * FROM notification_template", NotificationTemplate.class);
        System.out.println(rs.size());
        assertThat(rs.size()).isGreaterThanOrEqualTo(0);
    }
}
