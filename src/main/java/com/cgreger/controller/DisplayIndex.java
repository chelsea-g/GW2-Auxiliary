package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayIndex",
        urlPatterns = {"/index"}

)

/**
 * Servlet used to display the main index of the application
 *
 * @author Chelsea Greger
 */
public class DisplayIndex extends HttpServlet {

    /**
     * Forwards user to index.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

    /**
     * Relays request and response to doGet()
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  ServletException, IOException {

        doGet(request, response);

    }

}