package com.ssafy.store;

public class StoreDto {
	private String businessName; // 상호명
	private String businessSelectedName; // 상권업종중분류명
	private String province; // 시도명
	private String lotAddress; // 지번주소
	private String streetAddress; // 도로명 주소
	public String getBusinessName() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessSelectedName() {
		return businessSelectedName;
	}
	public void setBusinessSelectedName(String businessSelectedName) {
		this.businessSelectedName = businessSelectedName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLotAddress() {
		return lotAddress;
	}
	public void setLotAddress(String lotAddress) {
		this.lotAddress = lotAddress;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Override
	public String toString() {
		return "StoreDto [businessName=" + businessName + ", businessSelectedName=" + businessSelectedName
				+ ", province=" + province + ", lotAddress=" + lotAddress + ", streetAddress=" + streetAddress + "]";
	}
	
	
}
