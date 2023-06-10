package com.solvd.laba.database.service.implementation;

import com.solvd.laba.database.dao.DAO;
import com.solvd.laba.database.model.UserAccountModel;
import com.solvd.laba.database.service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class UserAccountService implements GenericService<UserAccountModel> {
    private final DAO<UserAccountModel> userAccountDAO;

    public UserAccountService(DAO<UserAccountModel> userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    @Override
    public List<UserAccountModel> getAll() throws SQLException {
        return userAccountDAO.getAll();
    }

    @Override
    public void create(UserAccountModel entity) throws SQLException {
        userAccountDAO.create(entity);
    }

    @Override
    public void update(UserAccountModel entity) throws SQLException {
        userAccountDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        userAccountDAO.delete(id);
    }

    @Override
    public UserAccountModel getById(int id) throws SQLException {
        return userAccountDAO.getById(id);
    }
}
