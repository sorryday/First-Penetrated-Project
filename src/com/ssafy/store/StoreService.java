package com.ssafy.store;

import java.util.List;

import com.ssafy.trip.model.dto.TripDto;

interface StoreService {
	List<StoreDto> getList();
	void setDataCsv(TripDto travelTo);
	
	
}
