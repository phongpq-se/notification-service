package notification.email.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import notification.dto.notifier.email.EmailRequest;
import notification.notifier.email.EmailService;
import notification.util.LogContext;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Data
public class SmtpEmailServiceImpl implements EmailService {
    private final LogContext logger = new LogContext(SmtpEmailServiceImpl.class);

    private final JavaMailSender javaMailSender;

    @Value("${mail.from}")
    private String fromEmail;

    @Override
    public boolean sendEmail(EmailRequest emailReq, Map<String, Object> context) {
        if (Objects.isNull(emailReq)) {
            logger.info(context, "Email request is null or empty:");
            return false;
        } else if (CollectionUtils.isNotEmpty(emailReq.getBcc()) || emailReq.getTo().size() > 1) {
            var simpleMailMessage = buildWhenBccOrToHasSizeGreaterThanOne(emailReq);
            javaMailSender.send(simpleMailMessage);
            return true;
        } else if (CollectionUtils.isNotEmpty(emailReq.getCc())) {
            var simpleMailMessage = buildWhenCc(emailReq);
            javaMailSender.send(simpleMailMessage);
            return true;
        } else {
            var simpleMailMessage = buildWhenJustHasTo(emailReq);
            javaMailSender.send(simpleMailMessage);
            return true;
        }
    }

    protected SimpleMailMessage buildWhenJustHasTo(EmailRequest emailReq) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailReq.getFrom() == null ? fromEmail : emailReq.getFrom());
        simpleMailMessage.setSubject(emailReq.getSubject());
        simpleMailMessage.setText(emailReq.getBody());
        simpleMailMessage.setTo(emailReq.getTo().toArray(new String[0]));
        return simpleMailMessage;
    }

    private SimpleMailMessage buildWhenCc(EmailRequest emailReq) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailReq.getFrom() == null ? fromEmail : emailReq.getFrom());
        simpleMailMessage.setSubject(emailReq.getSubject());
        simpleMailMessage.setText(emailReq.getBody());
        simpleMailMessage.setTo(emailReq.getTo().toArray(new String[0]));
        simpleMailMessage.setCc(emailReq.getCc().toArray(new String[0]));
        return simpleMailMessage;
    }

    private SimpleMailMessage buildWhenBccOrToHasSizeGreaterThanOne(EmailRequest emailReq) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailReq.getFrom() == null ? fromEmail : emailReq.getFrom());
        simpleMailMessage.setSubject(emailReq.getSubject());
        simpleMailMessage.setText(emailReq.getBody());
        var bcc = CollectionUtils.isEmpty(emailReq.getBcc()) ? emailReq.getTo() : emailReq.getBcc();
        simpleMailMessage.setBcc(bcc.toArray(new String[0]));
        return simpleMailMessage;
    }
}
