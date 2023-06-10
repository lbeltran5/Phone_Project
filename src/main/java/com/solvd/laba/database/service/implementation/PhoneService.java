package com.solvd.laba.database.service.implementation;

import com.solvd.laba.database.dao.DAO;
import com.solvd.laba.database.model.PhoneModel;
import com.solvd.laba.database.service.GenericService;

import java.sql.SQLException;
import java.util.List;

public class PhoneService implements GenericService<PhoneModel> {
    private final DAO<PhoneModel> phoneDAO;

    public PhoneService(DAO<PhoneModel> phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public List<PhoneModel> getAll() throws SQLException {
        return phoneDAO.getAll();
    }

    @Override
    public void create(PhoneModel entity) throws SQLException {
        phoneDAO.create(entity);
    }

    @Override
    public void update(PhoneModel entity) throws SQLException {
        phoneDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        phoneDAO.delete(id);
    }

    @Override
    public PhoneModel getById(int id) throws SQLException {
        return phoneDAO.getById(id);
    }
}
