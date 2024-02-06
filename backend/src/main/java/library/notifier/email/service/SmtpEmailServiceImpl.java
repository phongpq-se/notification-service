package library.notifier.email.service;


import library.dto.notifier.email.EmailRequest;
import library.notifier.email.EmailService;

import java.util.Map;

public class SmtpEmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(EmailRequest emailReq, Map<String, Object> context) {
        System.out.println("helloss");
        return false;
    }

}
