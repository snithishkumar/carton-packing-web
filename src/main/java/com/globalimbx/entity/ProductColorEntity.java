package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductColor")
public class ProductColorEntity {

	public static final String PRODUCT_COLOR_ID = "productColorId";
	public static final String PRODUCT_COLOR_GUID = "productColorGuid";
	public static final String PRODUCT_COLOR = "productColor";
	public static final String NOTES = "notes";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDateTime";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductColorId")
	private int productColorId;
	@Column(name = "ProductColorGUId")
	private String productColorGuid;
	@Column(name = "ProductColor")
	private String productColor;
	@Column(name = "Notes")
	private String notes;
	@Column(name = "LastModifiedDateTime")
	private long lastModifiedDateTime;

	public int getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(int productColorId) {
		this.productColorId = productColorId;
	}

	public String getProductColorGuid() {
		return productColorGuid;
	}

	public void setProductColorGuid(String productColorGuid) {
		this.productColorGuid = productColorGuid;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
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
		return "ProductColorEntity [productColorId=" + productColorId + ", productColorGuid="
				+ productColorGuid + ", productColor=" + productColor + ", notes=" + notes
				+ ", lastModifiedDateTime=" + lastModifiedDateTime + "]";
	}

}
