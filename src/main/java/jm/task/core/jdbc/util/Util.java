package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
private static final String DB_URL = "jdbc:mysql://localhost:3306/myDB";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "desire300";
public static SessionFactory sessionFactory;
public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
        try {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/myDB");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "desire300");
            settings.put(Environment.SHOW_SQL, "true");

            configuration.setProperties(settings);

            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return sessionFactory;
}


public static Connection getConnection() {
    Connection connection;
    try {
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Connection ne oki");
        throw new RuntimeException(e);
    }
    return connection;
}
}