
package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "controllers.ShowAdServlet", urlPatterns = "/ads/show")
public class ShowAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long singleAd = Long.parseLong(request.getParameter("showAd"));


        Ad viewSingleAd = null;
        try {
            viewSingleAd = DaoFactory.getAdsDao().adsByAdId(singleAd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("ad", viewSingleAd);
        request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
    }

}

