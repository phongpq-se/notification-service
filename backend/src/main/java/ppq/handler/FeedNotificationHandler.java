package ppq.handler;

import ppq.dto.common.Response;
import ppq.dto.notification.NotificationRequest;
import ppq.util.LogContext;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author phongpq
 */
public class FeedNotificationHandler implements NotificationHandler {

    private final LogContext logger = new LogContext(FeedNotificationHandler.class);


    @Override
    public Response sendNotification(NotificationRequest notificationRequestList, boolean isDryRun, boolean isSync, Map<String, Object> reqContext) {
        logger.info("FeedNotificationHandler: making call to sendNotifications method");

        return null;
    }

}
