package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    List<Ad> adsById(Long id) throws SQLException;

    //    Ad showOneAd(long id);

    Ad adsByAdId(Long id) throws SQLException;

    Ad findAdByAdId(Long id);

    void updateAd(Ad ad);

    List<Ad> adsByUserId(Long id) throws SQLException;

    List<Ad> searchAds(String search) throws SQLException;


    void editAd(Ad ad);
}
