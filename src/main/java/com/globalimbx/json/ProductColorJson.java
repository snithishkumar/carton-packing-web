package com.globalimbx.json;

import com.globalimbx.entity.ProductColorEntity;

public class ProductColorJson {

	private String productColorGuid;
	private String productColors;
	private String productColorNotes;

	public ProductColorJson() {

	}

	public ProductColorJson(ProductColorEntity productColorEntity) {
		this.productColorGuid = productColorEntity.getProductColorGuid();
		this.productColors = productColorEntity.getProductColor();
		this.productColorNotes = productColorEntity.getNotes();
	}

	public String getProductColorGuid() {
		return productColorGuid;
	}

	public void setProductColorGuid(String productColorGuid) {
		this.productColorGuid = productColorGuid;
	}

	public String getProductColors() {
		return productColors;
	}

	public void setProductColors(String productColors) {
		this.productColors = productColors;
	}

	public String getProductColorNotes() {
		return productColorNotes;
	}

	public void setProductColorNotes(String productColorNotes) {
		this.productColorNotes = productColorNotes;
	}

	@Override
	public String toString() {
		return "ProductColorJson [productColorGuid=" + productColorGuid + ", productColors=" + productColors
				+ ", productColorNotes=" + productColorNotes + "]";
	}

}
