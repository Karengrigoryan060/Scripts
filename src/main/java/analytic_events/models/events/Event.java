package analytic_events.models.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isValidMapping")
    @Expose
    private String isValidMapping;
    @SerializedName("owners")
    @Expose
    private List<String> owners = null;
    @SerializedName("updateDt")
    @Expose
    private String updateDt;
    @SerializedName("businessUnitDTOs")
    @Expose
    private List<BusinessUnitDTO> businessUnitDTOs = null;
    @SerializedName("status")
    @Expose
    private String status;

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

    public String getIsValidMapping() {
        return isValidMapping;
    }

    public void setIsValidMapping(String isValidMapping) {
        this.isValidMapping = isValidMapping;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }

    public List<BusinessUnitDTO> getBusinessUnitDTOs() {
        return businessUnitDTOs;
    }

    public void setBusinessUnitDTOs(List<BusinessUnitDTO> businessUnitDTOs) {
        this.businessUnitDTOs = businessUnitDTOs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}