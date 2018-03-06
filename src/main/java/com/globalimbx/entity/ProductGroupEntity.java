package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProductGroups")
public class ProductGroupEntity {

	public static final String PRODUCT_GROUP_ID = "productGroupId";
	public static final String PRODUCT_GROUP_GUID = "productGroupGuid";
	public static final String PRODUCT_GROUP = "productGroup";
	public static final String NOTES = "notes";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDateTime";
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductGroupId")
	private int productGroupId;
	@Column(name = "ProductGroupGUId")
	private String productGroupGuid;
	@Column(name = "ProductGroup")
	private String productGroup;
	@Column(name = "Notes")
	private String notes;
	@Column(name = "LastModifiedDateTime")
	private long lastModifiedDateTime;

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupGuid() {
		return productGroupGuid;
	}

	public void setProductGroupGuid(String productGroupGuid) {
		this.productGroupGuid = productGroupGuid;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
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
		return "ProductGroupEntity [productGroupId=" + productGroupId + ", productGroupGuid=" + productGroupGuid
				+ ", productGroup=" + productGroup + ", notes=" + notes + ", lastModifiedDateTime="
				+ lastModifiedDateTime + "]";
	}

}
