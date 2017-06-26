/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author richardmagnus-george
 */
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author usmanali
 */
public class ReadCondition {

    NodeList nodeList;
    String tag, path;
    
    List<Condition> conditionsList = new ArrayList();

    public ReadCondition() {

    }

    public void XPath(String _PATH, String TAG) {
        try {
            //this._url = _URL;
            URL path = new URL(_PATH);
            URLConnection connection = path.openConnection();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(connection.getInputStream());
            XPath xPath = XPathFactory.newInstance().newXPath();
            nodeList = (NodeList) xPath.compile(TAG).evaluate(xmlDocument, XPathConstants.NODESET);
        } catch (IOException | SAXException | ParserConfigurationException | XPathExpressionException ex) {
            Logger.getLogger(ReadCondition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Condition> read() {
        path = "file:///Users/richardmagnus-george/Desktop/InfantMonitoringSystem/conditions.xml";
        tag = "//Condition | //ID | //Name | //MinThreshold | //MaxThreshold";
        XPath(path, tag);
        int fre = nodeList.getLength();
        List<Condition> conditions = new ArrayList();
                Condition condition = null; 

        for (int i = 0; i < fre; i++) {
            String text = nodeList.item(i).getNodeName();
            
            if(text.equalsIgnoreCase("Condition"))
            {
                 condition = new Condition();
            }
            
            if (text.equalsIgnoreCase("ID")) {
                //ID.add(nodeList.item(i).getTextContent());
                condition.setID(Integer.parseInt(nodeList.item(i).getTextContent()));
            }
            if (text.equalsIgnoreCase("Name")) {
                //Name.add(nodeList.item(i).getTextContent());
                condition.setName(nodeList.item(i).getTextContent());
            }
            if (text.equalsIgnoreCase("MinThreshold")) {
                //MaxThreshold.add(nodeList.item(i).getTextContent());
                condition.setMin(Double.parseDouble(nodeList.item(i).getTextContent()));
            }
            if (text.equalsIgnoreCase("MaxThreshold")) {
                //MinThreshold.add(nodeList.item(i).getTextContent());
                condition.setMax(Double.parseDouble(nodeList.item(i).getTextContent()));
                conditions.add(condition);
                //break;
            }
     
        }
        
        
        return conditions;
    }

}
