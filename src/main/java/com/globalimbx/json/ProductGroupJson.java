package com.globalimbx.json;

import com.globalimbx.entity.ProductGroupEntity;

public class ProductGroupJson {
	
	private String productGroupGuid;
	private String productGroups;
	private String productGroupNotes;
	
	public ProductGroupJson(){
		
	}
	
	public ProductGroupJson(ProductGroupEntity productGroupEntity){
		this.productGroupGuid = productGroupEntity.getProductGroupGuid();
		this.productGroups = productGroupEntity.getProductGroup();
		this.productGroupNotes = productGroupEntity.getNotes();
	}
	
	public String getProductGroupGuid() {
		return productGroupGuid;
	}
	public void setProductGroupGuid(String productGroupGuid) {
		this.productGroupGuid = productGroupGuid;
	}
	public String getProductGroups() {
		return productGroups;
	}
	public void setProductGroups(String productGroups) {
		this.productGroups = productGroups;
	}
	public String getProductGroupNotes() {
		return productGroupNotes;
	}
	public void setProductGroupNotes(String productGroupNotes) {
		this.productGroupNotes = productGroupNotes;
	}
	@Override
	public String toString() {
		return "ProductGroupJson [productGroupGuid=" + productGroupGuid + ", productGroups=" + productGroups
				+ ", productGroupNotes=" + productGroupNotes + "]";
	}
	
	

}
