package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static java.lang.System.out;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");


        User userTest = DaoFactory.getUsersDao().findByUsername(username);
        User emailTest = DaoFactory.getUsersDao().findByEmail(email);

        boolean correctInfo = false;
        if(username.isEmpty()){
            request.setAttribute("usernameError", "You need to enter a username!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (userTest != null && username.equals(userTest.getUsername())) {
            request.setAttribute("usernameExists", "This username is already in use, please try another.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if(!email.contains("@")) {
            request.setAttribute("emailError", "You need to enter a valid email address!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (emailTest != null && email.equals(emailTest.getEmail())) {
            request.setAttribute("emailExists", "This email is already in use, please try another.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else if (!password.equals(passwordConfirmation) || password.isEmpty()) {
            request.setAttribute("passwordError", "The passwords do not match!");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            correctInfo = true;
        }


//        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);


//        if (inputHasErrors) {
//            response.sendRedirect("/register");
//            return;
//        }
        User foundUser = DaoFactory.getUsersDao().findByUsername(username);
        if(foundUser != null) {
            response.sendRedirect("/register");
            return;
        }
        // create and save a new user
        if(correctInfo) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/login");
        }
    }
}
