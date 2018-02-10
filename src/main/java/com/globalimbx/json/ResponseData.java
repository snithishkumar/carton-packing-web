package com.globalimbx.json;

public class ResponseData {
	
	private int statusCode;
	private Object data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseData [statusCode=" + statusCode + ", data=" + data + "]";
	}
	
	

}
