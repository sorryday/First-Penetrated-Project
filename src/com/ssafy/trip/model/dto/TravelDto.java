package com.ssafy.trip.model.dto;

public class TravelDto {
	/*축제 식별 번호*/
	private int num;
	/*개최 지역*/
	private String region;
	/*상세 주소*/
	private String address;
	/*축제 이름*/
	private String festivalName;
	/*축제 종류*/
	private String festivalType;
	/*축제 기간*/
	private String festivalPeriod;
	/*축제 장소*/
	private String festivalPlace;
	/*축제 이미지*/
	private String img;
	
	public TravelDto(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
	}

	public String getFestivalType() {
		return festivalType;
	}

	public void setFestivalType(String festivalType) {
		this.festivalType = festivalType;
	}

	public String getFestivalPeriod() {
		return festivalPeriod;
	}

	public void setFestivalPeriod(String festivalPeriod) {
		this.festivalPeriod = festivalPeriod;
	}

	public String getFestivalPlace() {
		return festivalPlace;
	}

	public void setFestivalPlace(String festivalPlace) {
		this.festivalPlace = festivalPlace;
	}
	
	public String getImage() {
		return img;
	}

	public void setImage(String img) {
		this.img = img;
	}
	
	public String getTravelDestination() {
		return region+" "+address+" "+festivalPlace;
	}

	@Override
	public String toString() {
		return "TravelDto [num=" + num + ", region=" + region + ", address=" + address + ", festivalName="
				+ festivalName + ", festivalType=" + festivalType + ", festivalPeriod=" + festivalPeriod
				+ ", festivalPlace=" + festivalPlace + ", img=" + img + "]";
	}
}
