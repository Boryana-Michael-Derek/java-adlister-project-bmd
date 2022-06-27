
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        long id = Long.parseLong(request.getParameter("showad"));
//        long editId = Long.parseLong(request.getParameter("editAd"));
        List<Ad> adList = null;

        try {
            adList = DaoFactory.getAdsDao().searchAds(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("search", adList);
        try {
            request.setAttribute("ad", DaoFactory.getAdsDao().adsByAdId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);

//        request.setAttribute("editAd", DaoFactory.getAdsDao().findAdByAdId(editId));
//        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);

        response.sendRedirect("/ads/search"); //this line must be below line above it or else 500 error!
    }
}