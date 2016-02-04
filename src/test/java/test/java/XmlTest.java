package test.java;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.xml.sax.SAXException;

import utils.XmlUtil;

public class XmlTest {

	@Test
	public void CreateXmlDocument() {
		XmlUtil util=new XmlUtil();
		util.CreateXmlDocument();
	}
	
	@Test
	public void ReadXmlDocument() {
		XmlUtil util=new XmlUtil();
		try {
			util.ReadFromDocument();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
