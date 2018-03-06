package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.globalimbx.enumeration.DeliveringType;

@Entity
@Table(name = "DeliveryDetails")
public class DeliveryDetailsEntity {
	
	public static final String DELIVERY_DETAILS_ID = "deliveryDetailsId";
    public static final String DELIVERY_UUID = "deliveryUUID";
    public static final String ORDER_ID = "orderEntity";

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DeliveryDetailsId")
    private int deliveryDetailsId;
    @Column(name = "DeliveryUUID")
    private String deliveryUUID;
    @Column(name = "DeliveringType")
    private DeliveringType deliveringType;
    @Column(name = "PlaceOfLoading")
    private String placeOfLoading;
    @Column(name = "PlaceOfDelivery")
    private String placeOfDelivery;
    @Column(name = "PortOfDischarge")
    private String portOfDischarge;

    @ManyToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "Id")
    private OrderEntity orderEntity;

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

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    @Override
    public String toString() {
        return "DeliveryDetailsEntity{" +
                "deliveryDetailsId=" + deliveryDetailsId +
                ", deliveryUUID='" + deliveryUUID + '\'' +
                ", deliveringType=" + deliveringType +
                ", placeOfLoading='" + placeOfLoading + '\'' +
                ", placeOfDelivery='" + placeOfDelivery + '\'' +
                ", portOfDischarge='" + portOfDischarge + '\'' +
                ", orderEntity=" + orderEntity +
                '}';
    }

}
