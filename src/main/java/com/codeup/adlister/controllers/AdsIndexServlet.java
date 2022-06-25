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
import java.sql.SQLOutput;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Ad> adList = null;
        try {
            adList = DaoFactory.getAdsDao().searchAds(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("search", adList);
        response.sendRedirect("ads/search");
    
  
        long id = Long.parseLong(req.getParameter("showad"));
        req.setAttribute("ad", DaoFactory.getAdsDao().findAdByAdId(id));
        req.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(req, resp);
    }
}