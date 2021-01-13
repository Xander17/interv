package app.db;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Database {

    @Getter
    private static Session session;

    public static Session openSession() {
        session = getSessionFactory().openSession();
        return session;
    }

    public static void closeSession() {
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
