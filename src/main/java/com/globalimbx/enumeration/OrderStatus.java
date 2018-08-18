package com.globalimbx.enumeration;

public enum OrderStatus {
	ORDERED(0),PACKING(1),PARTIAL_DELIVERED(2),DELIVERED(3);
	private int orderStatusId;
	OrderStatus(int orderStatusId){
		this.orderStatusId = orderStatusId;
	}

	public int getOrderStatusId(){
		return orderStatusId;
	}

}
