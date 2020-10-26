
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Categories {

    @SerializedName("performance")
    private Performance performance;
}
