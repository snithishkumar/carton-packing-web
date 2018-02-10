package com.globalimbx.json;

import java.util.ArrayList;
import java.util.List;

public class OrderCreationRequestJson {

	private String orderId;
	private String orderDate;
	private List<ProductGroupJson> productGroupJsons = new ArrayList<>();
	private List<ProductCategoryJson> productCategoryJsons = new ArrayList<>();
	private List<ProductColorJson> productColorJsons = new ArrayList<>();
	private List<ProductDetails> productDetailsJson = new ArrayList<>();
	private List<CompanyDetailsJson> companyDetailsJsons = new ArrayList<>();
	private List<CompanyDetailsJson> consigneeDetailsJsons = new ArrayList<>();
	

	public List<ProductDetails> getProductDetailsJson() {
		return productDetailsJson;
	}

	public void setProductDetailsJson(List<ProductDetails> productDetailsJson) {
		this.productDetailsJson = productDetailsJson;
	}

	public List<CompanyDetailsJson> getCompanyDetailsJsons() {
		return companyDetailsJsons;
	}

	public void setCompanyDetailsJsons(List<CompanyDetailsJson> companyDetailsJsons) {
		this.companyDetailsJsons = companyDetailsJsons;
	}

	public List<CompanyDetailsJson> getConsigneeDetailsJsons() {
		return consigneeDetailsJsons;
	}

	public void setConsigneeDetailsJsons(List<CompanyDetailsJson> consigneeDetailsJsons) {
		this.consigneeDetailsJsons = consigneeDetailsJsons;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<ProductGroupJson> getProductGroupJsons() {
		return productGroupJsons;
	}

	public void setProductGroupJsons(List<ProductGroupJson> productGroupJsons) {
		this.productGroupJsons = productGroupJsons;
	}

	public List<ProductCategoryJson> getProductCategoryJsons() {
		return productCategoryJsons;
	}

	public void setProductCategoryJsons(List<ProductCategoryJson> productCategoryJsons) {
		this.productCategoryJsons = productCategoryJsons;
	}

	public List<ProductColorJson> getProductColorJsons() {
		return productColorJsons;
	}

	public void setProductColorJsons(List<ProductColorJson> productColorJsons) {
		this.productColorJsons = productColorJsons;
	}

	@Override
	public String toString() {
		return "OrderCreationRequestJson [orderId=" + orderId + ", orderDate=" + orderDate + ", productGroupJsons="
				+ productGroupJsons + ", productCategoryJsons=" + productCategoryJsons + ", productColorJsons="
				+ productColorJsons + ", productDetailsJson=" + productDetailsJson + ", companyDetailsJsons="
				+ companyDetailsJsons + ", consigneeDetailsJsons=" + consigneeDetailsJsons + "]";
	}

	

}
