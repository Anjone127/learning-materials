package anjone.xmlpaser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * JDK 中的 DOM API 遵循 W3C DOM 规范，
 * 其中 org.w3c.dom 包提供了 Document、DocumentType、Node、NodeList、Element 等接口， 
 * 这些接口均是访问 DOM 文档所必须的。
 * 我们可以利用这些接口创建、遍历、修改 DOM 文档。
 * @author anjone
 * 2017年9月26日
 */
public class DomParser {

	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		//InputStream is = new FileInputStream(src/main/java/xmlpaser/books.xml");
		//builder.parse(is)
		Document document = builder.parse(new File("src/main/java/xmlpaser/books.xml"));
		Element rootElement = document.getDocumentElement();

		NodeList nodes = rootElement.getElementsByTagName("book");
		for (int i=0; i < nodes.getLength(); i++)
		{
			Element node = (Element) nodes.item(i);
			System.out.println("title: "+ node.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
			System.out.println("author: "+ node.getElementsByTagName("author").item(0).getFirstChild().getNodeValue());
		}

		//反转id
		NodeList nodeList = rootElement.getElementsByTagName("book");
		if(nodeList != null) 
		{
			for (int i = 0 ; i < nodeList.getLength(); i++) 
			{ 
				Element element = (Element)nodeList.item(i); 
				String id = element.getAttribute("id"); 
				System.out.println("book id:" + id);
				element.setAttribute("id", new StringBuffer(id).reverse().toString());
			}
		}
		
		Element books = (Element) document.getElementsByTagName("books").item(0);
		Element book = document.createElement("book");
		book.setAttribute("Attribute", "111");
		Element title = document.createElement("title");
		title.appendChild( document.createTextNode("title"));
		book.appendChild(title);
		Element author = document.createElement("author");
		author.appendChild( document.createTextNode("author"));
		book.appendChild(author);
		books.appendChild(book);
		
		
		//写入
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer transformer = tfactory.newTransformer();
		//换行
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		//缩进
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("src/main/java/xmlpaser/books2.xml"));
		transformer.transform(source,result);
	}
}
