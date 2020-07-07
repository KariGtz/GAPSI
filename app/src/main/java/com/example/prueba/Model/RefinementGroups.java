package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RefinementGroups {

    @SerializedName("name")
    private String name;

    @SerializedName("refinement")
    private List<Refinement> refinement;

    @SerializedName("multiSelect")
    private boolean multiSelect;

    @SerializedName("dimensionName")
    private String dimensionName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Refinement> getRefinement() {
        return refinement;
    }

    public void setRefinement(List<Refinement> refinement) {
        this.refinement = refinement;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }
}
