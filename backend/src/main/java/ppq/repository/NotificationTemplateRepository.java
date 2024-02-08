package ppq.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ppq.domain.NotificationTemplate;

/**
 * @author phongpq
 */
@Repository
public interface NotificationTemplateRepository extends CassandraRepository<NotificationTemplate, String> {
}
