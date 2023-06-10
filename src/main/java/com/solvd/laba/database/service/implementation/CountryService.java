package com.solvd.laba.database.service.implementation;

import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;

import java.sql.*;
import java.util.*;

public class CountryService implements GenericService<CountryModel> {
    private final DAO<CountryModel> countryDAO;

    public CountryService(DAO<CountryModel> countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<CountryModel> getAll() throws SQLException {
        return countryDAO.getAll();
    }

    @Override
    public void create(CountryModel entity) throws SQLException {
        countryDAO.create(entity);
    }

    @Override
    public void update(CountryModel entity) throws SQLException {
        countryDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        countryDAO.delete(id);
    }

    @Override
    public CountryModel getById(int id) throws SQLException {
        return countryDAO.getById(id); // Corrected method call
    }
}
