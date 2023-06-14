
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
import java.io.File;
import java.io.IOException;

public class PhoneXmlParserRunner {
    public static void main(String[] args) {
        try {
            String xmlFilePath = "phone.xml";
            String xsdFilePath = "phone.xsd";

            // Validate XML against XSD
            boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
            if (!isValid) {
                System.out.println("XML is not valid against XSD.");
                return;
            }

            // Read the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlFilePath));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Phone");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("Id").item(0).getTextContent();
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    String brandId = element.getElementsByTagName("BrandId").item(0).getTextContent();
                    String countryId = element.getElementsByTagName("CountryId").item(0).getTextContent();
                    String osId = element.getElementsByTagName("OperatingSystemId").item(0).getTextContent();

                    System.out.println("Phone " + (i + 1));
                    System.out.println("Id: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("BrandId: " + brandId);
                    System.out.println("CountryId: " + countryId);
                    System.out.println("OperatingSystemId: " + osId);
                    System.out.println("---------------------------------------");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new File(xmlFilePath));

        try {
            validator.validate(source);
            return true;
        } catch (SAXException e) {
            return false;
        }
    }
}
