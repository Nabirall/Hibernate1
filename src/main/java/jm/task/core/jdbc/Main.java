package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;


public class Main {
public static void main(String[] args) {
    UserDao userDao = new UserDaoHibernateImpl();
    userDao.createUsersTable();
    userDao.saveUser("boblo", "lolwdw", (byte) 34);
    userDao.saveUser("vovdqw", "lole", (byte) 4);
    userDao.saveUser("zpddwq", "lolw", (byte) 124);
    userDao.saveUser("cwwsfea", "lolq", (byte) 54);
    userDao.getAllUsers();
    userDao.cleanUsersTable();
    userDao.dropUsersTable();
}
}
