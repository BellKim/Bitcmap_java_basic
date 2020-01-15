package sample02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class mainClass {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//client.xml java parsing
		
		Document xml = null;
		

			InputSource is = new InputSource(new FileReader("D:\\tmp\\client.xml"));
//			InputSource is = new InputSource(new FileReader("D:\\project\\Bitcmap_java_basic\\Folder12_xml\\sample02\\src\\sample02\\client.xml"));
//			InputSource is = new InputSource(new FileReader("client.xml"));
			
			xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
			
			//root element 취득
			Element element = xml.getDocumentElement();
//			System.out.println(element.getTagName());
			
			//child node 들을 취득
			NodeList list = element.getChildNodes(); //취득된 노드 리스트가 리스트에 저장된다. 
			System.out.println(list.getLength());
			
			if(list.getLength() > 0 ) {
				for (int i = 0; i < list.getLength(); i++) {
					NodeList childlist = list.item(i).getChildNodes();
					if(childlist.getLength()>0) {
						for (int j = 0; j < childlist.getLength(); j++) {
							if(childlist.item(j).getNodeName().equals("#text") == false) {
								System.out.println(
										"xml 테그명 : " + childlist.item(j).getNodeName()+
										"xml 값 : " + childlist.item(j).getTextContent());								
							}
						}
					}
				}
			}
			
			

		
	}//end main
	
	

}//end class
