package com.solvd.laba.database;

import com.solvd.laba.database.dao.DAO;
import com.solvd.laba.database.dao.jdbc.*;
import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;
import com.solvd.laba.database.service.implementation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.*;

public class DataBaseConnection {
    private static final Logger LOGGERS = Logger.getLogger(DataBaseConnection.class.getName());

    public static void main(String[] args) {
        // Retrieve a connection from the connection pool
        Connection connection = ConnectionPool.getInstance().retrieve();

        // Create instances of the desired DAOs for the specific tables
        DAO<BrandModel> brandDAO = new BrandDAO(connection);
        DAO<CountryModel> countryDAO = new CountryDAO(connection);
        DAO<OperatingSystemModel> operatingSystemDAO = new OperatingSystemDAO(connection);
        DAO<PhoneModel> phoneDAO = new PhoneDAO(connection);
        //DAO<UserAccountModel> userAccountDAO = new UserAccountDAO(connection);

        // Create instances of the desired services for the specific tables
        GenericService<BrandModel> brandService = new BrandService(brandDAO);
        GenericService<CountryModel> countryService = new CountryService(countryDAO);
        GenericService<OperatingSystemModel> operatingSystemService = new OperatingSystemService(operatingSystemDAO);
        GenericService<PhoneModel> phoneService = new PhoneService(phoneDAO);
        //GenericService<UserAccountModel> userAccountService = new UserAccountService(userAccountDAO);

        try {
            //BRANDS
            // Get all brands
            List<BrandModel> brands = brandDAO.getAll();
            for (BrandModel brand : brands) {
                LOGGERS.info(brand.toString());
            }

            //PHONES
            // Perform similar operations for the Phone table
            List<PhoneModel> phones = phoneDAO.getAll();
            for (PhoneModel phone : phones) {
                LOGGERS.info(phone.toString());
            }

            List<CountryModel> countries = countryDAO.getAll();
            for (CountryModel country : countries){
                LOGGERS.info(country.toString());
            }

            List<OperatingSystemModel> OpSys = operatingSystemDAO.getAll();
            for (OperatingSystemModel operatingSystem : OpSys){
                LOGGERS.info(operatingSystem.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Put back the connection to the connection pool
            ConnectionPool.getInstance().putback(connection);
        }
    }
}
