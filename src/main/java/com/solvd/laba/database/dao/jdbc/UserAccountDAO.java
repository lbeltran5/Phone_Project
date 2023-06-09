package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.interfacedao.*;
import com.solvd.laba.database.model.*;

import java.sql.*;
import java.util.*;

public class UserAccountDAO implements UserAccountInterfaceDao {

    @Override
    public List<UserAccountModel> getAll() throws SQLException {
        return null;
    }

    @Override
    public UserAccountModel getById(int id) throws SQLException {
        return null;
    }

    @Override
    public int create(UserAccountModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int update(UserAccountModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int save(UserAccountModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int insert(UserAccountModel entity) throws SQLException {
        return 0;
    }
}
