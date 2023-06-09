package com.solvd.laba.database.service.implementation;

import com.solvd.laba.database.dao.*;
import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;

import java.sql.*;
import java.util.*;

public class BrandService implements GenericService<BrandModel> {
    private final DAO<BrandModel> brandDAO;

    public BrandService(DAO<BrandModel> brandDAO) {
        this.brandDAO = brandDAO;
    }

    @Override
    public List<BrandModel> getAll() throws SQLException {
        return brandDAO.getAll();
    }

    @Override
    public void create(BrandModel entity) throws SQLException {
        brandDAO.create(entity);
    }

    @Override
    public void update(BrandModel entity) throws SQLException {
        brandDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        brandDAO.delete(id);
    }

    @Override
    public BrandModel getById(int id) throws SQLException {
        return brandDAO.getById(id);
    }
}
