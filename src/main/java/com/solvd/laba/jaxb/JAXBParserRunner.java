package com.solvd.laba.jaxb;

import com.solvd.laba.database.model.*;

import javax.xml.bind.*;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

public class JAXBParserRunner {
    private static final Logger LOGGER = Logger.getLogger(JAXBParserRunner.class.getName());

    //LOGGER format with time stamp
    static {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.INFO);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });

        LOGGER.addHandler(handler);
    }

    public static void main(String[] args) {
        URL resourceUrl = JAXBParserRunner.class.getClassLoader().getResource("phone.xml");
        if (resourceUrl != null) {
            String filePath = resourceUrl.getPath();

            // Parse the XML file
            PhoneData phoneData = parseXML(filePath);

            if (phoneData != null) {
                // Retrieve the list of phones
                List<PhoneModel> phones = phoneData.getPhones();

                // Print the details of each phone
                for (PhoneModel phone : phones) {
                    int phoneId = phone.getPhoneId();
                    String phoneModel = phone.getPhoneModel();
                    List<String> features = phone.getFeatures();
                    int brandId = phone.getBrandId();
                    int osId = phone.getOsId();

                    // Retrieve brand information
                    BrandModel brand = phoneData.getBrandById(brandId);
                    String brandName = brand.getBrandName();
                    Date brandDate = brand.getBrandFoundationDate();

                    // Retrieve operating system information
                    OperatingSystemModel os = phoneData.getOperatingSystemById(osId);
                    String osName = os.getOperatingSysName();

                    // Log the extracted information
                    LOGGER.log(Level.INFO, "Phone ID: " + phoneId);
                    LOGGER.log(Level.INFO, "Brand Name: " + brandName);
                    LOGGER.log(Level.INFO, "Phone Model: " + phoneModel);
                    LOGGER.log(Level.INFO, "Operating System Name: " + osName);
                    LOGGER.log(Level.INFO, "Features: " + features);
                    LOGGER.log(Level.INFO, "Brand Foundation Date: " + brandDate);
                    LOGGER.log(Level.INFO, "------------------------------------------------");


                }
            }
        } else {
            LOGGER.log(Level.SEVERE, "phone.xml file not found in the resources package.");
        }
    }

    private static PhoneData parseXML(String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(PhoneData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (PhoneData) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, "Error while parsing XML: {0}", e.getMessage());
            return null;
        }
    }
}
