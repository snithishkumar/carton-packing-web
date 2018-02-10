package com.globalimbx.json;

import com.globalimbx.entity.ProductCategoryEntity;

public class ProductCategoryJson {
	
	private String productCategoryGuid;
	private String productCategorys;
	private String productCategoryNotes;
	
	public ProductCategoryJson(){
		
	}
	
	public ProductCategoryJson(ProductCategoryEntity productCategoryEntity){
		this.productCategoryGuid = productCategoryEntity.getProductCategoryGuid();
		this.productCategorys = productCategoryEntity.getProductCategory();
		this.productCategoryNotes = productCategoryEntity.getNotes();
	}
	
	public String getProductCategoryGuid() {
		return productCategoryGuid;
	}
	public void setProductCategoryGuid(String productCategoryGuid) {
		this.productCategoryGuid = productCategoryGuid;
	}
	public String getProductCategorys() {
		return productCategorys;
	}
	public void setProductCategorys(String productCategorys) {
		this.productCategorys = productCategorys;
	}
	public String getProductCategoryNotes() {
		return productCategoryNotes;
	}
	public void setProductCategoryNotes(String productCategoryNotes) {
		this.productCategoryNotes = productCategoryNotes;
	}
	@Override
	public String toString() {
		return "ProductCategoryJson [productCategoryGuid=" + productCategoryGuid + ", productCategorys=" + productCategorys
				+ ", productCategoryNotes=" + productCategoryNotes + "]";
	}
	
	

}
