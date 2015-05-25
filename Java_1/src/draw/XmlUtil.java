package draw;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;

public class XmlUtil {
	
	public static void parse(String protocolXML) {   
        
        try {   
             DocumentBuilderFactory factory = DocumentBuilderFactory   
                     .newInstance();   
             DocumentBuilder builder = factory.newDocumentBuilder();   
             Document doc = builder   
                     .parse(new InputSource(new StringReader(protocolXML)));   
             
             Element root = doc.getDocumentElement();  
             
             NodeList books = doc.getElementsByTagName("resultObject");
            if (books != null) {   
                for (int i = 0; i < books.getLength(); i++) {   
                     Node book = books.item(i);   
                     System.out.println("节点=" + book.getNodeName() + "\ttext="  
                             + book.getNodeValue());   
                 }   
             }   
         } catch (Exception e) {   
             e.printStackTrace();   
         }   
     } 
	
	@SuppressWarnings("unchecked")
	public static <T> T xml2Bean(String xmlStr, Class<T> cls)
	{
		XStream xstream = new XStream();
		xstream.processAnnotations(cls);
        T obj=(T)xstream.fromXML(xmlStr);
        
        return obj;
	}
	
	public static void main(String[] args) {
		
		XmlUtil.parse(Test2.getParm());
	}
}
