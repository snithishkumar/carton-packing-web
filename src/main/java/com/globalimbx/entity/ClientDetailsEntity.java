package com.globalimbx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientDetails")
public class ClientDetailsEntity {

	public static final String CLIENT_ID = "clientId";
	public static final String CLIENT_GUID = "clientGuid";
	public static final String COMPANY = "company";
	public static final String CONTACT_AUTHORITY = "contactAuthority";
	public static final String TIN_NUMBER = "tinNumber";
	public static final String ADDRESS1 = "address1";
	public static final String ADDRESS2 = "address2";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String EMAIL = "email";
	public static final String POST_CODE = "postCode";
	public static final String COUNTRY = "country";
	public static final String CONSIGNEE_NOTES = "consigneeNotes";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ClientId")
	private int clientId;
	@Column(name = "ClientGuid")
	private String clientGuid;
	@Column(name = "Company")
	private String company;
	@Column(name = "ContactAuthority")
	private String contactAuthority;
	@Column(name = "TinNumber")
	private String tinNumber;
	@Column(name = "Address1")
	private String address1;
	@Column(name = "Address2")
	private String address2;
	@Column(name = "PhoneNumber")
	private String phoneNumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "PostCode")
	private String postCode;
	@Column(name = "Country")
	private String country;
	@Column(name = "ConsigneeNotes")
	private String consigneeNotes;
	@Column(name = "LastModifiedDate")
	private long lastModifiedDate;

	public ClientDetailsEntity() {

	}

	
	public void copyVal(ClientDetailsEntity clientDetailsEntity){
		this.clientGuid = clientDetailsEntity.getClientGuid();
		this.company = clientDetailsEntity.getCompany();
		this.contactAuthority = clientDetailsEntity.getContactAuthority();
		this.address1 = clientDetailsEntity.getAddress1();
		this.address2 = clientDetailsEntity.getAddress2();
		this.consigneeNotes = clientDetailsEntity.getConsigneeNotes();
		this.country = clientDetailsEntity.getCountry();
		this.email = clientDetailsEntity.getEmail();
		this.phoneNumber = clientDetailsEntity.getPhoneNumber();
		this.postCode = clientDetailsEntity.getPostCode();
		this.tinNumber = clientDetailsEntity.getTinNumber();
		this.lastModifiedDate = clientDetailsEntity.getLastModifiedDate();

	}

	public long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientGuid() {
		return clientGuid;
	}

	public void setClientGuid(String clientGuid) {
		this.clientGuid = clientGuid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContactAuthority() {
		return contactAuthority;
	}

	public void setContactAuthority(String contactAuthority) {
		this.contactAuthority = contactAuthority;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
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

	public String getConsigneeNotes() {
		return consigneeNotes;
	}

	public void setConsigneeNotes(String consigneeNotes) {
		this.consigneeNotes = consigneeNotes;
	}

	@Override
	public String toString() {
		return "ClientDetailsEntity [clientId=" + clientId + ", clientGuid=" + clientGuid + ", company=" + company
				+ ", contactAuthority=" + contactAuthority + ", tinNumber=" + tinNumber + ", address1=" + address1
				+ ", address2=" + address2 + ", phoneNumber=" + phoneNumber + ", email=" + email + ", postCode="
				+ postCode + ", country=" + country + ", consigneeNotes=" + consigneeNotes + "]";
	}

}
