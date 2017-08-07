package com.cgreger.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Session Factory Provider that
 * creates a configured Hibernate Session Factory
 * to use along with the database
 *
 * @author Chelsea Greger
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    /**
     * Creates the Session Factory using hibernate config
     */
    public static void createSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    /**
     * Retrieves the SessionFactory if one already exists,
     * or creates a new one if one does not currently exist
     *
     * @return  Current instance of the SessionFactory object
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            createSessionFactory();

        }

        return sessionFactory;

    }

}