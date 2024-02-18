package ppq.handler;

import ppq.dto.common.Response;
import ppq.dto.notification.NotificationRequest;

import java.util.Map;

/**
 * @author phongpq
 */
public interface NotificationHandler {
    Response sendNotification(NotificationRequest notificationRequestList,
                              boolean isDryRun,
                              boolean isSync,
                              Map<String, Object> reqContext);
}
