package anjone.xmlpaser;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 123123s
 * @author gjy
 */
public class Dom4jParser {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		File file = new File("src/main/java/xmlpaser/books.xml");
		org.dom4j.Document document = reader.read(file);
		Element root = document.getRootElement();
		List<Element> childElements = root.elements();
		for (Element child : childElements) {
			
			List<Attribute> attributeList = child.attributes();
            for (Attribute attr : attributeList) {
                System.out.println(attr.getName() + ": " + attr.getValue());
            }

			System.out.println("id: " + child.attributeValue("id"));

			List<Element> elementList = child.elements();
            for (Element ele : elementList) {
                System.out.println(ele.getName() + ": " + ele.getText());
            }
            System.out.println();

			System.out.println("title" + child.elementText("title"));
			System.out.println("author" + child.elementText("author"));
			System.out.println();
		}
	}
}
