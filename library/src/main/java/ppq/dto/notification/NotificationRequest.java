package ppq.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ppq.dto.action.ActionRequest;
import ppq.enummeration.NotificationType;

import java.util.List;
import java.util.Map;

/**
 * @author phongpq
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {
    private List<String> ids; ////userId, emailId, phone, deviceId
    private NotificationType type;
    private int priority;
    private ActionRequest action;
}
