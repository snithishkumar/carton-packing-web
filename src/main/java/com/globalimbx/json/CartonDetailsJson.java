package com.globalimbx.json;

import java.util.ArrayList;
import java.util.List;

public class CartonDetailsJson {
	
	private String cartonGuid;
    private String cartonNumber;
    private long createdDateTime;
    private long lastModifiedTime;
    private String createdBy;
    private String lastModifiedBy;
    private String totalWeight;
    private List<CartonProductDetailsJson> productDetailsJsonList = new ArrayList<>();
	public String getCartonGuid() {
		return cartonGuid;
	}
	
	
	
	public String getTotalWeight() {
		return totalWeight;
	}



	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}



	public void setCartonGuid(String cartonGuid) {
		this.cartonGuid = cartonGuid;
	}
	public String getCartonNumber() {
		return cartonNumber;
	}
	public void setCartonNumber(String cartonNumber) {
		this.cartonNumber = cartonNumber;
	}
	public long getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(long createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public List<CartonProductDetailsJson> getProductDetailsJsonList() {
		return productDetailsJsonList;
	}
	public void setProductDetailsJsonList(List<CartonProductDetailsJson> productDetailsJsonList) {
		this.productDetailsJsonList = productDetailsJsonList;
	}
	@Override
	public String toString() {
		return "CartonDetailsJson [cartonGuid=" + cartonGuid + ", cartonNumber=" + cartonNumber + ", createdDateTime="
				+ createdDateTime + ", lastModifiedTime=" + lastModifiedTime + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + ", productDetailsJsonList=" + productDetailsJsonList + "]";
	}
    
    

}
