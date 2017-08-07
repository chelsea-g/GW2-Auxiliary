package com.cgreger.persistence;

import com.cgreger.entity.db.APIKey;
import com.cgreger.entity.db.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * API Key DAO used to
 * Create, Read, Update, and Destroy
 * API Key records in the database.
 *
 * @author Chelsea Greger
 */
public class APIKeyDAO {

    private final Logger log = Logger.getLogger(this.getClass());
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    /**
     * Link an API Key with a user in the database
     *
     * @param user      User to link API Key to
     * @param apiKey    API Key to link to user
     * @return          the ID of the newly created record
     */
    public int addAPIKey(User user, APIKey apiKey) {

        log.info("Adding APIKey for User (id=" + user.getId() + ")");
        user.getApiKeys().add(apiKey);

        return apiKey.getId();

    }

    /**
     * Retrieve an API Key from the database by it's ID
     *
     * @param apiKeyId  ID of the requested API Key
     * @return          APIKey object of the requested API Key
     */
    public APIKey getAPIKey(int apiKeyId) {

        Session session = factory.openSession();
        Transaction tr = null;
        APIKey apiKey = null;

        try {

            log.info("Getting APIKey (id" + apiKeyId + ").");

            tr = session.beginTransaction();
            apiKey = (APIKey) session.get(APIKey.class, apiKeyId);

            log.info("Successfully retrieved APIKey (id" + apiKey + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to retrieve APIKey (id" + apiKey + ")\n", e);

        } finally {

            session.close();

        }

        return apiKey;

    }

    /**
     * Retrieves all API Keys from the database
     *
     * @return List of all the api keys from the database,
     *         empty list if their aren't any
     */
    public List<APIKey> getAllAPIKeys() {

        Session session = factory.openSession();
        Transaction tr = null;
        List<APIKey> apiKeys = new ArrayList<APIKey>();

        try {

            log.info("Getting and creating List of all APIKeys.");

            tr = session.beginTransaction();
            apiKeys = session.createCriteria(APIKey.class).list();

            log.info("Successfully created List of all APIKeys.");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to create List of all APIKeys.\n", e);

        } finally {

            session.close();

        }

        return apiKeys;

    }

    /**
     * Updates an API Key database record
     * with a given API Key object
     *
     * @param apiKey    APIKey object to update current APIKey to
     */
    public void updateAPIKey(APIKey apiKey) {

        Session session = factory.openSession();
        Transaction tr = null;
        String assocEmail = apiKey.getUser().getEmail();

        try {

            log.info("Updating APIKey (associated w/ email: " + assocEmail + ")");

            tr = session.beginTransaction();
            session.update(apiKey);

            tr.commit();
            log.info("Successfully updated APIKey (associated w/ email " + assocEmail + ")");

        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

            log.error("Failed to update APIKey (associated w/ email " + assocEmail + ")\n", e);

        } finally {

            session.close();

        }

    }

    /**
     * Deletes an APIKey from a user's list of
     * API Keys
     *
     * @param user      User that owns APIKey to delete
     * @param apiKey    The APIKey object to delete
     */
    public void deleteAPIKey(User user, APIKey apiKey) {

        log.info("Removing APIKey for User (id=" + user.getId() + ")");

        if (user.getApiKeys().size() != 1) {

            user.getApiKeys().remove(apiKey);
            log.info("Successfully removed APIKey.");

        } else {

            log.error("Cannot remove last APIKey, at least 1 APIKey required per User.");

        }

    }

}
