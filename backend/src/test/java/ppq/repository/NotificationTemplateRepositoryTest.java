package ppq.repository;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ppq.domain.NotificationTemplate;
import ppq.enummeration.TemplateType;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

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

    @Test
    void insertData() {
        var notificationTemplate = createNotificationTemplate();
        var data = repository.save(notificationTemplate);
        System.out.println(data);
        assertThat(data.getType()).isEqualTo(TemplateType.HTML);
    }

    public NotificationTemplate createNotificationTemplate() {
        NotificationTemplate notificationTemplate = new NotificationTemplate();
        notificationTemplate.setTemplateId(UUID.randomUUID().toString());
        notificationTemplate.setType(TemplateType.HTML);
        notificationTemplate.setVer("1.0");
        notificationTemplate.setData("""
                {"title": "${param1} has been assigned to ${param2} by ${param3}"}
                """);
        notificationTemplate.setTemplateSchema("123");
        notificationTemplate.setConfig(Map.of("key", "value"));
        notificationTemplate.setCreatedOn(new Timestamp(System.currentTimeMillis()));
        notificationTemplate.setCreatedBy("phongpq");
        notificationTemplate.setLastUpdatedOn(new Timestamp(System.currentTimeMillis()));
        notificationTemplate.setLastUpdatedBy("phongpq");
        return notificationTemplate;
    }
}
