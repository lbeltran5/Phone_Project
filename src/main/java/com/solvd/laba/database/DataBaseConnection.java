package com.solvd.laba.database;

import com.solvd.laba.database.*;
import com.solvd.laba.database.dao.DAO;
import com.solvd.laba.database.dao.jdbc.*;
import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;
import com.solvd.laba.database.service.implementation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DataBaseConnection {
    public static void main(String[] args) {

        // Retrieve a connection from the connection pool
        Connection connection = ConnectionPool.getInstance().retrieve();

        // Create instances of the desired DAOs for the specific tables
        DAO<BrandModel> brandDAO = new BrandDAO(connection);
        DAO<CountryModel> countryDAO = new CountryDAO(connection);
        DAO<OperatingSystemModel> operatingSystemDAO = new OperatingSystemDAO(connection);
        DAO<PhoneModel> phoneDAO = new PhoneDAO(connection);
        DAO<UserAccountModel> userAccountDAO = new UserAccountDAO(connection);

        // Create instances of the desired services for the specific tables
        GenericService<BrandModel> brandService = new BrandService(brandDAO);
        GenericService<CountryModel> countryService = new CountryService(countryDAO);
        GenericService<OperatingSystemModel> operatingSystemService = new OperatingSystemService(operatingSystemDAO);
        GenericService<PhoneModel> phoneService = new PhoneService(phoneDAO);
        GenericService<UserAccountModel> userAccountService = new UserAccountService(userAccountDAO);

        try {
            // Get all brands
            List<BrandModel> brands = brandDAO.getAll();
            for (BrandModel brand : brands) {
                System.out.println(brand);
            }

            // Create a new brand
            BrandModel newBrand = new BrandModel(18, "Honor"); // Replace 1 with the appropriate brandId value
            brandService.create(newBrand);

            // Update a brand
            BrandModel existingBrand = brandDAO.getById(10);
            if (existingBrand != null) {
                existingBrand.setBrandName("Doro");
                brandService.update(existingBrand);
            } else {
                System.out.println("Brand not found!");
            }

            // Perform similar operations for the Country table
            List<CountryModel> countries = countryDAO.getAll();
            for (CountryModel country : countries) {
                System.out.println(country);
            }

            CountryModel newCountry = new CountryModel(15, "United States");
            countryService.create(newCountry);

            //TO update Country
            CountryModel existingCountry = countryDAO.getById(2);
            if (existingCountry != null) {
                existingCountry.setCountryName("Canada");
                countryService.update(existingCountry);
            } else {
                System.out.println("Country not found!");
            }

            // Perform similar operations for the OperatingSystem table
            List<OperatingSystemModel> operatingSystems = operatingSystemDAO.getAll();
            for (OperatingSystemModel os : operatingSystems) {
                System.out.println(os);
            }

            OperatingSystemModel newOS = new OperatingSystemModel(9, "Windows");
            operatingSystemService.create(newOS);

            OperatingSystemModel existingOS = operatingSystemDAO.getById(2);
            if (existingOS != null) {
                existingOS.setOperatingSysName("Linux");
                operatingSystemService.update(existingOS);
            } else {
                System.out.println("Operating System not found!");
            }

            // Perform similar operations for the Phone table
            List<PhoneModel> phones = phoneDAO.getAll();
            for (PhoneModel phone : phones) {
                System.out.println(phone);
            }

            PhoneModel newPhone = new PhoneModel(9, 9, 9, "Oppo", 852.0);
            phoneService.create(newPhone);

            PhoneModel existingPhone = phoneDAO.getById(2);
            if (existingPhone != null) {
                existingPhone.setPhoneModel("Galaxy");
                phoneService.update(existingPhone);
            } else {
                System.out.println("Phone not found!");
            }

            // Perform similar operations for the UserAccount table
            List<UserAccountModel> userAccounts = userAccountDAO.getAll();
            for (UserAccountModel userAccount : userAccounts) {
                System.out.println(userAccount);
            }

            UserAccountModel newUserAccount = new UserAccountModel(1, "Doe", "doe@example.com","Great Phone");
            userAccountService.create(newUserAccount);

            UserAccountModel existingUserAccount = userAccountDAO.getById(2);
            if (existingUserAccount != null) {
                existingUserAccount.setUserName("JaneSmith");
                userAccountService.update(existingUserAccount);
            } else {
                System.out.println("User Account not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Put back the connection to the connection pool
            ConnectionPool.getInstance().putback(connection);
        }
    }
}