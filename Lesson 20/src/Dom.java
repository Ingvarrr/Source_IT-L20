import org.w3c.dom.Document;
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
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        System.out.println();

        for (int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                if("login".equals(node.getNodeName())){
                    System.out.println("Login is " + node.getFirstChild().getNodeValue());
                }
            }
        }
    }
}
