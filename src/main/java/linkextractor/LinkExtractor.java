package linkextractor;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {

    /**
     *
     * @param url is for inputting URL where the links should be found
     * @return all founded links
     */
    @SneakyThrows
    public static List<String> extractLinks(String url) {
        final ArrayList<String> result = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            result.add(link.attr("abs:href"));
        }
        return result;
    }
}
