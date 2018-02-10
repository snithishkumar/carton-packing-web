package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CompanyDetails")
public class CompanyDetailsEntity {

	public static final String COMPANY_DETAILS_ID = "companyDetailsId";
	public static final String COMPANY_DETAILS_GUID = "companyDetailsGuid";
	public static final String COMPANY_NAME = "companyName";
	public static final String ADDRESS1 = "address1";
	public static final String ADDRESS2 = "address2";
	public static final String CONTACT_AUTHORITY = "";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String EMAIL = "email";
	public static final String POST_CODE = "postCode";
	public static final String COUNTRY = "country";
	public static final String COMPANY_NOTES = "companyNotes";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CompanyDetailsId")
	private int companyDetailsId;
	@Column(name = "CompanyDetailsGuid")
	private String companyDetailsGuid;
	@Column(name = "CompanyName")
	private String companyName;
	@Column(name = "Address1")
	private String address1;
	@Column(name = "Address2")
	private String address2;
	@Column(name = "ContactAuthority")
	private String contactAuthority;
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "PostCode")
	private String postCode;
	@Column(name = "Country")
	private String country;
	@Column(name = "CompanyNotes")
	private String companyNotes;
	@Column(name = "LastModifiedDate")
	private long lastModifiedDate;
	
	
	public void copyVal(CompanyDetailsEntity companyDetailsEntity){
		this.companyName = companyDetailsEntity.getCompanyName();
		this.address1 = companyDetailsEntity.getAddress1();
		this.address2 = companyDetailsEntity.getAddress2();
		this.contactAuthority = companyDetailsEntity.getContactAuthority();
		this.phoneNumber = companyDetailsEntity.getPhoneNumber();
		this.email = companyDetailsEntity.getEmail();
		this.postCode = companyDetailsEntity.getPostCode();
		this.country = companyDetailsEntity.getCountry();
		this.companyNotes = companyDetailsEntity.getCompanyNotes();
		this.lastModifiedDate = System.currentTimeMillis();
	}

	public int getCompanyDetailsId() {
		return companyDetailsId;
	}

	public void setCompanyDetailsId(int companyDetailsId) {
		this.companyDetailsId = companyDetailsId;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getContactAuthority() {
		return contactAuthority;
	}

	public void setContactAuthority(String contactAuthority) {
		this.contactAuthority = contactAuthority;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompanyNotes() {
		return companyNotes;
	}

	public void setCompanyNotes(String companyNotes) {
		this.companyNotes = companyNotes;
	}

	@Override
	public String toString() {
		return "CompanyDetailsEntity [companyDetailsId=" + companyDetailsId + ", companyDetailsGuid="
				+ companyDetailsGuid + ", companyName=" + companyName + ", address1=" + address1 + ", address2="
				+ address2 + ", contactAuthority=" + contactAuthority + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", postCode=" + postCode + ", country=" + country + ", companyNotes=" + companyNotes + "]";
	}

}
