package com.globalimbx.entity;

import javax.persistence.*;

import com.globalimbx.enumeration.DeliveringType;
import com.globalimbx.enumeration.Status;

@Entity
@Table(name = "DeliveryDetails")
public class DeliveryDetailsEntity {
	
	public static final String DELIVERY_DETAILS_ID = "deliveryDetailsId";
    public static final String DELIVERY_UUID = "deliveryUUID";
    public static final String ORDER_ID = "orderEntity";
    public static final String SERVER_SYNC_TIME = "serverSyncTime";

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DeliveryDetailsId")
    private int deliveryDetailsId;
    @Column(name = "DeliveryUUID")
    private String deliveryUUID;
    
    @Column(name = "DeliveryID")
    private String deliveryId;
    @Column(name = "DeliveringType")
    private DeliveringType deliveringType;
    @Column(name = "PlaceOfLoading")
    private String placeOfLoading;
    @Column(name = "PlaceOfDelivery")
    private String placeOfDelivery;
    @Column(name = "PortOfDischarge")
    private String portOfDischarge;

    @Column(name = "OrderGuids",columnDefinition="TEXT")
    private String orderGuids;

    @Column(name = "LastModifiedDateTime")
    private long lastModifiedDateTime;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "ServerSyncTime")
    private long serverSyncTime;

    public long getServerSyncTime() {
        return serverSyncTime;
    }

    public void setServerSyncTime(long serverSyncTime) {
        this.serverSyncTime = serverSyncTime;
    }

    public long getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(long lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderGuids() {
        return orderGuids;
    }

    public void setOrderGuids(String orderGuids) {
        this.orderGuids = orderGuids;
    }

    public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryUUID() {
        return deliveryUUID;
    }

    public void setDeliveryUUID(String deliveryUUID) {
        this.deliveryUUID = deliveryUUID;
    }

    public int getDeliveryDetailsId() {
        return deliveryDetailsId;
    }

    public void setDeliveryDetailsId(int deliveryDetailsId) {
        this.deliveryDetailsId = deliveryDetailsId;
    }

    public DeliveringType getDeliveringType() {
        return deliveringType;
    }

    public void setDeliveringType(DeliveringType deliveringType) {
        this.deliveringType = deliveringType;
    }

    public String getPlaceOfLoading() {
        return placeOfLoading;
    }

    public void setPlaceOfLoading(String placeOfLoading) {
        this.placeOfLoading = placeOfLoading;
    }

    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPortOfDischarge(String portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    @Override
    public String toString() {
        return "DeliveryDetailsEntity{" +
                "deliveryDetailsId=" + deliveryDetailsId +
                ", deliveryUUID='" + deliveryUUID + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", deliveringType=" + deliveringType +
                ", placeOfLoading='" + placeOfLoading + '\'' +
                ", placeOfDelivery='" + placeOfDelivery + '\'' +
                ", portOfDischarge='" + portOfDischarge + '\'' +
                ", orderGuids='" + orderGuids + '\'' +
                ", lastModifiedDateTime=" + lastModifiedDateTime +
                ", status=" + status +
                ", serverSyncTime=" + serverSyncTime +
                '}';
    }
}
