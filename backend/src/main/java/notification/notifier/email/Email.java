package notification.notifier.email;

import java.util.Properties;

public class Email {
    private static Properties props = null;
    private String host;
    private String port;
    private String userName;
    private String password;
    private String fromEmail;
    private static Email instance;

    public static Email getInstance() {
        if (null == instance) {
            synchronized (Email.class){
                if (null == instance) {
                    instance = new Email();
                }
            }
        }
        return instance;
    }
}
