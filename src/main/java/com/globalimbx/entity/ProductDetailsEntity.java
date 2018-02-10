package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductDetails")
public class ProductDetailsEntity {

	public static final String PRODUCT_ID = "productId";
	public static final String PRODUCT_GUID = "productGuid";
	public static final String PRODUCT_NAME = "productName";
	public static final String UNIT_PRICE = "unitPrice";
	public static final String PRODUCT_NOTES = "productNotes";
	public static final String PRODUCT_GROUP_ID = "productGroupEntity";
	public static final String PRODUCT_CATEGORY_ID = "productCategoryEntity";
	public static final String PRODUCT_COLOR_ID = "productColorEntity";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductId")
	private int productId;
	@Column(name = "ProductGuid")
	private String productGuid;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "UnitPrice")
	private double unitPrice;
	@Column(name = "ProductNotes")
	private String productNotes;
	@ManyToOne
	@JoinColumn(name = "ProductGroupId", referencedColumnName = "ProductGroupId")
	private ProductGroupEntity productGroupEntity;
	@ManyToOne
	@JoinColumn(name = "ProductCategoryId", referencedColumnName = "ProductCategoryId")
	private ProductCategoryEntity productCategoryEntity;
	@ManyToOne
	@JoinColumn(name = "ProductColorId", referencedColumnName = "ProductColorId")
	private ProductColorEntity productColorEntity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductGuid() {
		return productGuid;
	}

	public void setProductGuid(String productGuid) {
		this.productGuid = productGuid;
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

	public ProductGroupEntity getProductGroupEntity() {
		return productGroupEntity;
	}

	public void setProductGroupEntity(ProductGroupEntity productGroupEntity) {
		this.productGroupEntity = productGroupEntity;
	}

	public ProductCategoryEntity getProductCategoryEntity() {
		return productCategoryEntity;
	}

	public void setProductCategoryEntity(ProductCategoryEntity productCategoryEntity) {
		this.productCategoryEntity = productCategoryEntity;
	}

	public ProductColorEntity getProductColorEntity() {
		return productColorEntity;
	}

	public void setProductColorEntity(ProductColorEntity productColorEntity) {
		this.productColorEntity = productColorEntity;
	}

	@Override
	public String toString() {
		return "ProductDetailsEntity [productId=" + productId + ", productGuid=" + productGuid + ", productName="
				+ productName + ", unitPrice=" + unitPrice + ", productNotes=" + productNotes + ", productGroupEntity="
				+ productGroupEntity + ", productCategoryEntity=" + productCategoryEntity + ", productColorEntity="
				+ productColorEntity + "]";
	}

}
