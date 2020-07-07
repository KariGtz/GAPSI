package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("colorName")
    private String colorName;

    @SerializedName("colorHex")
    private String colorHex;

    @SerializedName("colorImageURL")
    private String colorImageURL;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getColorImageURL() {
        return colorImageURL;
    }

    public void setColorImageURL(String colorImageURL) {
        this.colorImageURL = colorImageURL;
    }
}
