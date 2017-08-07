package com.cgreger.controller;

import com.cgreger.entity.api.Item;
import com.cgreger.persistence.ItemDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(

        name = "DisplayAdminTools",
        urlPatterns = {"/admin"}

)

/**
 * Servlet used to display administrator tools
 * such as updating the database
 *
 * @author Chelsea Greger
 */
public class DisplayAdminTools extends HttpServlet {

    /**
     * Forwards user to admin.jsp
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/admin.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}