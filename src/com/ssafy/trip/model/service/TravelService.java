package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TravelSearchDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.dto.TripSearchDto;
public interface TravelService {
	public List<TravelDto> searchAll(TravelSearchDto travelSearchDto);
	public TravelDto search(int num);
}
