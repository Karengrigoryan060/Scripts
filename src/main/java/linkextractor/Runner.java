package linkextractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        File dir = new File("src/main/resources/xmlFiles");

        File[] directoryListing = dir.listFiles();
        List<String> allURLs = new ArrayList<>();
        assert directoryListing != null;
        System.out.println("Files count in directory:" + directoryListing.length);
        for (File file : directoryListing) {
            List<String> urlList = XMLParser.parse(file, "loc");
            allURLs.addAll(urlList);
        }
        System.out.println("Total: " + allURLs.size() + " links");

        for (String url : allURLs) {
            List<String> links = LinkExtractor.extractLinks(url);
            for (String link : links) {

                String linksPath = "src/main/resources/extractedLinks/links.txt";
                String invalidLinksPath = "src/main/resources/extractedLinks/invalidLinks.txt";

                // here we add all links to a file links.txt
                appendUsingFileOutputStream(linksPath, link + "\n");
                if (link.contains("picsart.tools") || link.contains("stage-wordpress")) {
                    // here we add all links which contain specific string to a file invalidLinks.txt
                    appendUsingFileOutputStream(invalidLinksPath, link + "\n" + url);
                    appendUsingFileOutputStream(invalidLinksPath, "====================================================");
                }
            }
            System.out.println(url + " is passed");
        }

    }

    /**
     * Method is for appending text to specific file
     *
     * @param fileName file path where should be saved
     * @param data     String name which should be written there
     */
    private static void appendUsingFileOutputStream(String fileName, String data) {
        OutputStream os = null;
        try {
            // below true flag tells OutputStream to append
            os = new FileOutputStream(new File(fileName), true);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
