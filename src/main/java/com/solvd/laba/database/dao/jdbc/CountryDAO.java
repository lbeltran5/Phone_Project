package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends AbstractDAO implements DAO<CountryModel> {
    private static final Logger LOGGER = LogManager.getLogger(CountryDAO.class);
    private final Connection connection;

    public CountryDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public List<CountryModel> getAll() throws SQLException {
        List<CountryModel> countries = new ArrayList<>();
        String query = "SELECT * FROM country";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                CountryModel country = extractCountryFromResultSet(resultSet);
                countries.add(country);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving a country: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
        return countries;
    }

    @Override
    public void create(CountryModel country) throws SQLException {
        String query = "INSERT INTO country (country_id, country_name) VALUES (?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, country.getCountryId()); // Use a unique value or auto-incrementing value
            statement.setString(2, country.getCountryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while creating a country: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void update(CountryModel country) throws SQLException {
        String query = "UPDATE country SET country_name = ? WHERE country_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getCountryName()); // Corrected method from setInt to setString
            statement.setInt(2, country.getCountryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while updating a country: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void delete(int countryId) throws SQLException {
        String deletePhonesQuery = "DELETE FROM phone WHERE country_id = ?";
        String deleteBrandQuery = "DELETE FROM country WHERE country_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement deletePhonesStatement = connection.prepareStatement(deletePhonesQuery);
            deletePhonesStatement.setInt(1, countryId);
            deletePhonesStatement.executeUpdate();

            PreparedStatement deleteBrandStatement = connection.prepareStatement(deleteBrandQuery);
            deleteBrandStatement.setInt(1, countryId);
            deleteBrandStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while deleting a country: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    public CountryModel getById(int id) throws SQLException {
        String query = "SELECT * FROM country WHERE country_id = ?";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractCountryFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving a country: ", e);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return null; // Return null if the brand is not found
    }

    private CountryModel extractCountryFromResultSet(ResultSet resultSet) throws SQLException {
        int countryId = resultSet.getInt("country_id");
        String countryName = resultSet.getString("country_name");
        return new CountryModel(countryId, countryName);
    }
}
