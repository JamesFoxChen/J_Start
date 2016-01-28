package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

public class XmlUtil {
	// http://blog.csdn.net/smcwwh/article/details/7183869
	// http://www.cnblogs.com/mengdd/archive/2013/06/05/3119927.html

	public void CreateXmlDocument() {

		try {
			// 创建一个xml文档
			Document doc = DocumentHelper.createDocument();
			Element university = doc.addElement("university");
			university.addAttribute("name", "tsu");
			// 注释
			university.addComment("这个是根节点");
			Element college = university.addElement("college");
			college.addAttribute("name", "cccccc");
			college.setText("text");

			File file = new File("file/dom4j-modify.xml");
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			XMLWriter out = new XMLWriter(new FileWriter(file));
			out.write(doc);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ReadFromDocument() throws DocumentException, ParserConfigurationException, SAXException, IOException
	{
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("file/students.xml"));

		// 获取根元素
		Element root = document.getRootElement();
		System.out.println("Root: " + root.getName());

		// 获取所有子元素
		List<Element> childList = root.elements();
		System.out.println("total child count: " + childList.size());

		// 获取特定名称的子元素
		List<Element> childList2 = root.elements("hello");
		System.out.println("hello child: " + childList2.size());

		// 获取名字为指定名称的第一个子元素
		Element firstWorldElement = root.element("world");
		// 输出其属性
		System.out.println("first World Attr: "
				+ firstWorldElement.attribute(0).getName() + "="
				+ firstWorldElement.attributeValue("name"));

		System.out.println("迭代输出-----------------------");
		// 迭代输出
		for (Iterator iter = root.elementIterator(); iter.hasNext();) {
			Element e = (Element) iter.next();
			System.out.println(e.attributeValue("name"));

		}

		System.out.println("用DOMReader-----------------------");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 注意要用完整类名
		org.w3c.dom.Document document2 = db.parse(new File("file/students.xml "));

		DOMReader domReader = new DOMReader();

		// 将JAXP的Document转换为dom4j的Document
		Document document3 = domReader.read(document2);

		Element rootElement = document3.getRootElement();

		System.out.println("Root: " + rootElement.getName());
	}

}
