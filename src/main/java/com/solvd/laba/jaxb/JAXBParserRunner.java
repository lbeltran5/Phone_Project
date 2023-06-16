package com.solvd.laba.jaxb;

import com.solvd.laba.database.model.*;

import javax.xml.bind.*;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JAXBParserRunner {
    private static final Logger LOGGER = Logger.getLogger(JAXBParserRunner.class.getName());

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
                    LOGGER.log(Level.INFO, "Phone ID: {0}", phoneId);
                    LOGGER.log(Level.INFO, "Brand Name: {0}", brandName);
                    LOGGER.log(Level.INFO, "Phone Model: {0}", phoneModel);
                    LOGGER.log(Level.INFO, "Operating System Name: {0}", osName);
                    LOGGER.log(Level.INFO, "Features: {0}", features);
                    LOGGER.log(Level.INFO, "Brand Foundation Date: {0}", brandDate);
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
