package rs.co.sbb.sbbworkorders.entity.response;

/**
 * Created by Predrag.Tasic on 6/7/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetWoResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("WOData")
    @Expose
    private WoData wOData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public WoData getWOData() {
        return wOData;
    }

    public void setWOData(WoData wOData) {
        this.wOData = wOData;
    }

}
