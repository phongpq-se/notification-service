package ppq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

/**
 * @author phongpq
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(value = "notification_feed")
public class NotificationFeed {
    private String id;
    private String userId;
    private String version;
    private String category;
    private int priority;
    private String status;
    private String action;
    private Timestamp expireOn;
    private String createdBy;
    private Timestamp createdOn;
    private String updatedBy;
    private Timestamp updatedOn;
}
