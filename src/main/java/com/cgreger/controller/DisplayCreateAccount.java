package com.cgreger.controller;

import com.cgreger.entity.db.User;
import com.cgreger.persistence.UserDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayCreateAccount",
        urlPatterns = {"/create-account"}

)

/**
 * Servlet used to display the sign up page
 */
public class DisplayCreateAccount extends HttpServlet {

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

    /**
     * Forwards user to createAccount.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/createAccount.jsp";

        RequestDispatcher dispatcher =
                request.getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}