package library.notifier.email;

import java.util.Properties;

public class Email {
    private static Properties props = null;
    private String host;
    private String port;
    private String userName;
    private String password;
    private String fromEmail;
    private static Email instance;
}
