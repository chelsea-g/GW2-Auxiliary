package com.cgreger.controller;

import com.cgreger.entity.api.Item;
import com.cgreger.entity.db.DBItem;
import com.cgreger.persistence.DBItemDAO;
import com.cgreger.persistence.ItemDAO;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(

        name = "DisplayItemPage",
        urlPatterns = {"/item-page"}

)

/**
 * Servlet to display a requested item
 *
 * @author Chelsea Greger
 */
public class DisplayItemPage extends HttpServlet {

    private ItemDAO itemDAO = new ItemDAO();

    /**
     * Accesses the itemName parameter to display the
     * specific item's details and recipe
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemName = request.getParameter("item_name");

        Item item = itemDAO.getItemByName(itemName);

        request.setAttribute("item", item);

        String url = "/itemPage.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }

}