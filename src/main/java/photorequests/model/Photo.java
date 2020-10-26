package photorequests.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("status")
    private String status;

    @SerializedName("response")
    private Response response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}