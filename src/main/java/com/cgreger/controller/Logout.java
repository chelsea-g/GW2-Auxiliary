package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "Logout",
        urlPatterns = {"/logout"}

)

/**
 * Servlet used to log out a user from the applicaiton
 *
 * @author Chelsea Greger
 */
public class Logout extends HttpServlet {

    /**
     * Relays request and response to doGet()
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    /**
     * Invalidates the current user's session,
     * resulting in the users logged out status
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().invalidate();

        response.sendRedirect("index");

    }

}