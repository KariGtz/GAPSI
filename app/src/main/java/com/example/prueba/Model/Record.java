package com.example.prueba.Model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class Record {

    @SerializedName("productId")
    private String productId;

    @SerializedName("skuRepositoryId")
    private String skuRepositoryId;

    @SerializedName("productDisplayName")
    private String productDisplayName;

    @SerializedName("productType")
    private String productType;

    @SerializedName("productRatingCount")
    private int productRatingCount;

    @SerializedName("productAvgRating")
    private Double productAvgRating;

    @SerializedName("listPrice")
    private Double listPrice;

    @SerializedName("minimumListPrice")
    private Double minimumListPrice;

    @SerializedName("maximumListPrice")
    private Double maximumListPrice;

    @SerializedName("promoPrice")
    private Double promoPrice;

    @SerializedName("minimumPromoPrice")
    private Double minimumPromoPrice;

    @SerializedName("maximumPromoPrice")
    private Double maximumPromoPrice;

    @SerializedName("isHybrid")
    private boolean isHybrid;

    @SerializedName("isMarketPlace")
    private boolean isMarketPlace;

    @SerializedName("isImportationProduct")
    private boolean isImportationProduct;

    @SerializedName("smImage")
    private String smImage;

    @SerializedName("lgImage")
    private String lgImage;

    @SerializedName("xlImage")
    private String xlImage;

    @SerializedName("groupType")
    private String groupType;

    @SerializedName("plpFlags")
    private Array[] plpFlags;

    @SerializedName("variantsColor")
    private List<Color> variantsColor;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSkuRepositoryId() {
        return skuRepositoryId;
    }

    public void setSkuRepositoryId(String skuRepositoryId) {
        this.skuRepositoryId = skuRepositoryId;
    }

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductRatingCount() {
        return productRatingCount;
    }

    public void setProductRatingCount(int productRatingCount) {
        this.productRatingCount = productRatingCount;
    }

    public Double getProductAvgRating() {
        return productAvgRating;
    }

    public void setProductAvgRating(Double productAvgRating) {
        this.productAvgRating = productAvgRating;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getMinimumListPrice() {
        return minimumListPrice;
    }

    public void setMinimumListPrice(Double minimumListPrice) {
        this.minimumListPrice = minimumListPrice;
    }

    public Double getMaximumListPrice() {
        return maximumListPrice;
    }

    public void setMaximumListPrice(Double maximumListPrice) {
        this.maximumListPrice = maximumListPrice;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Double getMinimumPromoPrice() {
        return minimumPromoPrice;
    }

    public void setMinimumPromoPrice(Double minimumPromoPrice) {
        this.minimumPromoPrice = minimumPromoPrice;
    }

    public Double getMaximumPromoPrice() {
        return maximumPromoPrice;
    }

    public void setMaximumPromoPrice(Double maximumPromoPrice) {
        this.maximumPromoPrice = maximumPromoPrice;
    }

    public boolean isHybrid() {
        return isHybrid;
    }

    public void setHybrid(boolean hybrid) {
        isHybrid = hybrid;
    }

    public boolean isMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public boolean isImportationProduct() {
        return isImportationProduct;
    }

    public void setImportationProduct(boolean importationProduct) {
        isImportationProduct = importationProduct;
    }

    public String getSmImage() {
        return smImage;
    }

    public void setSmImage(String smImage) {
        this.smImage = smImage;
    }

    public String getLgImage() {
        return lgImage;
    }

    public void setLgImage(String lgImage) {
        this.lgImage = lgImage;
    }

    public String getXlImage() {
        return xlImage;
    }

    public void setXlImage(String xlImage) {
        this.xlImage = xlImage;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Array[] getPlpFlags() {
        return plpFlags;
    }

    public void setPlpFlags(Array[] plpFlags) {
        this.plpFlags = plpFlags;
    }

    public List<Color> getVariantsColor() {
        return variantsColor;
    }

    public void setVariantsColor(List<Color> variantsColor) {
        this.variantsColor = variantsColor;
    }
}
