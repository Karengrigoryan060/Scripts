
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Environment {

    @SerializedName("networkUserAgent")
    private String networkUserAgent;

    @SerializedName("hostUserAgent")
    private String hostUserAgent;

    @SerializedName("benchmarkIndex")
    private Integer benchmarkIndex;
}
