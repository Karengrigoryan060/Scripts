
package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Performance {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("score")
    private Double score;

    @SerializedName("auditRefs")
    private List<AuditRef> auditRefs = null;
}
