
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.jsoup.Jsoup;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;

public class Parser {
    private ArrayList<Doc> docs;

    public Parser() {
        docs = new ArrayList<>();
    }

    private void parsDocs() {
        try {
            for (int i = 1; i < 22; i++) {
                //creating a constructor of file class and parsing an XML file
                File file = new File("WebIR-" + String.valueOf(i) + ".xml");
                //an instance of factory that gives a document builder
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                //an instance of builder to parse the specified xml file
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                String rootElement = doc.getDocumentElement().getNodeName();
                NodeList nodeList = doc.getElementsByTagName("DOC");
                // nodeList is not iterable, so we are using for loop
                for (int itr = 0; itr < nodeList.getLength(); itr++) {
                    Node node = nodeList.item(itr);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) node;
                        Doc parsingDoc = new Doc();
                        parsingDoc.setId(Integer.parseInt(eElement.getElementsByTagName("DOCID").item(0).getTextContent()));
                        parsingDoc.setUrl(eElement.getElementsByTagName("URL").item(0).getTextContent());
                        String Html = eElement.getElementsByTagName("HTML").item(0).getTextContent();
                        org.jsoup.nodes.Document htmlDoc=Jsoup.parse(Html);
                        parsingDoc.setBody(htmlDoc.body().text());
                        parsingDoc.setTitle(htmlDoc.title());
                        docs.add(parsingDoc);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Doc[] getDocs() {
        parsDocs();
        return docs.toArray(new Doc[docs.size()]);
    }
}
