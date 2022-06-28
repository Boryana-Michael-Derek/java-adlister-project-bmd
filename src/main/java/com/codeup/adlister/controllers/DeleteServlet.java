package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.DeleteServlet", urlPatterns = "/delete/*")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        long id = Long.parseLong(request.getPathInfo().substring(1));
        request.setAttribute("id", id);
        System.out.println("id is " + id);
//        Ad ad = null;
//        try {
//            ad = DaoFactory.getAdsDao().adsByAdId(id);
            DaoFactory.getAdsDao().delete(id);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        response.sendRedirect("/ads");

    }
}

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//
//        long editAdId = Long.parseLong(request.getPathInfo().substring(1));
////            long editAdId = Long.parseLong(request.getParameter("editAd"));
//        long editUserId = user.getId();
//        String editTitle = request.getParameter("title");
//        String editDescription = request.getParameter("description");
//
//        Ad ad = DaoFactory.getAdsDao().findAdByAdId(editAdId);
//        ad.setTitle(editTitle);
//        ad.setDescription(editDescription);
//
////            Ad ad = new Ad(editAdId,
////                    user.getId(),
////                    request.getParameter("title"),
////                    request.getParameter("description")
////            );
//
//        DaoFactory.getAdsDao().updateAd(ad);
//        request.setAttribute("ad", DaoFactory.getAdsDao().findAdByAdId(ad.getId()));
//        request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
//        response.sendRedirect("/ads");
//    }
//}