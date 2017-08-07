package com.cgreger.controller;

import com.cgreger.entity.db.APIKey;
import com.cgreger.entity.db.User;
import com.cgreger.entity.db.UserRole;
import com.cgreger.helpers.ItemTracker;
import com.cgreger.helpers.Validator;
import com.cgreger.persistence.APIKeyDAO;
import com.cgreger.persistence.TrackedItemDAO;
import com.cgreger.persistence.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.catalina.realm.RealmBase;
import org.apache.log4j.Logger;

@WebServlet(

        name = "TryCreateAccount",
        urlPatterns = {"/try-create-account"}

)

/**
 * Servlet to manage user account creation
 *
 * @author Chelsea Greger
 */
public class CreateAccount extends HttpServlet {

    private User newUser;
    private APIKey validAPIKey;
    private UserRole userRole;
    private Validator validator = new Validator();
    private Logger log = Logger.getLogger(this.getClass());

    /**
     * Relays request and response to doGet()
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    /**
     * Cleans form input and passes input to validator method
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email").trim();
        String password =  request.getParameter("password");
        String repeatPassword = request.getParameter("repeatPassword");
        String apiKey = request.getParameter("apiKey");

        if (validateForm(email, password, repeatPassword, apiKey)) {

            //TODO: make password hash work with tomcat authentication
            //password = RealmBase.Digest(password,"sha-256", "UTF-8");

            newUser = new User(email, password, "");

            validAPIKey = new APIKey(newUser, apiKey);
            newUser.getApiKeys().add(validAPIKey);

            userRole = new UserRole(newUser, "registered-user", newUser.getEmail());
            newUser.getUserRoles().add(userRole);

            UserDAO userDAO = new UserDAO();
            userDAO.addUser(newUser);

            goToLogin(request, response, newUser.getEmail());

        } else {

            goToCreateAccount(request, response, email, apiKey);

        }


    }

    /**
     * Validates form input by using the Helpers.Validator class
     *
     * @param email             New user email
     * @param password          New user password
     * @param repeatPassword    New user repeat password
     * @param apiKey            New user Guildwars 2 API key (generated through arena.net account)
     * @return  false for invalid input, true for valid input
     */
    public boolean validateForm(String email, String password, String repeatPassword, String apiKey) {

        boolean isValid = false;

        if (validator.validateEmail(email)
                && validator.validatePassword(password, repeatPassword)
                && validator.validateAPIKey(apiKey)) {

            isValid = true;

        }

        return isValid;
    }

    /**
     *  Returns the user to the sign up form
     *  when input is invalid
     *
     * @param request
     * @param response
     * @param email              new user's previously entered email
     * @param apiKey             new user's previously entered api key
     * @throws ServletException
     * @throws IOException
     */
    public void goToCreateAccount(HttpServletRequest request, HttpServletResponse response, String email, String apiKey)
            throws ServletException, IOException {

        request.setAttribute("email", email);
        request.setAttribute("apiKey", apiKey);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/create-account");
        dispatcher.forward(request, response);

    }

    /**
     * Redirects user to login page when account is
     * successfully created
     *
     * @param request
     * @param response
     * @param email                 new user's email
     * @throws ServletException
     * @throws IOException
     */
    public void goToLogin(HttpServletRequest request, HttpServletResponse response, String email)
            throws ServletException, IOException {

        request.setAttribute("email", email);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login");
        dispatcher.forward(request, response);

    }



}
