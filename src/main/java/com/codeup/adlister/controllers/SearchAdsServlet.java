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

@WebServlet(name = "SearchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse result) throws IOException, ServletException {

        request.setAttribute("adList", request.getSession().getAttribute("search"));
        request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, result);
    }


}