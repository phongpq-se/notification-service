package notification.notifier.email.service;


import lombok.AllArgsConstructor;
import notification.dto.notifier.email.EmailRequest;
import notification.notifier.email.EmailConfig;
import notification.notifier.email.EmailService;

import java.util.Map;

@AllArgsConstructor
public class SmtpEmailServiceImpl implements EmailService {

    private final EmailConfig emailConfig;

    @Override
    public boolean sendEmail(EmailRequest emailReq, Map<String, Object> context) {
        System.out.println("helloss");
        return false;
    }
}
