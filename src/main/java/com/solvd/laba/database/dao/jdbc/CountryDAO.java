package com.solvd.laba.database.dao.jdbc;

import com.solvd.laba.database.interfacedao.*;
import com.solvd.laba.database.model.*;

import java.sql.*;
import java.util.*;

public class CountryDAO implements CountryInterfaceDao {
    @Override
    public List<CountryModel> getAll() throws SQLException {
        return null;
    }

    @Override
    public CountryModel getById(int id) throws SQLException {
        return null;
    }

    @Override
    public int create(CountryModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int update(CountryModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int save(CountryModel entity) throws SQLException {
        return 0;
    }

    @Override
    public int insert(CountryModel entity) throws SQLException {
        return 0;
    }
}
