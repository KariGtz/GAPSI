package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

public class SortOptions {

    @SerializedName("sortBy")
    private String sortBy;

    @SerializedName("label")
    private String label;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
