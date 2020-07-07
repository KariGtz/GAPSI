package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

public class PlpState {

    @SerializedName("categoryId")
    private String categoryId;

    @SerializedName("currentSortOption")
    private String currentSortOption;

    @SerializedName("currentFilters")
    private String currentFilters;

    @SerializedName("firstRecNum")
    private int firstRecNum;

    @SerializedName("lastRecNum")
    private int lastRecNum;

    @SerializedName("recsPerPage")
    private int recsPerPage;

    @SerializedName("totalNumRecs")
    private int totalNumRecs;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCurrentSortOption() {
        return currentSortOption;
    }

    public void setCurrentSortOption(String currentSortOption) {
        this.currentSortOption = currentSortOption;
    }

    public String getCurrentFilters() {
        return currentFilters;
    }

    public void setCurrentFilters(String currentFilters) {
        this.currentFilters = currentFilters;
    }

    public int getFirstRecNum() {
        return firstRecNum;
    }

    public void setFirstRecNum(int firstRecNum) {
        this.firstRecNum = firstRecNum;
    }

    public int getLastRecNum() {
        return lastRecNum;
    }

    public void setLastRecNum(int lastRecNum) {
        this.lastRecNum = lastRecNum;
    }

    public int getRecsPerPage() {
        return recsPerPage;
    }

    public void setRecsPerPage(int recsPerPage) {
        this.recsPerPage = recsPerPage;
    }

    public int getTotalNumRecs() {
        return totalNumRecs;
    }

    public void setTotalNumRecs(int totalNumRecs) {
        this.totalNumRecs = totalNumRecs;
    }
}
