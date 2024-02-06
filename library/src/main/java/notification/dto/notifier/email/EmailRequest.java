package notification.dto.notifier.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailRequest {
    private String subject;
    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private String templateName;
    private String body;
    private Map<String, String> param;
}
