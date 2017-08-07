package com.cgreger.persistence;

import com.cgreger.entity.db.APIKey;
import com.cgreger.entity.db.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by katana on 2/13/17.
 */
public class APIKeyDAOTest {
    private User user1;
    private UserDAO userDAO = new UserDAO();
    private APIKeyDAO apiKeyDAO = new APIKeyDAO();
    private static SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private final Logger log = Logger.getLogger(this.getClass());

    //TODO: Finish these tests

    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {

        Session session = factory.openSession();
        Transaction tr = null;

        try {

            tr = session.beginTransaction();
            session.createSQLQuery("INSERT INTO user (email, password, salt) VALUES" +
                    "('username@gmail.com', 'passwordhash', 'salthash1')," +
                    "('sally@gmail.com', 'passwordhash', 'salthash2')," +
                    "('jdoe@gmail.com', 'passwordhash', 'salthash3')," +
                    "('smith@gmail.com', 'passwordhash', 'salthash4')," +
                    "('johnny@gmail.com', 'passwordhash', 'salthash5');").executeUpdate();
            session.createSQLQuery("INSERT INTO gw2_api_key (user_id, api_key) VALUES" +
                    "(1, 'APIKEY1')," +
                    "(2, 'APIKEY2')," +
                    "(3, 'APIKEY3')," +
                    "(4, 'APIKEY4')," +
                    "(5, 'APIKEY5')").executeUpdate();


        } catch (HibernateException e) {

            if (tr != null) {

                tr.rollback();

            }

        } finally {

            session.close();

        }


    }

    @Before
    public void setUp() {

        user1 = userDAO.getUserById(1);

    }

    @Test
    public void addAPIKey() throws Exception {

        APIKey newKey = new APIKey(user1, "newTestAPIKey654654");
        apiKeyDAO.addAPIKey(user1, newKey);

        assertEquals("The initial api key is nonexistant. (id1)", user1.getApiKeys().get(0).getApiKey(), "APIKEY1");
        assertEquals("The api key was not added correctly. (id1)", user1.getApiKeys().get(1).getApiKey(), "newTestAPIKey654654");

    }

    @Test
    public void getAPIKey() throws Exception {

        log.info(apiKeyDAO.getAPIKey(1).getApiKey());

    }

    @Test
    public void getAllAPIKeys() throws Exception {

    }

    @Test
    public void updateAPIKey() throws Exception {

    }

    @Test
    public void deleteAPIKey() throws Exception {

    }

}