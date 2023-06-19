package com.solvd.laba.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.database.model.*;
import com.solvd.laba.jaxb.*;

import java.io.File;
import java.util.Objects;
import java.util.logging.*;

public class JSONParserRunner {
    private static final Logger LOGGER = Logger.getLogger(JSONParserRunner.class.getName());

    public static void main(String[] args) {

        //LOGGER with simple formatter
        try {
            // Configure logger format
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            for (Handler handler : handlers) {
                if (handler instanceof ConsoleHandler) {
                    handler.setFormatter(new SimpleFormatter() {
                        @Override
                        public synchronized String format(LogRecord record) {
                            return String.format(record.getMessage(), record.getParameters()) + System.lineSeparator();
                        }
                    });
                }
            }

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file and parse its contents into PhoneData object
            String filePath = Objects.requireNonNull(JSONParserRunner.class.getClassLoader().getResource("phone.json")).getFile();
            PhoneData phoneData = objectMapper.readValue(new File(filePath), PhoneData.class);

            // Loop through all phones and output their details
            LOGGER.log(Level.INFO, "JSON file phone details:");
            for (PhoneModel phoneModel : phoneData.getPhones()) {
                BrandModel brandModel = phoneData.getBrandById(phoneModel.getBrandId());
                OperatingSystemModel operatingSystemModel = phoneData.getOperatingSystemById(phoneModel.getOsId());

                LOGGER.log(Level.INFO, "ID: %d", phoneModel.getPhoneId());
                LOGGER.log(Level.INFO, "Brand Name: %s", brandModel.getBrandName());
                LOGGER.log(Level.INFO, "Phone Model: %s", phoneModel.getPhoneModel());
                LOGGER.log(Level.INFO, "Operating System Name: %s", operatingSystemModel.getOperatingSysName());
                LOGGER.log(Level.INFO, "Features: %s", phoneModel.getFeatures());
                LOGGER.log(Level.INFO, "Brand Date: %s", brandModel.getBrandFoundationDate());
                LOGGER.log(Level.INFO, "-------------------------");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred while parsing the JSON file.", e);
        }
    }
}
