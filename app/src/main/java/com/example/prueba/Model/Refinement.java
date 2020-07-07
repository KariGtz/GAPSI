package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

public class Refinement {

    @SerializedName("count")
    private int count;

    @SerializedName("label")
    private String label;

    @SerializedName("refinementId")
    private String refinementId;

    @SerializedName("selected")
    private boolean selected;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRefinementId() {
        return refinementId;
    }

    public void setRefinementId(String refinementId) {
        this.refinementId = refinementId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
