import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by vig on 12/19/16.
 */
public class Dom {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("Lesson 20/src/person.xml");

        document.getDocumentElement().normalize();

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName() + ", id = "
                + document.getDocumentElement().getAttribute("id"));

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        System.out.println();

        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element el = (Element) node;

                if("name".equals(node.getNodeName())){
                    System.out.println("Name is : ");
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node node1 = node.getChildNodes().item(j);
                        if ("firstName".equals(node1.getNodeName())) {
                            System.out.println("FirstName " + node1.getFirstChild().getNodeValue());
                        }
                        if ("lastName".equals(node1.getNodeName())) {
                            System.out.println("LastName " + node1.getFirstChild().getNodeValue());
                        }
                    }
                }
                if("login".equals(node.getNodeName())){
                    System.out.println("Login is " + node.getFirstChild().getNodeValue());
                }
                if("permission".equals(node.getNodeName())){
                    System.out.println("Permission :");
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node node1 = node.getChildNodes().item(j);
                        if ("document".equals(node1.getNodeName())) {
                            System.out.println("Document " + node1.getFirstChild().getNodeValue());
                        }
                        if ("pages".equals(node1.getNodeName())) {
                            System.out.println("Pages " + node1.getFirstChild().getNodeValue());
                        }
                    }
                }
                if("documents".equals(node.getNodeName())){
                    System.out.println("Documents :");
                    for (int j = 0; j < node.getChildNodes().getLength(); j++) {
                        Node node1 = node.getChildNodes().item(j);
                        if ("doc".equals(node1.getNodeName())) {
                            System.out.println("Document " + node1.getFirstChild().getNodeValue());
                        }
                    }
                }
            }
        }
    }
}
