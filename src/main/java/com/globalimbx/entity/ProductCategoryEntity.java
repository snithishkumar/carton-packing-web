package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class ProductCategoryEntity {

	public static final String PRODUCT_CATEGORY_ID = "productCategoryId";
	public static final String PRODUCT_CATEGORY_GUID = "productCategoryGuid";
	public static final String PRODUCT_CATEGORY = "productCategory";
	public static final String NOTES = "notes";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDateTime";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductCategoryId")
	private int productCategoryId;
	@Column(name = "ProductCategoryGUId")
	private String productCategoryGuid;
	@Column(name = "ProductCategory")
	private String productCategory;
	@Column(name = "Notes")
	private String notes;
	@Column(name = "LastModifiedDateTime")
	private long lastModifiedDateTime;

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(long lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	@Override
	public String toString() {
		return "ProductCategoryEntity [productCategoryId=" + productCategoryId + ", productCategoryGuid="
				+ productCategoryGuid + ", productCategory=" + productCategory + ", notes=" + notes
				+ ", lastModifiedDateTime=" + lastModifiedDateTime + "]";
	}

}
