package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO extends AbstractDAO implements DAO<UserAccountModel> {
    private static final Logger LOGGER = LogManager.getLogger(UserAccountDAO.class);
    private final Connection connection;

    public UserAccountDAO(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    @Override
    public List<UserAccountModel> getAll() throws SQLException {
        List<UserAccountModel> accounts = new ArrayList<>();
        String query = "SELECT * FROM useraccount";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                UserAccountModel userAccount = extractUserAccountFromResultSet(resultSet);
                accounts.add(userAccount);
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving brands: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
        return accounts;
    }

    @Override
    public void create(UserAccountModel userAccount) throws SQLException {
        String query = "INSERT INTO useraccount (user_id, user_name, user_email, user_comment) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userAccount.getUserId()); // Use a unique value or auto-incrementing value
            statement.setString(2, userAccount.getUserName());
            statement.setString(3, userAccount.getUserEmail());
            statement.setString(4, userAccount.getUserComment());
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
    public void update(UserAccountModel userAccount) throws SQLException {
        String query = "UPDATE useraccount SET user_name = ? WHERE user_id = ?";
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userAccount.getUserId());
            statement.setString(2, userAccount.getUserName());
            statement.setString(3,userAccount.getUserEmail());
            statement.setString(4, userAccount.getUserComment());
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
    public void delete(int userId) throws SQLException {
        String deleteBrandQuery = "DELETE FROM useraccount WHERE user_id = ?";
        String deletePhonesQuery = "DELETE FROM phone WHERE user_id = ?";

        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().retrieve();
            PreparedStatement deletePhonesStatement = connection.prepareStatement(deletePhonesQuery);
            deletePhonesStatement.setInt(1, userId);
            deletePhonesStatement.executeUpdate();

            PreparedStatement deleteBrandStatement = connection.prepareStatement(deleteBrandQuery);
            deleteBrandStatement.setInt(1, userId);
            deleteBrandStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurred while deleting a User Name: ", e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().putback(connection);
            }
        }
    }



    public UserAccountModel getById(int id) throws SQLException {
        String query = "SELECT * FROM useraccount WHERE user_id = ?";
        try (Connection connection = ConnectionPool.getInstance().retrieve();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractUserAccountFromResultSet(resultSet); // Corrected method call
            }
        } catch (SQLException e) {
            LOGGER.error("Error occurred while retrieving a brand: ", e);
        } finally {
            ConnectionPool.getInstance().putback(connection);
        }
        return null; // Return null if the brand is not found
    }

    private UserAccountModel extractUserAccountFromResultSet(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        String userName = resultSet.getString("user_name");
        String userEmail = resultSet.getString("user_email");
        String userComment = resultSet.getString("user_comment");
        return new UserAccountModel(userId, userName, userEmail, userComment); // Assuming UserAccountModel constructor
    }

}
