
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {

    @SerializedName("captchaResult")
    private String captchaResult;

    @SerializedName("kind")
    private String kind;

    @SerializedName("id")
    private String id;

    @SerializedName("loadingExperience")
    private LoadingExperience loadingExperience;

    @SerializedName("lighthouseResult")
    private LighthouseResult lighthouseResult;

    @SerializedName("analysisUTCTimestamp")
    private String analysisUTCTimestamp;
}
