	import java.io.File;
	import java.io.FileOutputStream;



import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class Xml {
   public static void main(String[] args){
      try {	
         File inputFile = new File("configP.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile); //Parse the content of the given file as an XML document and return a new DOM Document object.
         //criação do config apenas
         //criou-se  documentbuilderfactory para ler ficheiro xml 
         
         doc.getDocumentElement().normalize();
         //serve para conseguirmos ler melhor o doc.xml
         //sem normalizado: 
//         Text node: ""
//        	    Text node: "Hello "
//        	    Text node: "wor"
//        	    Text node: "ld"
//        	normalizado:
//        		
//        		 Text node: "Hello world"	
        	    	
         
         System.out.println("\n----- Search the XML document with xpath queries -----");  
        
         // Query 1 
         System.out.println("Query 1: ");
         XPathFactory xpathFactory = XPathFactory.newInstance(); 
         //classe abstrata, cria xpath objectos, usados para navegar por
         //expressoes, elementos e atributos de um documento XML
       
         XPath xpath = xpathFactory.newXPath();
         //cria um xpath para apanhar valores a esse doc xml
         
        
         //compila a expressao xpath para obter todos os "serviços" presentes n
         //no xml no path /xml/service/...
          XPathExpression expr = xpath.compile("/XML/Service/@*");
         NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
         for (int i = 0; i < nl.getLength(); i++) {
        	 //percorre lista dentro do service 
             System.out.print(nl.item(i).getNodeName()  + ": ");
             //imprime o nome "account ou password ou account
             System.out.println(nl.item(i).getFirstChild().getNodeValue());
             //imprime de cada "nome" o value do node ou seja joao@iscte.. ou abdc
         }
         // Query 2
         System.out.println("\nQuery 2: ");         
         expr = xpath.compile("/XML/Paths/docPath");
         String str = (String) expr.evaluate(doc, XPathConstants.STRING);
         
         System.out.println("docPath: " + str);
         //compilou o path do doc, e vou apanhar o seu valor e por fim imprimiu
         
         
         // Adding new element Service with attributes to the XML document (root node)
         System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");

         Element newElement1 = doc.createElement("Service");
         newElement1.setAttribute("Protocol", "smtp");
         newElement1.setAttribute("Account", "manuel@iscte-iul.pt");
         newElement1.setAttribute("Password", "xyzw");
         
         // Adding new element OtherNewTag to the XML document (root node)
         System.out.println("----- Adding new element <OtherNewTag> to the XML document -----");
 
         Element newElement2 = doc.createElement("OtherNewTag");
         newElement2.setTextContent("More new data"); 
         
         // Add new nodes to XML document (root element)
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());         
         Node n = doc.getDocumentElement();
         n.appendChild(newElement1);
         n.appendChild(newElement2);         
       
         // Save XML document
         System.out.println("\nSave XML document.");
         Transformer transformer = TransformerFactory.newInstance().newTransformer();
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
         DOMSource source = new DOMSource(doc);
         transformer.transform(source, result);
      } catch (Exception e) { e.printStackTrace(); }
   }
}
