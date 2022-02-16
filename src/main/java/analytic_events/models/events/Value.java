package analytic_events.models.events;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("createDt")
    @Expose
    private String createDt;
    @SerializedName("updateDt")
    @Expose
    private Object updateDt;
    @SerializedName("deleteDt")
    @Expose
    private Object deleteDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public Object getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Object updateDt) {
        this.updateDt = updateDt;
    }

    public Object getDeleteDt() {
        return deleteDt;
    }

    public void setDeleteDt(Object deleteDt) {
        this.deleteDt = deleteDt;
    }

}