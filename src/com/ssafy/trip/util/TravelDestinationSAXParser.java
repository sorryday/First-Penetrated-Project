package com.ssafy.trip.util;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TripDto;

/**
 * TouristDestinationSAXHandler를 이용해서 관광지 정보를 load하는 SAX Parser 프로 그램
 */
public class TravelDestinationSAXParser {
//	private Map<String, List<TripDto>> trips;
	private List<TravelDto> travelInfo;
	private int size;
	/**
	 * 관광지 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 현재 버전에서는 0번부터 순차 부여한다.
	 */
	public int num;

	public TravelDestinationSAXParser() {
		// complete code #08
		// 전국관광지정보표준데이터.xml을 loading하도록 처리하세요.
		loadData();
	}

	/**
	 * TouristDestinationSAXHandler를 이용 파싱한 관광지 정보를 추출한다.
	 */
	private void loadData() {

		SAXParserFactory factory = SAXParserFactory.newInstance();

		String festivalInfoFilePath = "res/지역축제정보.xml";

		try {
			SAXParser parser = factory.newSAXParser();
			TravelDestinationSAXHandler handler = new TravelDestinationSAXHandler();
			parser.parse(festivalInfoFilePath, handler);
			travelInfo = handler.getTravels();

			size = travelInfo.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TravelDto> getTravelInfo() {
		return travelInfo;
	}

	public void setTravelInfo(List<TravelDto> travelInfo) {
		this.travelInfo = travelInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void main(String[] args) {
		new TravelDestinationSAXParser();
	}
}

