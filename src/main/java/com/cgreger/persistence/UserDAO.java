package com.cgreger.persistence;

import com.cgreger.entity.db.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * User DAO used to
 * Create, Read, Update, and Destroy
 * User records in the database.
 *
 * @author Chelsea Greger
 */
public class UserDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    /**
     * Adds a new User record to the database
     *
     * @param user  the User object to add to the database
     * @return      the id of the newly created User record
     */
    public int addUser(User user) {

        Session session = factory.openSession();
        Transaction tr = null;
        Integer userId = null;

        try {

            log.info("Adding new User.");

            tr = session.beginTransaction();

            userId = (Integer) session.save(user);

            tr.commit();
            log.info("Successfully added new User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to add new User (id" + userId + ").\n", e);

        } finally {

            session.close();

        }

        return userId;

    }

    /**
     * Retrieves a User object from the database
     * by it's ID
     *
     * @param userId    ID of the User to retrieve
     * @return          User object of ID requested, null if doesn't exist
     */
    public User getUserById(int userId) {

        Session session = factory.openSession();
        Transaction tr = null;
        User user = null;

        try {

            log.info("Getting User (id" + userId + ").");

            tr = session.beginTransaction();
            user = (User) session.get(User.class, userId);

            log.info("Successfully retrieved User (id" + userId + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve User (id" + userId + ")\n", e);

        } finally {

            session.close();

        }

        return user;

    }

    /**
     * Retrieves a User from the database
     * by their email
     *
     * @param email     email of the associated User
     * @return          the User object associated with
     *                  the requested email
     */
    public User getUserByEmail(String email) {

        Session session = factory.openSession();
        Transaction tr = null;
        User user = null;

        try {

            log.info("Getting User (email=" + email + ").");

            Criteria criteria = session.createCriteria(User.class);
            criteria = criteria.add(Restrictions.eq("email", email));
            List<User> results = (List<User>) criteria.list();

            if (results.size() >= 1) {

                log.info("Successfully retrieved User (email=" + email + ")");
                user = results.get(0);

            } else {

                log.error("Failed to retrieve User (email=" + email + ") : Email should exist and be unique!");

            }

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve User (email=" + email + ")\n", e);

        } finally {

            session.close();

        }

        return user;

    }

    /**
     * Retrieves all Users from the database
     *
     * @return  List of all the Users in the database,
     *          null list if there aren't any
     */
    public List<User> getAllUsers() {

        Session session = factory.openSession();
        List<User> users = new ArrayList<User>();

        try {

            log.info("Getting and creating List of all users.");

            users = session.createCriteria(User.class).list();

            log.info("Successfully created List of all Users.");

        } catch (HibernateException e) {

            log.error("Failed to create List of all Users.\n", e);

        } finally {

            session.close();

        }

        return users;

    }

    /**
     * Updates a user in the database with
     * a given User object
     *
     * @param user  User object to update current User record
     */
    public void updateUser(User user) {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            log.info("Updating User's (id" + user.getId() + ")");

            tr = session.beginTransaction();
            session.update(user);

            tr.commit();
            log.info("Successfully updated User (id" + user.getId() + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update User (id" + user.getId() + ")\n", e);

        } finally {

            session.close();

        }

    }

    /**
     * Deletes a User from the database
     *
     * @param userId    User ID of the User record to delete
     *                  from the database
     */
    public void deleteUser(int userId) {

        Session session = factory.openSession();
        Transaction tr = null;
        User user = null;

        try {

            log.info("Deleting User (id" + userId + ").");

            tr = session.beginTransaction();

            user = (User)session.get(User.class, userId);
            session.delete(user);

            tr.commit();
            log.info("Successfully deleted User (id" + userId + ").");

        } catch (HibernateException e) {

            if (tr!=null) {

                tr.rollback();

            }

            log.error("Failed to delete User(id" + userId + ")\n", e);

        } finally {

            session.close();

        }

    }


}
