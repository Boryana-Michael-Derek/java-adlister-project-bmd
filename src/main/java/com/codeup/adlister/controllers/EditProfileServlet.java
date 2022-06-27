package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("username", user.getUsername());
        request.setAttribute("email", user.getEmail());
        request.getRequestDispatcher("/WEB-INF/profile/edit.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setUsername(username);
        user.setEmail(email);
        if(!password.equals("")) {
            user.setPassword(password);
        }
        DaoFactory.getUsersDao().update(user);
        response.sendRedirect("/profile");
    }
}
