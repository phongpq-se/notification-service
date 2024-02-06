package notification.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailConfig {
    private String fromEmail;
    private String userName;
    private String password;
    private String host;
    private String port;
}
