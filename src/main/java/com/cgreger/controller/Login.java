package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.DBItemDAO;
import com.cgreger.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "Login",
        urlPatterns = {"/login"}

)

/**
 *  Servlet used to log a user into the application
 *
 *  @author Chelsea Greger
 */
public class Login extends HttpServlet {

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
     * Finds the user by email, determins their role,
     * and redirects to index as a logged in user
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO userDao = new UserDAO();

        User user = userDao.getUserByEmail(request.getUserPrincipal().getName());

        request.getSession().setAttribute("user", user);

        if (request.isUserInRole("administrator")) {

            request.getSession().setAttribute("isAdmin", true);
            request.getSession().setAttribute("dbItemDAO", new DBItemDAO());

        }

        response.sendRedirect("index");

    }

}
