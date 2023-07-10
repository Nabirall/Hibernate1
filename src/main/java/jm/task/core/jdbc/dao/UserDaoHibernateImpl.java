package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.sessionFactory;

public class UserDaoHibernateImpl implements UserDao {

private final SessionFactory factory = Util.getSessionFactory();
private static Transaction transaction = null;

public UserDaoHibernateImpl() {

}


@Override
public final void createUsersTable() {
    try (Session session = factory.openSession()) {
        transaction = session.beginTransaction();
        Query query = session.createSQLQuery("create table if not exists users (id int primary key auto_increment,name varchar(45),lastname varchar(45),age int)");
        query.executeUpdate();
        transaction.commit();
    } catch (Exception e) {
        e.printStackTrace();
    }
    //не надо роллбэк
}

@Override
public final void dropUsersTable() {
    try (Session session = factory.openSession()) {
        transaction = session.beginTransaction();
        Query query = session.createSQLQuery("drop table if exists users");
        query.executeUpdate();
        transaction.commit();
    } catch (Exception e) {
        e.printStackTrace();
    }
    //не надо роллбэк
}

@Override
public void saveUser(String name, String lastName, byte age) {
    try (Session session = sessionFactory.getCurrentSession()) {
        transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
}

@Override
public void removeUserById(long id) {
    try (Session session = sessionFactory.getCurrentSession()) {
        transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }


}

@Override
public List<User> getAllUsers() {
    List<User> userList = new ArrayList<>();
    try (Session session = factory.openSession()) {
        transaction = session.beginTransaction();
        userList = session.createQuery("from User").list();
        transaction.commit();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return userList;
}

@Override
public void cleanUsersTable() {
    try (Session session = factory.openSession()) {
        transaction = session.beginTransaction();
        Query query = session.createSQLQuery("delete from users");
        query.executeUpdate();
        transaction.commit();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}