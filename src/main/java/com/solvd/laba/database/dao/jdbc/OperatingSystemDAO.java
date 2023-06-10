package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperatingSystemDAO extends AbstractDAO implements DAO<OperatingSystemModel> {
    private static final Logger LOGGER = LogManager.getLogger(OperatingSystemDAO.class);
    private final Connection connection;

    public OperatingSystemDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public List<OperatingSystemModel> getAll() throws SQLException {
        List<OperatingSystemModel> operatingSystems = new ArrayList<>();
        String query = "SELECT * FROM operatingsystem";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                OperatingSystemModel operatingSystem = extractOperatingSystemFromResultSet(resultSet);
                operatingSystems.add(operatingSystem);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving Operating System: ", e);
        }
        return operatingSystems;
    }
    @Override
    public void create(OperatingSystemModel operatingSystem) throws SQLException {
        String query = "INSERT INTO operatingsystem (os_id, operating_sys_name) VALUES (?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, operatingSystem.getOsId()); // Use a unique value or auto-incrementing value
            statement.setString(2, operatingSystem.getOperatingSysName());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while creating an operating system: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void update(OperatingSystemModel operatingSystem) throws SQLException {
        String query = "UPDATE operatingsystem SET operating_sys_name = ? WHERE os_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, operatingSystem.getOperatingSysName());
            statement.setInt(2, operatingSystem.getOsId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while updating an operating system: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    @Override
    public void delete(int osId) throws SQLException {
        String deletePhonesQuery = "DELETE FROM operating_sys WHERE os_id = ?";
        String deleteBrandQuery = "DELETE FROM phone WHERE os_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement deletePhonesStatement = connection.prepareStatement(deletePhonesQuery);
            deletePhonesStatement.setInt(1, osId);
            deletePhonesStatement.executeUpdate();

            PreparedStatement deleteBrandStatement = connection.prepareStatement(deleteBrandQuery);
            deleteBrandStatement.setInt(1, osId);
            deleteBrandStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred whiledeleting an operating system: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }

    public OperatingSystemModel getById(int id) throws SQLException {
        String query = "SELECT * FROM operatingsystem WHERE os_id = ?";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractOperatingSystemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving an operating system: ", e);
        }
        return null; // Return null if the operating system is not found
    }

    private OperatingSystemModel extractOperatingSystemFromResultSet(ResultSet resultSet) throws SQLException {
        int osId = resultSet.getInt("os_id");
        String operatingSysName = resultSet.getString("operating_sys_name");
        return new OperatingSystemModel(osId, operatingSysName);
    }
}

