package ppq.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ppq.domain.NotificationFeed;

/**
 * @author phongpq
 */
@Repository
public interface NotificationFeedRepository extends CassandraRepository<NotificationFeed, String> {
}
