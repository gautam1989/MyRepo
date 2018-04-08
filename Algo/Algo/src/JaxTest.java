import java.io.*;
import java.text.*;
import java.util.*;

import org.w3c.dom.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.*;
import javax.xml.xpath.*;


public class JaxTest {

	
	
	public static void main(String[] args) throws Exception {

		
		try {
	         File inputFile = new File("/Users/gautamverma/Desktop/testme.txt");
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder;

	         dBuilder = dbFactory.newDocumentBuilder();

	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();

	         XPath xPath =  XPathFactory.newInstance().newXPath();

	         String expression = "//student";	        
	         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
	         System.out.println(nodeList.getLength());
	         
	         
	         
	         TimeZone utc = TimeZone.getTimeZone("GMT");
	         GregorianCalendar gc = new GregorianCalendar();
	         DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	         df.setTimeZone(utc);
	         System.out.println(" - Gregorian UTC [" + df.format(gc.getTime()) + "]");

	         XMLGregorianCalendar currServTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

	         System.out.println("currServTime is "+currServTime);
	         
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
