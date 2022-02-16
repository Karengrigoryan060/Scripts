package linkextractor;

import lombok.SneakyThrows;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

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

    @SneakyThrows
    public static Map<String, String> parseWithDate(File file, String tag1, String tag2) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(file);
        document.getDocumentElement().normalize();
        Map<String, String> map = new HashMap<>();

        NodeList nListLink = document.getElementsByTagName(tag1);
        NodeList nListDate = document.getElementsByTagName(tag2);

        for (int temp = 1; temp < nListLink.getLength(); temp++) {
            Node nodeLink = nListLink.item(temp);
            Node nodeDate = nListDate.item(temp);
            map.put(nodeLink.getTextContent(), nodeDate.getTextContent().substring(0,7));
        }
        return map;
    }
}
