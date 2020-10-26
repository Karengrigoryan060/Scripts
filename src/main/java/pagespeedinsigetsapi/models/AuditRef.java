
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AuditRef {

    @SerializedName("id")
    private String id;

    @SerializedName("weight")
    private Integer weight;

    @SerializedName("group")
    private String group;
}
