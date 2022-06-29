//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Ad;
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MySQLAdsDao implements Ads {
//    private Connection connection = null;
//
//    public MySQLAdsDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                config.getUrl(),
//                config.getUser(),
//                config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    }
//
//    @Override
//    public List<Ad> all() {
//        PreparedStatement stmt = null;
//        try {
//            stmt = connection.prepareStatement("SELECT * FROM ads");
//            ResultSet rs = stmt.executeQuery();
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
//
//    @Override
//    public Long insert(Ad ad) {
//        try {
//            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
//
//    @Override
//    public Long updateAd(Ad ad) {
//        try {
//            String insertQuery = "UPDATE ads SET user_id = ?, title = ?, description = ? WHERE id = ?";
//            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//            stmt.setLong(4, ad.getId());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error editing an existing ad.", e);
//        }
//    }
//
//    @Override
//    public List<Ad> searchAds(String search) throws SQLException {
//        String searchQuery = "SELECT * FROM ads AS a JOIN ads_categories AS ac ON a.id = ac.ads_id JOIN categories AS c ON ac.categories_id = c.id WHERE c.category LIKE ? OR a.title LIKE ? OR a.description LIKE ?";
//
//            String searchTerm = "%" + search + "%";
//            PreparedStatement statement = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, searchTerm);
//            statement.setString(2, searchTerm);
//            statement.setString(3, searchTerm);
//            ResultSet rs = statement.executeQuery();
//            return createAdsFromResults(rs);
//    }
//
//    public List<Ad> adsByUserId(Long id) throws SQLException {
//        String query = "SELECT * FROM ads WHERE user_id = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setLong(1, id);
//        ResultSet rs = statement.executeQuery();
//        return createAdsFromResults(rs);
//    }
//
//    public Ad adsByAdId(Long id) throws SQLException {
//        String query = "SELECT * FROM ads WHERE _id = ? LIMIT 1";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setLong(1, id);
//        ResultSet rs = statement.executeQuery();
//        Ad ad = extractAd(rs);
//        return ad;
//    }
//
//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(
//            rs.getLong("id"),
//            rs.getLong("user_id"),
//            rs.getString("title"),
//            rs.getString("description")
//        );
//    }
//
//    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        while (rs.next()) {
//            ads.add(extractAd(rs));
//        }
//        return ads;
//    }
//
//    @Override
//    public Ad findAdByAdId(long id) {
//        System.out.println(id);
//        String sql = "SELECT * FROM ads WHERE id = ?;";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setLong(1, id);
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            return extractAd(rs);
//
//        } catch (SQLException e) {
//
//            throw new RuntimeException("Error finding ad by id", e);
//
//        }
//    }
//
//    @Override
//    public void editAd(Ad ad) {
//        try {
//            String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
//            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, ad.getTitle());
//            statement.setString(2, ad.getDescription());
//            statement.setLong(3, ad.getId());
//            statement.executeUpdate();
//        } catch (SQLException e){
//            throw new RuntimeException("(MySQLAdsDao; editAd method): Error updating ad in database", e);
//        }
//    }
//
//
//}
//
//

package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public List<Ad> adsByUserId(Long id) throws SQLException {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        return createAdsFromResults(rs);
    }


    @Override
    public List<Ad> searchAds(String search) throws SQLException {
        String searchQuery = "SELECT * FROM ads AS a LEFT JOIN ads_categories AS ac ON a.id = ac.ads_id JOIN categories AS c ON ac.categories_id = c.id WHERE c.category LIKE ? OR a.title LIKE ? OR a.description LIKE ?";
        String searchTerm = "%" + search + "%";

        PreparedStatement statement = connection.prepareStatement(searchQuery);
        //PreparedStatement statement = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, searchTerm);
        statement.setString(2, searchTerm);
        statement.setString(3, searchTerm);
        ResultSet rs = statement.executeQuery();
//        rs.next();
        return createAdsFromResults(rs);
    }


    @Override
    public void editAd(Ad ad) {

    }


    public List<Ad> adsById(Long id) throws SQLException {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        return createAdsFromResults(rs);
    }

        @Override
        public Ad adsByAdId(Long id) throws SQLException {
        String query = "SELECT * FROM ads WHERE id = ? LIMIT 1;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
            Ad ad = new Ad();
            while(rs.next()){
        ad = extractAd(rs);
            }
        return ad;
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public Ad findAdByAdId(Long id) {
        System.out.println(id);
        String sql = "SELECT * FROM ads WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);

        } catch (SQLException e) {

            throw new RuntimeException("Error finding ad by id", e);

        }
    }

    @Override
    public void updateAd(Ad ad) {
        try {
            String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?;";
//            update ads_categories set ad_id and categories_ic where =.....
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setLong(3, ad.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error updating ads in MySQLAdsDao", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String insertQuery = "DELETE FROM ads_categories WHERE ads_id = ?;";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            String insertQuery2 = "DELETE FROM ads WHERE id = ?;";
            PreparedStatement stmt2 = connection.prepareStatement(insertQuery2, Statement.RETURN_GENERATED_KEYS);
            stmt2.setLong(1, id);
            stmt2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }


    public static void main(String[] args) throws SQLException {
        Ad ad = DaoFactory.getAdsDao().adsByAdId(1L);
        System.out.println(ad);
        System.out.println(ad.getTitle() + " " + ad.getDescription());
    }
}