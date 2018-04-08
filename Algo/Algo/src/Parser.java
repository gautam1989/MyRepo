
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class Parser {
public static void main(String[] args) {
	
	String toFind="transaction/Amount";
	try{
		File fXmlFile = new File("/Users/gautamverma/Documents/workspaceL/DP/test.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
				

		doc.getDocumentElement().normalize();

		 
		
		 for(int i=0;i<=toFind.split("/").length;i++){
			 
			 NodeList n= doc.getDocumentElement().getElementsByTagName(toFind.split("/")[i]);
			 for (int j = 0; j <n.item(0).getChildNodes().getLength(); j++) {
				   // System.out.println(nodeList.item(0).getChildNodes().item(j).getNodeName());
				    		if(n.item(0).getChildNodes().item(j).getNodeName().equals(toFind.split("/")[i+1]) && i==toFind.split("/").length-1){
				    			System.out.println(n.item(0).getChildNodes().item(j).getNodeValue());
				    			
				    		}
				    		else if(n.item(0).getChildNodes().item(j).getNodeName().equals(toFind.split("/")[i+1]) && i<=toFind.split("/").length){
				    			
				    		}else{
				    			System.out.println("NF");
				    			break;
				    			
				    		}
				    		
				    }
			 
			 
		 }
		 
		 
		
	}catch(Exception e){
		
	}
	
	
	
}

public static List<String> getTextValuesByTagName(Element element, String tagName) {
    NodeList nodeList = element.getElementsByTagName(tagName);
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < nodeList.getLength(); i++) {
      list.add(getTextValue(nodeList.item(i)));
    }
    return list;
  }
  public static String getTextValue(Node node) {
    StringBuffer textValue = new StringBuffer();
    int length = node.getChildNodes().getLength();
    for (int i = 0; i < length; i ++) {
      Node c = node.getChildNodes().item(i);
      if (c.getNodeType() == Node.TEXT_NODE) {
        textValue.append(c.getNodeValue());
      }
    }
    return textValue.toString().trim();
  }
}
