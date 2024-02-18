package ppq.dto.notification.feed;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author phongpq
 */
@Data
public class NotificationFeedResponse {
    private String id;
    private String userId;
    private String version;
    private String category;
    private int priority;
    private String status;
    private String action;
    private Timestamp expireOn;
}
