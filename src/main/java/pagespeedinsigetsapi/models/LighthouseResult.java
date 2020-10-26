package pagespeedinsigetsapi.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class LighthouseResult {

    @SerializedName("requestedUrl")
    private String requestedUrl;

    @SerializedName("finalUrl")
    private String finalUrl;

    @SerializedName("lighthouseVersion")
    private String lighthouseVersion;

    @SerializedName("userAgent")
    private String userAgent;

    @SerializedName("fetchTime")
    private String fetchTime;

    @SerializedName("environment")
    private Environment environment;

    @SerializedName("unminified-css")
    private Object unminifiedCss;

    @SerializedName("interactive")
    private Object interactive;

    @SerializedName("metrics")
    private Object metrics;

    @SerializedName("performance-budget")
    private Object performanceBudget;

    @SerializedName("offscreen-images")
    private Object offscreenImages;

    @SerializedName("font-display")
    private Object fontDisplay;

    @SerializedName("timing-budget")
    private Object timingBudget;

    @SerializedName("redirects")
    private Object redirects;

    @SerializedName("screenshot-thumbnails")
    private Object screenshotThumbnails;

    @SerializedName("first-cpu-idle")
    private Object firstCpuIdle;

    @SerializedName("uses-rel-preload")
    private Object usesRelPreload;

    @SerializedName("unused-javascript")
    private Object unusedJavascript;

    @SerializedName("total-byte-weight")
    private Object totalByteWeight;

    @SerializedName("efficient-animated-content")
    private Object efficientAnimatedContent;

    @SerializedName("resource-summary")
    private Object resourceSummary;

    @SerializedName("speed-index")
    private Object speedIndex;

    @SerializedName("final-screenshot")
    private Object finalScreenshot;

    @SerializedName("runWarnings")
    private List<Object> runWarnings = null;

    @SerializedName("configSettings")
    private Object configSettings;

    @SerializedName("audits")
    private Object audits;

    @SerializedName("categories")
    private Categories categories;

    @SerializedName("categoryGroups")
    private Object categoryGroups;

    @SerializedName("timing")
    private Timing timing;

    @SerializedName("i18n")
    private Object i18n;

    @SerializedName("stackPacks")
    private List<Object> stackPacks = null;
}