package linkextractor;

import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    private XMLParser() {
    }

    /**
     * This Method is for extracting Strings with specific tag from file
     * @param file is for specifying file which should be used
     * @param tagName tag for execution
     * @return all founded strings
     */
    @SneakyThrows
    public static List<String> parse(File file, String tagName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName(tagName);

        List<String> links = new ArrayList<>();
        for (int temp = 1; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            links.add(node.getTextContent());
        }
        return links;
    }
}
