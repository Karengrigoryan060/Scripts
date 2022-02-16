package analytic_events.models.events;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("owner")
    @Expose
    private Object owner;
    @SerializedName("mappedName")
    @Expose
    private String mappedName;
    @SerializedName("isValidMapping")
    @Expose
    private Boolean isValidMapping;
    @SerializedName("extraProperty")
    @Expose
    private Object extraProperty;
    @SerializedName("extraPropertyValue")
    @Expose
    private String extraPropertyValue;
    @SerializedName("owners")
    @Expose
    private List<String> owners = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("androidVersion")
    @Expose
    private Object androidVersion;
    @SerializedName("iosVersion")
    @Expose
    private Object iosVersion;
    @SerializedName("createDt")
    @Expose
    private String createDt;
    @SerializedName("updateDt")
    @Expose
    private String updateDt;
    @SerializedName("deleteDt")
    @Expose
    private Object deleteDt;
    @SerializedName("applicationId")
    @Expose
    private Integer applicationId;
    @SerializedName("properties")
    @Expose
    private List<Property> properties = null;
    @SerializedName("businessUnitDTOs")
    @Expose
    private List<BusinessUnitDTO> businessUnitDTOs = null;
    @SerializedName("valid")
    @Expose
    private Integer valid;
    @SerializedName("invalid")
    @Expose
    private Integer invalid;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("testedDate")
    @Expose
    private String testedDate;
    @SerializedName("deprecated")
    @Expose
    private Boolean deprecated;
    @SerializedName("deprecatedMessage")
    @Expose
    private Object deprecatedMessage;
    @SerializedName("validMapping")
    @Expose
    private Boolean validMapping;

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

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public String getMappedName() {
        return mappedName;
    }

    public void setMappedName(String mappedName) {
        this.mappedName = mappedName;
    }

    public Boolean getIsValidMapping() {
        return isValidMapping;
    }

    public void setIsValidMapping(Boolean isValidMapping) {
        this.isValidMapping = isValidMapping;
    }

    public Object getExtraProperty() {
        return extraProperty;
    }

    public void setExtraProperty(Object extraProperty) {
        this.extraProperty = extraProperty;
    }

    public String getExtraPropertyValue() {
        return extraPropertyValue;
    }

    public void setExtraPropertyValue(String extraPropertyValue) {
        this.extraPropertyValue = extraPropertyValue;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(Object androidVersion) {
        this.androidVersion = androidVersion;
    }

    public Object getIosVersion() {
        return iosVersion;
    }

    public void setIosVersion(Object iosVersion) {
        this.iosVersion = iosVersion;
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

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<BusinessUnitDTO> getBusinessUnitDTOs() {
        return businessUnitDTOs;
    }

    public void setBusinessUnitDTOs(List<BusinessUnitDTO> businessUnitDTOs) {
        this.businessUnitDTOs = businessUnitDTOs;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getInvalid() {
        return invalid;
    }

    public void setInvalid(Integer invalid) {
        this.invalid = invalid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestedDate() {
        return testedDate;
    }

    public void setTestedDate(String testedDate) {
        this.testedDate = testedDate;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }

    public Object getDeprecatedMessage() {
        return deprecatedMessage;
    }

    public void setDeprecatedMessage(Object deprecatedMessage) {
        this.deprecatedMessage = deprecatedMessage;
    }

    public Boolean getValidMapping() {
        return validMapping;
    }

    public void setValidMapping(Boolean validMapping) {
        this.validMapping = validMapping;
    }

}
