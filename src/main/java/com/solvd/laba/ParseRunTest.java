package com.solvd.laba;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.IOException;
import java.io.InputStream;

public class ParseRunTest {
    public static void main(String[] args) {
        // Loading the XML file
        InputStream xmlStream = ParserRunner.class.getClassLoader().getResourceAsStream("phone.xml");
        if (xmlStream == null) {
            throw new RuntimeException("Failed to load XML file.");
        }

        // Loading the XSD file
        InputStream xsdStream = ParserRunner.class.getClassLoader().getResourceAsStream("phone.xsd");
        if (xsdStream == null) {
            throw new RuntimeException("Failed to load XSD file.");
        }

        try {
            // Validate XML against XSD
            validateXMLAgainstXSD(xmlStream, xsdStream);

            // Close the input streams used for XML validation
            xmlStream.close();
            xsdStream.close();

            // Create new input streams for parsing the XML document
            xmlStream = ParserRunner.class.getClassLoader().getResourceAsStream("phone.xml");
            if (xmlStream == null) {
                throw new RuntimeException("Failed to load XML file for parsing.");
            }

            // Parsing the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlStream);
            doc.getDocumentElement().normalize();

            NodeList phoneList = doc.getElementsByTagName("Phone");

            // Read the XML document
            for (int i = 0; i < phoneList.getLength(); i++) {
                Node phoneNode = phoneList.item(i);
                if (phoneNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element phoneElement = (Element) phoneNode;
                    String id = phoneElement.getElementsByTagName("Id").item(0).getTextContent();
                    String name = phoneElement.getElementsByTagName("Name").item(0).getTextContent();
                    String brandName = getXmlElementValueById(doc, "Brand", "Id", phoneElement.getElementsByTagName("BrandId").item(0).getTextContent(), "Name");
                    String countryName = getXmlElementValueById(doc, "Country", "Id", phoneElement.getElementsByTagName("CountryId").item(0).getTextContent(), "Name");
                    String osName = getXmlElementValueById(doc, "OperatingSystem", "Id", phoneElement.getElementsByTagName("OperatingSystemId").item(0).getTextContent(), "Name");

                    System.out.println("Phone ID: " + id);
                    System.out.println("Phone Name: " + name);
                    System.out.println("Brand Name: " + brandName);
                    System.out.println("Country ID: " + countryName);
                    System.out.println("Operating System ID: " + osName);
                    System.out.println("----------------------------");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        } finally {
            // Close the input streams
            try {
                if (xmlStream != null) {
                    xmlStream.close();
                }
                if (xsdStream != null) {
                    xsdStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void validateXMLAgainstXSD(InputStream xmlStream, InputStream xsdStream)
            throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source xsdSource = new StreamSource(xsdStream);
        Schema schema = schemaFactory.newSchema(xsdSource);
        Validator validator = schema.newValidator();
        Source xmlSource = new StreamSource(xmlStream);
        validator.validate(xmlSource);
    }

    private static String getXmlElementValueById(Document doc, String elementName, String idElementName, String idValue, String valueElementName) {
        NodeList nodeList = doc.getElementsByTagName(elementName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getElementsByTagName(idElementName).item(0).getTextContent().equals(idValue)) {
                NodeList valueNodeList = element.getElementsByTagName(valueElementName);
                if (valueNodeList.getLength() > 0) {
                    return valueNodeList.item(0).getTextContent();
                }
            }
        }
        return "";
    }
}