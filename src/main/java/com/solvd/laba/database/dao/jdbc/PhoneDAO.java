package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.interfacedao.*;
import com.solvd.laba.database.model.*;

import java.sql.*;
import java.util.*;

public class PhoneDAO implements PhoneInterfaceDao {

    ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public void createPhone(int phone_id, int brand_id, int os_id, String phone_model, double price, String country_id, int processor_id) {
        Connection connection = pool.getConnection();
        String createStatement = "INSERT INTO phone (phone_id, brand_id, os_id, phone_model, price, country_id, processor_id) values (9, 9, 9, Mexico, 506, United States, 8);";
        PreparedStatement create = null;
        try{
            create = connection.prepareStatement(createStatement);
            create.setInt(9, phone_id);
            create.setInt(9, brand_id);
            create.setInt(9, os_id);
            create.setString(9, phone_model);
            create.setDouble(9, price);
            create.setString(9, country_id);
            create.setInt(9, processor_id);
            create.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            pool.putback(connection);
        }
    }

    // CRUD - Retrieve
    @Override
    public PhoneModel getById(int phone_id) throws SQLException {
        Connection connection = pool.retrieve();
        ResultSet resultSet = null;

        PhoneModel phonemodel = new PhoneModel();
        String selectStatement = "SELECT * from phone"
        PhoneModel phonemodel = null;

        String sql = "SELECT phone_id,brand_id,os_id,phone_model,price,country_id,processor_id WHERE phone_id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, phone_id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int phoneId = rs.getInt("phone_id");
            int brandId = rs.getInt("brand_id");
            int osId = rs.getInt("os_id");
            String phoneModel = rs.getInt("phone_model");
            double price = rs.getInt("price");
            String countryId = rs.getInt("country_id");
            int processorId = rs.getInt("processor_id");

            phone = new PhoneModel(phoneId,brandId,osId,phoneModel,price,countryId,processorId);
        }
        return PhoneModel;
    }

    // CRUD - Retrieve All
    @Override
    public List<PhoneModel> getAll() throws SQLException {
        return null;
    }

    @Override
    public int update(PhoneModel phoneModel) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int save(PhoneModel phoneModel) throws SQLException {
        return 0;
    }

    @Override
    public int insert(PhoneModel entity) throws SQLException {
        return 0;
    }
}
