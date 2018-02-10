package com.globalimbx.json;

import com.globalimbx.entity.ProductDetailsEntity;

public class ProductDetails {
	
	
	private String productGuid;
	private String productGroupGuid;
	private String productGroupName;
	private String productCategoryGuid;
	private String productCategory;
	private String colorGuid;
	private String color;
	private String productName;
	private double unitPrice;
	private String productNotes;
	
	public ProductDetails(){
		
	}
	
public ProductDetails(ProductDetailsEntity productDetailsEntity){
		this.productGuid = productDetailsEntity.getProductGuid();
		this.productCategory = productDetailsEntity.getProductCategoryEntity().getProductCategory();
		this.productCategoryGuid = productDetailsEntity.getProductCategoryEntity().getProductCategoryGuid();
		this.productGroupGuid = productDetailsEntity.getProductGroupEntity().getProductGroupGuid();
		this.productGroupName = productDetailsEntity.getProductGroupEntity().getProductGroup();
		this.colorGuid = productDetailsEntity.getProductColorEntity().getProductColorGuid();
		this.color = productDetailsEntity.getProductColorEntity().getProductColor();
		this.productName = productDetailsEntity.getProductName();
		this.unitPrice = productDetailsEntity.getUnitPrice();
		this.productNotes = productDetailsEntity.getProductNotes();
	}
	
	
	public String getProductGuid() {
		return productGuid;
	}
	public void setProductGuid(String productGuid) {
		this.productGuid = productGuid;
	}
	public String getProductGroupGuid() {
		return productGroupGuid;
	}
	public void setProductGroupGuid(String productGroupGuid) {
		this.productGroupGuid = productGroupGuid;
	}
	public String getProductGroupName() {
		return productGroupName;
	}
	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}
	public String getProductCategoryGuid() {
		return productCategoryGuid;
	}
	public void setProductCategoryGuid(String productCategoryGuid) {
		this.productCategoryGuid = productCategoryGuid;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getColorGuid() {
		return colorGuid;
	}
	public void setColorGuid(String colorGuid) {
		this.colorGuid = colorGuid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getProductNotes() {
		return productNotes;
	}
	public void setProductNotes(String productNotes) {
		this.productNotes = productNotes;
	}
	@Override
	public String toString() {
		return "ProductDetails [productGuid=" + productGuid + ", productGroupGuid=" + productGroupGuid
				+ ", productGroupName=" + productGroupName + ", productCategoryGuid=" + productCategoryGuid
				+ ", productCategory=" + productCategory + ", colorGuid=" + colorGuid + ", color=" + color
				+ ", productName=" + productName + ", unitPrice=" + unitPrice + ", productNotes=" + productNotes + "]";
	}
	
	

}
