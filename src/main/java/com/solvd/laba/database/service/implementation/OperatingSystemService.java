package com.solvd.laba.database.service.implementation;

import com.solvd.laba.database.dao.DAO;
import com.solvd.laba.database.model.OperatingSystemModel;
import com.solvd.laba.database.service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class OperatingSystemService implements GenericService<OperatingSystemModel> {
    private final DAO<OperatingSystemModel> operatingSystemDAO;

    public OperatingSystemService(DAO<OperatingSystemModel> operatingSystemDAO) {
        this.operatingSystemDAO = operatingSystemDAO;
    }

    @Override
    public List<OperatingSystemModel> getAll() throws SQLException {
        return operatingSystemDAO.getAll();
    }

    @Override
    public void create(OperatingSystemModel entity) throws SQLException {
        operatingSystemDAO.create(entity);
    }

    @Override
    public void update(OperatingSystemModel entity) throws SQLException {
        operatingSystemDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        operatingSystemDAO.delete(id);
    }

    @Override
    public OperatingSystemModel getById(int id) throws SQLException {
        return operatingSystemDAO.getById(id);
    }
}
