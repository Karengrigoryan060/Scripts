package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MongoResult {
    @SerializedName("buildNumber")
    private int buildNumber;
    @SerializedName("date")
    private String date;
    @SerializedName("environment")
    private String environment;
    @SerializedName("url")
    private String url;
    @SerializedName("device")
    private String device;
    @SerializedName("accessibility")
    private Integer accessibility;
    @SerializedName("performance")
    private Integer performance;
    @SerializedName("bestPractices")
    private Integer bestPractices;
    @SerializedName("seo")
    private Integer seo;

    public MongoResult(int buildNumber, String date, String environment, String url, String device, Integer performance) {
        this.buildNumber = buildNumber;
        this.date = date;
        this.environment = environment;
        this.url = url;
        this.device = device;
        this.performance = performance;
    }
}
