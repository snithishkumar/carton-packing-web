package com.globalimbx.json;

import java.util.List;

public class OrderCreationDetailsRequestJson {
	private String orderNumber;
	private String datepicker;
	private String exporter;
	private String consignee;
	private List<OrderCreationDetailsJson> orderDetails = null;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}

	public String getExporter() {
		return exporter;
	}

	public void setExporter(String exporter) {
		this.exporter = exporter;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public List<OrderCreationDetailsJson> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderCreationDetailsJson> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
