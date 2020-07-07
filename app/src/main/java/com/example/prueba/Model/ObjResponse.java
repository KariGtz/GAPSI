package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class ObjResponse {

    @SerializedName("status")
    private JSONObject status;

    @SerializedName("pageType")
    private String pageType;

    @SerializedName("plpResults")
    private PlpResults plpResults;

    public JSONObject getStatus() {
        return status;
    }

    public void setStatus(JSONObject status) {
        this.status = status;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public PlpResults getPlpResults() {
        return plpResults;
    }

    public void setPlpResults(PlpResults plpResults) {
        this.plpResults = plpResults;
    }
}
