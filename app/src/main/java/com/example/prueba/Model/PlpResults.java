package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlpResults {

    @SerializedName("label")
    private String label;

    @SerializedName("plpState")
    private PlpState plpState;

    @SerializedName("sortOptions")
    private List<SortOptions> sortOptions;

    @SerializedName("refinementGroups")
    private List<RefinementGroups> refinementGroups;

    @SerializedName("records")
    private List<Record> records;

    @SerializedName("navigation")
    private Navigation navigation;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PlpState getPlpState() {
        return plpState;
    }

    public void setPlpState(PlpState plpState) {
        this.plpState = plpState;
    }

    public List<SortOptions> getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(List<SortOptions> sortOptions) {
        this.sortOptions = sortOptions;
    }

    public List<RefinementGroups> getRefinementGroups() {
        return refinementGroups;
    }

    public void setRefinementGroups(List<RefinementGroups> refinementGroups) {
        this.refinementGroups = refinementGroups;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
