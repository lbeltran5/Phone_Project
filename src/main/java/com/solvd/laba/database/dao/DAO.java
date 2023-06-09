package com.solvd.laba.database.dao;

import java.sql.SQLException;
import java.util.*;

public interface DAO<T> {
    List<T> getAll() throws SQLException;
    void create(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
    T getById(int id) throws SQLException;
}


