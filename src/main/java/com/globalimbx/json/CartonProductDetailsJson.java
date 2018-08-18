package com.globalimbx.json;

import java.util.Objects;

public class CartonProductDetailsJson {
	
	    private String productGroup;
	    private String productGuid;
	    private String productCategory;
	    private String productStyle;
	    private String colorStyle;
	    private String orderItemGuid;
	    private String oneSize;
	    private String xs;
	    private String s;
	    private String m;
	    private String l;
	    private String xl;
	    private String xxl;
	    private String xxxl;
	    private String cartonNumber;
	    private long createdDateTime;
	    private long lastModifiedDateTime;

	    public String getProductGroup() {
	        return productGroup;
	    }

	    public void setProductGroup(String productGroup) {
	        this.productGroup = productGroup;
	    }

	    public String getProductGuid() {
	        return productGuid;
	    }

	    public void setProductGuid(String productGuid) {
	        this.productGuid = productGuid;
	    }

	    public String getProductCategory() {
	        return productCategory;
	    }

	    public void setProductCategory(String productCategory) {
	        this.productCategory = productCategory;
	    }

	    public String getProductStyle() {
	        return productStyle;
	    }

	    public void setProductStyle(String productStyle) {
	        this.productStyle = productStyle;
	    }

	    public String getColorStyle() {
	        return colorStyle;
	    }

	    public void setColorStyle(String colorStyle) {
	        this.colorStyle = colorStyle;
	    }

	    public String getOrderItemGuid() {
	        return orderItemGuid;
	    }

	    public void setOrderItemGuid(String orderItemGuid) {
	        this.orderItemGuid = orderItemGuid;
	    }

	    public String getOneSize() {
	        return oneSize;
	    }

	    public void setOneSize(String oneSize) {
	        this.oneSize = oneSize;
	    }

	    public String getXs() {
	        return xs;
	    }

	    public void setXs(String xs) {
	        this.xs = xs;
	    }

	    public String getS() {
	        return s;
	    }

	    public void setS(String s) {
	        this.s = s;
	    }

	    public String getM() {
	        return m;
	    }

	    public void setM(String m) {
	        this.m = m;
	    }

	    public String getL() {
	        return l;
	    }

	    public void setL(String l) {
	        this.l = l;
	    }

	    public String getXl() {
	        return xl;
	    }

	    public void setXl(String xl) {
	        this.xl = xl;
	    }

	    public String getXxl() {
	        return xxl;
	    }

	    public void setXxl(String xxl) {
	        this.xxl = xxl;
	    }

	    public String getXxxl() {
	        return xxxl;
	    }

	    public void setXxxl(String xxxl) {
	        this.xxxl = xxxl;
	    }

	    public String getCartonNumber() {
	        return cartonNumber;
	    }

	    public void setCartonNumber(String cartonNumber) {
	        this.cartonNumber = cartonNumber;
	    }

	    public long getCreatedDateTime() {
	        return createdDateTime;
	    }

	    public void setCreatedDateTime(long createdDateTime) {
	        this.createdDateTime = createdDateTime;
	    }

	    public long getLastModifiedDateTime() {
	        return lastModifiedDateTime;
	    }

	    public void setLastModifiedDateTime(long lastModifiedDateTime) {
	        this.lastModifiedDateTime = lastModifiedDateTime;
	    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CartonProductDetailsJson that = (CartonProductDetailsJson) o;
		return Objects.equals(productGuid, that.productGuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productGuid);
	}

	@Override
	    public String toString() {
	        return "ProductDetailsJson{" +
	                "productGroup='" + productGroup + '\'' +
	                ", productGuid='" + productGuid + '\'' +
	                ", productCategory='" + productCategory + '\'' +
	                ", productStyle='" + productStyle + '\'' +
	                ", colorStyle='" + colorStyle + '\'' +
	                ", orderItemGuid='" + orderItemGuid + '\'' +
	                ", oneSize='" + oneSize + '\'' +
	                ", xs='" + xs + '\'' +
	                ", s='" + s + '\'' +
	                ", m='" + m + '\'' +
	                ", l='" + l + '\'' +
	                ", xl='" + xl + '\'' +
	                ", xxl='" + xxl + '\'' +
	                ", xxxl='" + xxxl + '\'' +
	                ", cartonNumber='" + cartonNumber + '\'' +
	                ", createdDateTime=" + createdDateTime +
	                ", lastModifiedDateTime=" + lastModifiedDateTime +
	                '}';
	    }

}
