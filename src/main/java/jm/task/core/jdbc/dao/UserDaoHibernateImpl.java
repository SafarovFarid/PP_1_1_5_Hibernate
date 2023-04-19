package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import static jm.task.core.jdbc.util.Util.getSessionFactory;


public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {
    }

    SessionFactory sessionFactory = getSessionFactory();

    @Override
    public void createUsersTable() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users ( `id` INT NOT NULL AUTO_INCREMENT," +
                            " `name` VARCHAR(255) NULL, `lastName` VARCHAR(255) NULL," +
                    "  `age` INT NULL,  PRIMARY KEY (`id`))ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;")
                    .addEntity(User.class);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


    @Override
    public void dropUsersTable() {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS users;").addEntity(User.class);
            query.executeUpdate();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {

            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            User user = session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> list = null;

        try(Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            list = session.createQuery("from User").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

}
