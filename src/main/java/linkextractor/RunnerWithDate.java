package linkextractor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RunnerWithDate {

    public static void main(String[] args) {
        File dir = new File("src/main/resources/xmlFiles");

        File[] directoryListing = dir.listFiles();
        Map<String, String> allURLs = new HashMap<>();
        assert directoryListing != null;
        System.out.println("Files count in directory:" + directoryListing.length);
        for (File file : directoryListing) {
            Map<String, String> urlList = XMLParser.parseWithDate(file, "loc", "lastmod");
            allURLs.putAll(urlList);
        }
        System.out.println("Total: " + allURLs.size() + " links");

        Set<String> existing = new HashSet<>();
        String linksPath = "src/main/resources/extractedLinks/monthlyLinks.txt";

        allURLs = allURLs.entrySet()
                .stream()
                .filter(entry -> existing.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        allURLs.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> {
                    appendUsingFileOutputStream(linksPath, e.getKey() + " -> " + e.getValue() + "\n");
                });
    }


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
