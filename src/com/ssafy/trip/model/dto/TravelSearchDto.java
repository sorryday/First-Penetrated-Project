package com.ssafy.trip.model.dto;

public class TravelSearchDto {
	/** 검색 조건 관광지명 */
	private String travelDestination;
	/** 검색 조건 도로명 주소 시도 */
	private String sido;
	public String getTravelDestination() {
		return travelDestination;
	}
	public void setTravelDestination(String travelDestination) {
		this.travelDestination = travelDestination;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	@Override
	public String toString() {
		return "TravelSearchDto [travelDestination=" + travelDestination + ", sido=" + sido + "]";
	}
}
