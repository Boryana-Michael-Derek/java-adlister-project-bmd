//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Ad;
//import com.codeup.adlister.models.User;
//import com.codeup.adlister.util.Password;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebServlet(name = "controllers.ShowAdServlet", urlPatterns = "/ads/show")
//public class ShowAdServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("ads", DaoFactory.getAdsDao().all())
//        request.getRequestDispatcher("/WEB-INF/ads/index.jsp");
//        Ad ad = DaoFactory.getAdsDao().showOneAd(id);
//
//
//
//
//    }
//
//
//
//}
