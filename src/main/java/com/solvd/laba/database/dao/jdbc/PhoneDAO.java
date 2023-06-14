package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO extends AbstractDAO implements DAO<PhoneModel> {
    private static final Logger LOGGER = LogManager.getLogger(PhoneDAO.class);
    private final Connection connection;

    public PhoneDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public List<PhoneModel> getAll() throws SQLException {
        List<PhoneModel> phones = new ArrayList<>();

        String query = "SELECT * FROM phone";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                PhoneModel phone = mapResultSetToPhoneModel(resultSet);
                phones.add(phone);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving brands: ", e);
        }
        return phones;
    }

    @Override
    public void create(PhoneModel entity) throws SQLException {
        String query = "INSERT INTO phone (brand_id, os_id, phone_model, price) VALUES (?, ?, ?, ?);";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, entity.getBrandId());
            statement.setInt(2, entity.getOsId());
            statement.setString(3, entity.getPhoneModel());
            statement.setDouble(4, entity.getPrice());
            statement.executeUpdate();

            // Retrieve the generated phone_id value
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    entity.setPhoneId(generatedId); // Set the generated phone_id value in the PhoneModel object
                } else {
                    LOGGER.error("Failed to retrieve the generated phone_id value.");
                    // Handle the failure case according to your application's requirements
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while creating a brand: ", e);
        }
    }



    @Override
    public void update(PhoneModel entity) throws SQLException {
        String query = "UPDATE phone SET brand_id = ?, os_id = ?, phone_model = ?, price = ? WHERE phone_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, entity.getBrandId());
            statement.setInt(2, entity.getOsId());
            statement.setString(3, entity.getPhoneModel());
            statement.setDouble(4, entity.getPrice());
            statement.setInt(5, entity.getPhoneId());
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
    public void delete(int id) throws SQLException {
        String deletePhonesQuery = "DELETE FROM phone WHERE phone_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement deletePhonesStatement = connection.prepareStatement(deletePhonesQuery);
            deletePhonesStatement.setInt(1, id);
            deletePhonesStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while deleting a brand: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    public PhoneModel getById(int id) throws SQLException {
        String query = "SELECT * FROM phone WHERE phone_id = ?";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToPhoneModel(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving a brand: ", e);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return null; // Return null if the brand is not found
    }

    private PhoneModel mapResultSetToPhoneModel(ResultSet resultSet) throws SQLException {
        int brandId = resultSet.getInt("brand_id");
        int phoneId = resultSet.getInt("phone_id");
        int osId = resultSet.getInt("os_id");
        String phoneModel = resultSet.getString("phone_model");
        double price = resultSet.getDouble("price");
        return new PhoneModel(phoneId, brandId, osId, phoneModel, price);
    }
}
