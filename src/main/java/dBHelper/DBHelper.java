package dBHelper;

import model.User;
import org.hibernate.cfg.Configuration;

public class DBHelper {
    public static Configuration getConfiguration(){

        Configuration configuration = new Configuration().configure();

        configuration.addAnnotatedClass(User.class);

        return configuration;
    }
}
