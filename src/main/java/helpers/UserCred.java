package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserCred {
    public static final Properties CREDS;

    static {
        CREDS = new Properties();
        InputStream in = UserCred.class.getResourceAsStream("/users.properties");

        try {
            CREDS.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getUser(String role) {
        return CREDS.getProperty(role).split(",");
    }
}
