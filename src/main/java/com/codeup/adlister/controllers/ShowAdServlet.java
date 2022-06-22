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
//@WebServlet("/ads/show")
//public class ShowAdServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long id = Long.parseLong(req.getParameter("id"));
//        System.out.println(id);
//
//        Ad ad = DaoFactory.getAdsDao().showOneAd(id);
//
//        req.setAttribute("ad", ad);
//
//        req.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(req, resp);
//    }
//}
