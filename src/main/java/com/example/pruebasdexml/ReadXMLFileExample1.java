package com.example.pruebasdexml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class ReadXMLFileExample1
{
    public void lector(File fil) {
        try
        {
//creating a constructor of file class and parsing an XML file  
            File file = new File(fil.toURI());
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Cliente");
// nodeList is not iterable, so we are using for loop  
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                System.out.println(node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    System.out.println("Nombre Persona: "+ eElement.getElementsByTagName("Nombre").item(0).getTextContent());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}  