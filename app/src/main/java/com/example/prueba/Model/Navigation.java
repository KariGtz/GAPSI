package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class Navigation {

    @SerializedName("ancester")
    private Array[] ancester;

    @SerializedName("current")
    private Array[] current;

    @SerializedName("childs")
    private Array[] childs;

    public Array[] getAncester() {
        return ancester;
    }

    public void setAncester(Array[] ancester) {
        this.ancester = ancester;
    }

    public Array[] getCurrent() {
        return current;
    }

    public void setCurrent(Array[] current) {
        this.current = current;
    }

    public Array[] getChilds() {
        return childs;
    }

    public void setChilds(Array[] childs) {
        this.childs = childs;
    }
}
