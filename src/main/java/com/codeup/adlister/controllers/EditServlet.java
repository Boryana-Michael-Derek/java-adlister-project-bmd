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

@WebServlet(name = "controllers.EditServlet", urlPatterns = "/edit/*")
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        long id = Long.parseLong(request.getPathInfo().substring(1));
        request.setAttribute("id", id);
        System.out.println("id is " + id);

        try {
            Ad ad = DaoFactory.getAdsDao().adsByAdId(id);
            request.setAttribute("ad", ad);
            request.setAttribute("userId", ad.getUserId());
            request.setAttribute("title", ad.getTitle());
            request.setAttribute("description", ad.getDescription());
        } catch (SQLException e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        long editAdId = Long.parseLong(request.getPathInfo().substring(1));
//            long editAdId = Long.parseLong(request.getParameter("editAd"));
        long editUserId = user.getId();
        String editTitle = request.getParameter("title");
        String editDescription = request.getParameter("description");

        boolean correctAdInfo = false;
        if (editTitle.isEmpty()) {
            request.setAttribute("titleError", "You need to enter a title!");
            request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
        } else if(editDescription.isEmpty()){
            request.setAttribute("descriptionError", "You need to describe your add.");
            request.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(request, response);
        } else {
            correctAdInfo = true;
        }
        if (correctAdInfo) {
            Ad ad = DaoFactory.getAdsDao().findAdByAdId(editAdId);
            ad.setTitle(editTitle);
            ad.setDescription(editDescription);

//            Ad ad = new Ad(editAdId,
//                    user.getId(),
//                    request.getParameter("title"),
//                    request.getParameter("description")
//            );

            DaoFactory.getAdsDao().updateAd(ad);
            request.setAttribute("ad", DaoFactory.getAdsDao().findAdByAdId(ad.getId()));
            request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
            response.sendRedirect("/ads");
        }
    }
}