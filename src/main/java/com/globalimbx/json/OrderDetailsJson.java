package com.globalimbx.json;

import java.util.ArrayList;
import java.util.List;

import com.globalimbx.entity.OrderEntity;
import com.globalimbx.enumeration.OrderStatus;
import com.globalimbx.enumeration.PaymentStatus;

public class OrderDetailsJson {

	private String orderId;
	private String orderGuid;
	private String clientName;
	private OrderStatus orderStatus;
	private PaymentStatus paymentStatus;
	private long orderedDate;
	private long lastModifiedDate;
	private long serverTime;
	private boolean isDeleted;
	private List<ProductDetails> orderDetails = new ArrayList<ProductDetails>();
	private List<OrderCreationDetailsJson> orderedItems = new ArrayList<>();

	public OrderDetailsJson() {

	}

	public OrderDetailsJson(OrderEntity orderEntity) {
		this.orderId = orderEntity.getOrderId();
		this.orderGuid = orderEntity.getOrderGuid();
		this.clientName = orderEntity.getClientDetailsEntity().getCompany();
		this.orderStatus = orderEntity.getOrderStatus();
		this.paymentStatus = orderEntity.getPaymentStatus();
		this.orderedDate = orderEntity.getOrderedDate();
		this.lastModifiedDate = orderEntity.getLastModifiedDate();
		this.serverTime = orderEntity.getServerTime();
		this.isDeleted = orderEntity.isDeleted();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderGuid() {
		return orderGuid;
	}

	public void setOrderGuid(String orderGuid) {
		this.orderGuid = orderGuid;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public long getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(long orderedDate) {
		this.orderedDate = orderedDate;
	}

	public long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public long getServerTime() {
		return serverTime;
	}

	public void setServerTime(long serverTime) {
		this.serverTime = serverTime;
	}

	public List<ProductDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<ProductDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "OrderDetailsJson [orderId=" + orderId + ", orderGuid=" + orderGuid + ", clientName=" + clientName
				+ ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", orderedDate=" + orderedDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", serverTime=" + serverTime + ", orderDetails="
				+ orderDetails + "]";
	}

	public List<OrderCreationDetailsJson> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<OrderCreationDetailsJson> orderedItems) {
		this.orderedItems = orderedItems;
	}

	

}
