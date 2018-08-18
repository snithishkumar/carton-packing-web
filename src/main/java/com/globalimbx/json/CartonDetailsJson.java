package com.globalimbx.json;

import java.util.*;

public class CartonDetailsJson {
	
	private String cartonGuid;
    private String cartonNumber;
    private long createdDateTime;
    private long lastModifiedTime;
    private String createdBy;
    private String lastModifiedBy;
    private String totalWeight;
	private String deliverDetailsGuid;
    private Set<CartonProductDetailsJson> productDetailsJsonList = new HashSet<>();
	public String getCartonGuid() {
		return cartonGuid;
	}


    public String getDeliverDetailsGuid() {
        return deliverDetailsGuid;
    }

    public void setDeliverDetailsGuid(String deliverDetailsGuid) {
        this.deliverDetailsGuid = deliverDetailsGuid;
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

	public Set<CartonProductDetailsJson> getProductDetailsJsonList() {
		return productDetailsJsonList;
	}

	public void setProductDetailsJsonList(Set<CartonProductDetailsJson> productDetailsJsonList) {
		this.productDetailsJsonList = productDetailsJsonList;
	}

	@Override
	public String toString() {
		return "CartonDetailsJson [cartonGuid=" + cartonGuid + ", cartonNumber=" + cartonNumber + ", createdDateTime="
				+ createdDateTime + ", lastModifiedTime=" + lastModifiedTime + ", createdBy=" + createdBy
				+ ", lastModifiedBy=" + lastModifiedBy + ", productDetailsJsonList=" + productDetailsJsonList + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CartonDetailsJson that = (CartonDetailsJson) o;
		return Objects.equals(cartonGuid, that.cartonGuid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartonGuid);
	}
}
