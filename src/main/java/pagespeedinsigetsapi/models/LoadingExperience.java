
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class LoadingExperience {

    @SerializedName("initial_url")
    private String initialUrl;
}
