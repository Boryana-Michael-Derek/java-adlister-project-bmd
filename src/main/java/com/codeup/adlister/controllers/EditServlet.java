package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


import static java.lang.Integer.parseInt;

@WebServlet(name = "controllers.EditServlet", urlPatterns = "/ads/edit")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
            long id = Long.parseLong(request.getParameter("editAd"));

        try {
            request.setAttribute("editThisAd", DaoFactory.getAdsDao().adsByAdId(id));
        } catch (SQLException e) {
            throw new RuntimeException("Edit Servlet doGet", e);
        }
        request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendRedirect("/login");
                return;
            }

            long editAdId = Long.parseLong(request.getParameter("editAd"));
            Ad ad = new Ad(editAdId,
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            DaoFactory.getAdsDao().editAd(ad);
            request.setAttribute("ad", DaoFactory.getAdsDao().findAdByAdId(ad.getId()));
            request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
            response.sendRedirect("/show");
    }
}