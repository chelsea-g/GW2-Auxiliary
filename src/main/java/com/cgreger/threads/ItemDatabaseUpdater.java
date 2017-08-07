package com.cgreger.threads;

import com.cgreger.persistence.DBItemDAO;

/**
 * Thread that runs the database update
 * separate from main application thread
 *
 * @author Chelsea Greger
 */
public class ItemDatabaseUpdater implements Runnable {

    @Override
    public void run() {

        DBItemDAO dbItemDAO = new DBItemDAO();

        //TODO: add maxpages to properties file
        dbItemDAO.updateItemDatabase(300);

    }

}
