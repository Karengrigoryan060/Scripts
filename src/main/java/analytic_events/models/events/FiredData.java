package analytic_events.models.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FiredData {

    @SerializedName("key")
    @Expose
    private Long key;
    @SerializedName("value")
    @Expose
    private Integer value;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}