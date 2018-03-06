package com.globalimbx.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.globalimbx.enumeration.OrderStatus;
import com.globalimbx.enumeration.PaymentStatus;
import com.globalimbx.json.OrderCreationDetailsRequestJson;
import com.globalimbx.json.OrderDetailsJson;

@Entity
@Table(name = "OrderEntity")
public class OrderEntity {

	public static final String ID = "id";
	public static final String ORDER_ID = "orderId";
	public static final String ORDER_GUID = "orderGuid";
	public static final String CLIENT_ID = "clientDetailsEntity";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String PAYMENT_STATUS = "paymentStatus";
	public static final String ORDERED_DATE = "orderedDate";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String SERVER_TIME = "serverTime";
	public static final String IS_DELETED = "isDeleted";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@Column(name = "OrderId")
	private String orderId;
	@Column(name = "OrderGuid")
	private String orderGuid;
	
	@Column(name = "OrderStatus")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	@Column(name = "PaymentStatus")
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	@Column(name = "OrderedDate")
	private long orderedDate;
	@Column(name = "LastModifiedDate")
	private long lastModifiedDate;
	@Column(name = "ServerTime")
	private long serverTime;
	@Column(name = "IsDeleted")
	private boolean isDeleted;
	@Column(name = "OrderedItems",columnDefinition="TEXT")
	private String orderedItems;
	@Column(name = "ProductDetails",columnDefinition="TEXT")
	private String productDetails;
	@Column(name = "NoOfCartons")
	private String noOfCartons;
	@ManyToOne
	@JoinColumn(name = "CreatedBy", referencedColumnName = "UserId")
	private UserDetailsEntity orderCreatedBy;
	
	@ManyToOne
	@JoinColumn(name = "ExporterId", referencedColumnName = "CompanyDetailsId")
	private CompanyDetailsEntity exporter;
	
	@ManyToOne
	@JoinColumn(name = "consigneeId", referencedColumnName = "ClientId")
	private ClientDetailsEntity consignee;

	public OrderEntity() {

	}
	
	
	public OrderEntity(OrderCreationDetailsRequestJson creationRequestJson){
		this.orderGuid = UUID.randomUUID().toString();
		this.orderId = creationRequestJson.getOrderNumber();
		this.orderStatus = OrderStatus.ORDERED;
		this.paymentStatus = PaymentStatus.NOT_PAIED;
		this.orderedDate = System.currentTimeMillis();
		this.lastModifiedDate = System.currentTimeMillis();
		this.serverTime = this.lastModifiedDate;
		this.isDeleted = false;
		
	}

	
	public void copyBeanValue(OrderDetailsJson orderDetailsJson){
		this.orderStatus = orderDetailsJson.getOrderStatus();
		this.lastModifiedDate = orderDetailsJson.getLastModifiedDate();
		this.serverTime = System.currentTimeMillis();
		this.isDeleted = orderDetailsJson.isDeleted();
		this.noOfCartons = orderDetailsJson.getCartonCounts();
	}
	
	

	public UserDetailsEntity getOrderCreatedBy() {
		return orderCreatedBy;
	}


	public void setOrderCreatedBy(UserDetailsEntity orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}

	

	public String getNoOfCartons() {
		return noOfCartons;
	}


	public void setNoOfCartons(String noOfCartons) {
		this.noOfCartons = noOfCartons;
	}


	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

	public String getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(String orderedItems) {
		this.orderedItems = orderedItems;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	
	

	public CompanyDetailsEntity getExporter() {
		return exporter;
	}


	public void setExporter(CompanyDetailsEntity exporter) {
		this.exporter = exporter;
	}


	public ClientDetailsEntity getConsignee() {
		return consignee;
	}


	public void setConsignee(ClientDetailsEntity consignee) {
		this.consignee = consignee;
	}


	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderId=" + orderId + ", orderGuid=" + orderGuid + ", orderStatus="
				+ orderStatus + ", paymentStatus=" + paymentStatus + ", orderedDate=" + orderedDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", serverTime=" + serverTime + ", isDeleted=" + isDeleted
				+ ", orderedItems=" + orderedItems + ", productDetails=" + productDetails + ", noOfCartons="
				+ noOfCartons + ", orderCreatedBy=" + orderCreatedBy + ", exporter=" + exporter + ", consignee="
				+ consignee + "]";
	}


	

	

}
