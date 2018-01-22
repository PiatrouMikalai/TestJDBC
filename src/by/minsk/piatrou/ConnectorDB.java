package by.minsk.piatrou;

import java.io.File;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ConnectorDB {

	public static Connection getConnection() throws SQLException {
		String url = null, user = null, password = null;
		File file = new File("Data/DataSQL.xml");
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			Element root = document.getDocumentElement();
			NodeList children = root.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				if(child instanceof Element) {
					Element childElement = (Element) child;
					Text textNode = (Text) childElement.getFirstChild();
					String text = textNode.getData();
					if (childElement.getTagName().equals("URL")) {
						url = text;
					}
					if (childElement.getTagName().equals("user")) {
						user = text;
					}
					if (childElement.getTagName().equals("password")) {
						password = text;
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return DriverManager.getConnection(url, user, password);		
	}
}
