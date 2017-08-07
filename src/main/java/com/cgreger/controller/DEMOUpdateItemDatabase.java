package com.cgreger.controller;

import com.cgreger.threads.DEMOItemDatabaseUpdater;
import com.cgreger.threads.ItemDatabaseUpdater;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "DEMOUpdateItemDatabase",
        urlPatterns = {"/demo-update-item-database"}

)

/**
 *
 * Class to show demo of item database updater button
 *
 * @author Chelsea Greger
 *
 */
public class DEMOUpdateItemDatabase extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DEMOItemDatabaseUpdater demoItemDatabaseUpdater = new DEMOItemDatabaseUpdater();

        Thread demoItemDatabaseUpdaterThread = new Thread(demoItemDatabaseUpdater);

        demoItemDatabaseUpdaterThread.start();
        try {
            demoItemDatabaseUpdaterThread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Do not respond until the update is finished.
        if (demoItemDatabaseUpdaterThread.getState() == Thread.State.TERMINATED) {

            String url = "/admin";

            RequestDispatcher dispatcher =
                    request.getServletContext().getRequestDispatcher(url);

            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }


}
