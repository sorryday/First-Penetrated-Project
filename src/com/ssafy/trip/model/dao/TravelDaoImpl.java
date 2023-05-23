package com.ssafy.trip.model.dao;

import java.util.LinkedList;
import java.util.List;

import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TravelSearchDto;
import com.ssafy.trip.util.TravelDestinationSAXParser;


public class TravelDaoImpl implements TravelDao {

	private List<TravelDto> travelInfo;

	public TravelDaoImpl() {
		loadData();
	}
	/**
	 * 관광지 정보를 xml 파일에서 읽어온다.
	 */
	@Override
	public void loadData() {
		TravelDestinationSAXParser parser = new TravelDestinationSAXParser();
		travelInfo = parser.getTravelInfo();
	}

	@Override
	public List<TravelDto> searchAll(TravelSearchDto travelSearchDto) {
		List<TravelDto> finds = new LinkedList<TravelDto>();

		String travelDestination = travelSearchDto.getTravelDestination();//축제
		String sido = travelSearchDto.getSido(); // 주소
		if (travelDestination != null) {
			for (TravelDto travel : travelInfo) {
				if (travel.getTravelDestination().contains(travelDestination)) {
					finds.add(travel);
				}
			}
		 
		} else {
			finds = travelInfo;
		}
		return finds;
	}

	@Override
	public TravelDto search(int num) {
		//은진 : 맞는지 잘 모르겠음!
		// complete code #03
		// List<TripDto> tripInfo 로부터 num 에 해당하는 TripDto 정보를 검색하여 return 하도록 코드를 작성하세요.
		// 해당하는 num이 없을 경우 null을 리턴하세요.
		for(TravelDto dto : travelInfo) {
			if(dto.getNum()==num) {
				return dto;
			}
		}

		return null;
	}

	public static void print(List<TravelDto> travels) {
		for (TravelDto trip : travels) {
			System.out.println(trip);
		}
	}
}
