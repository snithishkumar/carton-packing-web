package com.globalimbx.json;

import com.globalimbx.entity.ClientDetailsEntity;
import com.globalimbx.entity.CompanyDetailsEntity;

public class CompanyDetailsJson {

	private String companyDetailsGuid;
	private String companyName;
	
	public CompanyDetailsJson(){
		
	}
	
	public CompanyDetailsJson(CompanyDetailsEntity companyDetailsEntity){
		this.companyDetailsGuid = companyDetailsEntity.getCompanyDetailsGuid();
		this.companyName = companyDetailsEntity.getCompanyName();
	}
	
	public CompanyDetailsJson(ClientDetailsEntity clientDetailsEntity){
		this.companyDetailsGuid = clientDetailsEntity.getClientGuid();
		this.companyName = clientDetailsEntity.getCompany();
	}

	public String getCompanyDetailsGuid() {
		return companyDetailsGuid;
	}

	public void setCompanyDetailsGuid(String companyDetailsGuid) {
		this.companyDetailsGuid = companyDetailsGuid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "CompanyDetailsJson [companyDetailsGuid=" + companyDetailsGuid + ", companyName=" + companyName + "]";
	}

}
