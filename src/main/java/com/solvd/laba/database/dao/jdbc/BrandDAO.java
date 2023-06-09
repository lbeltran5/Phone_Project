package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO extends AbstractDAO implements DAO<BrandModel> {
    private static final Logger LOGGER = LogManager.getLogger(BrandDAO.class);
    private final Connection connection;

    public BrandDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public List<BrandModel> getAll() throws SQLException {
        List<BrandModel> brands = new ArrayList<>();
        String query = "SELECT * FROM brand";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                BrandModel brand = extractBrandFromResultSet(resultSet);
                brands.add(brand);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving brands: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
        return brands;
    }

    @Override
    public void create(BrandModel brand) throws SQLException {
        String query = "INSERT INTO brand (brand_id, brand_name) VALUES (?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, brand.getBrandId()); // Use a unique value or auto-incrementing value
            statement.setString(2, brand.getBrandName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while creating a brand: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void update(BrandModel brand) throws SQLException {
        String query = "UPDATE brand SET brand_name = ? WHERE brand_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, brand.getBrandName());
            statement.setInt(2, brand.getBrandId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while updating a brand: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void delete(int brandId) throws SQLException {
        String deletePhonesQuery = "DELETE FROM phone WHERE brand_id = ?";
        String deleteBrandQuery = "DELETE FROM brand WHERE brand_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement deletePhonesStatement = connection.prepareStatement(deletePhonesQuery);
            deletePhonesStatement.setInt(1, brandId);
            deletePhonesStatement.executeUpdate();

            PreparedStatement deleteBrandStatement = connection.prepareStatement(deleteBrandQuery);
            deleteBrandStatement.setInt(1, brandId);
            deleteBrandStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while deleting a brand: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }


    public BrandModel getById(int id) throws SQLException {
        String query = "SELECT * FROM brand WHERE brand_id = ?";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractBrandFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving a brand: ", e);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return null; // Return null if the brand is not found
    }


    private BrandModel extractBrandFromResultSet(ResultSet resultSet) throws SQLException {
        int brandId = resultSet.getInt("brand_id");
        String brandName = resultSet.getString("brand_name");
        return new BrandModel(brandId, brandName);
    }
}

