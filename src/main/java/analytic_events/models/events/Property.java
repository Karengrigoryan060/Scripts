package analytic_events.models.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Property {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("required")
    @Expose
    private Boolean required;
    @SerializedName("operationType")
    @Expose
    private String operationType;
    @SerializedName("operationValue")
    @Expose
    private Object operationValue;
    @SerializedName("createDt")
    @Expose
    private String createDt;
    @SerializedName("updateDt")
    @Expose
    private String updateDt;
    @SerializedName("deleteDt")
    @Expose
    private Object deleteDt;
    @SerializedName("properties")
    @Expose
    private List<Object> properties = null;
    @SerializedName("values")
    @Expose
    private List<Value> values = null;

    public Property(Integer id, String name, String description, String type, Boolean required, String operationType, Object operationValue, String createDt, String updateDt, Object deleteDt, List<Object> properties, List<Value> values) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.required = required;
        this.operationType = operationType;
        this.operationValue = operationValue;
        this.createDt = createDt;
        this.updateDt = updateDt;
        this.deleteDt = deleteDt;
        this.properties = properties;
        this.values = values;
    }

    public Property() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Object getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(Object operationValue) {
        this.operationValue = operationValue;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public Object getDeleteDt() {
        return deleteDt;
    }

    public void setDeleteDt(Object deleteDt) {
        this.deleteDt = deleteDt;
    }

    public List<Object> getProperties() {
        return properties;
    }

    public void setProperties(List<Object> properties) {
        this.properties = properties;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(name, property.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}