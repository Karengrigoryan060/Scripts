package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TestData {

    @SerializedName("url")
    private String url;
    @SerializedName("accessibility")
    private Integer accessibility;
    @SerializedName("performance")
    private Integer performance;
    @SerializedName("progressiveWebApp")
    private Integer progressiveWebApp;
    @SerializedName("bestPractices")
    private Integer bestPractices;
    @SerializedName("seo")
    private Integer seo;
    @SerializedName("firstContentfulPaint")
    private Integer firstContentfulPaint;
    @SerializedName("speedIndex")
    private Integer speedIndex;
    @SerializedName("interactive")
    private Integer interactive;
    @SerializedName("firstMeaningfulPaint")
    private Integer firstMeaningfulPaint;
    @SerializedName("firstCpuIdle")
    private Integer firstCpuIdle;
    @SerializedName("maxPotentialFid")
    private Integer maxPotentialFid;
    @SerializedName("offscreenImages")
    private Integer offscreenImages;
    @SerializedName("removeUnusedCSS")
    private Integer removeUnusedCSS;
    @SerializedName("preconnectToRequiredOrigins")
    private Integer preconnectToRequiredOrigins;
    @SerializedName("eliminateRenderBlockingResources")
    private Integer eliminateRenderBlockingResources;
    @SerializedName("minimizeMainThreadWork")
    private Integer minimizeMainThreadWork;
    @SerializedName("reduceJavaScriptExecutionTime")
    private Integer reduceJavaScriptExecutionTime;
}