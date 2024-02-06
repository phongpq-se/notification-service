
package notification.notifier.email;

import notification.dto.notifier.email.EmailRequest;
import java.util.Map;

public interface EmailService {
    boolean sendEmail(EmailRequest emailReq, Map<String, Object> context);
}
