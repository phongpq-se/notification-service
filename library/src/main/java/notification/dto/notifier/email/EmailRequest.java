package notification.dto.notifier.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailRequest {
    private String subject;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String templateName;
    private String body;
    private Map<String, String> param;
}
