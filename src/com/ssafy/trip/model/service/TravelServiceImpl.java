package com.ssafy.trip.model.service;

import java.util.List;

import com.ssafy.trip.model.dao.TravelDao;
import com.ssafy.trip.model.dao.TravelDaoImpl;
import com.ssafy.trip.model.dao.TripDao;
import com.ssafy.trip.model.dao.TripDaoImpl;
import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TravelSearchDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.dto.TripSearchDto;

public class TravelServiceImpl implements TravelService {
	private TravelDao travelDao;

	public TravelServiceImpl() {
		travelDao = new TravelDaoImpl();
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 관광지 정보(TripDto)를 검색해서 반환.
	 * 
	 * @param tripSearchDto 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 관광지 목록
	 */
	@Override
	public List<TravelDto> searchAll(TravelSearchDto travelSearchDto) {
		return travelDao.searchAll(travelSearchDto);
	}

	/**
	 * 관광지 식별 번호에 해당하는 아파트 거래 정보를 검색해서 반환.
	 * 
	 * @param num 검색할 관광지 식별 번호
	 * @return 관광지 식별 번호에 해당하는 관광지 정보를 찾아서 리턴한다, 없으면 null이 리턴됨
	 */
	@Override
	public TravelDto search(int num) {

		// complete code #02
		// null 을 return 하면 안됩니다. Dao Layer 의 적절한 method를 호출하여 Business Logic 을 완성하세요.
		TravelDto dto = travelDao.search(num);
		if(dto!=null) {
			return dto;
		} else {
			TravelDto dtoNullException = travelDao.search(0);
			return dtoNullException;
		}
	}
	
	
}
