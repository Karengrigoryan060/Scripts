
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Timing {

    @SerializedName("total")
    private Double total;
}