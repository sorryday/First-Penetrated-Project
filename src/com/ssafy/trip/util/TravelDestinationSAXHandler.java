package com.ssafy.trip.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TripDto;

public class TravelDestinationSAXHandler extends DefaultHandler {
	/**
	 * 축제 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 현재 버전에서는 0번부터 순차 부여한다.
	 */
	private int num;
	/** 축제 정보를 담는다 */
	private List<TravelDto> travels;
	/** 파싱힌 축제 정보 */
	private TravelDto travelDto;
	/** 태그 바디 정보를 임시로 저장 */
	private String temp;

	public TravelDestinationSAXHandler() {
		travels = new ArrayList<TravelDto>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes att) {
		temp = "";
		if (qName.equals("record")) {
			// complete code #04
			// tripDto 객체를 생성(이미지 정보 세팅)하고 trips List에 추가하세요.
			num = travels.size();
			travelDto = new TravelDto(num);
			travels.add(travelDto);
			
			String imgURL = "";
			
//			if(num<9) {
//				imgURL += ("image0"+(num+1));
//			}else if(num<11) {
//				imgURL+=("image"+(num+1));
//			}else {
//				imgURL+=("no_image");
//			}
			
			imgURL+=("no_image");
			travelDto.setImage(imgURL);
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("region")) {
			
			switch (temp) {
			case "경북":
				temp = "경상북도";
				break;
				
			case "경남":
				temp = "경상남도";
				break;
				
			case "충북":
				temp = "충청북도";		
				break;
							
			case "충남":
				temp = "충청남도";
				break;
				
			case "전남":
				temp = "전라남도";
				break;
				
			case "전북":
				temp = "전라북도";
				break;
			}
			
			travelDto.setRegion(temp);
		} else if (qName.equals("address")) {
			travelDto.setAddress(temp);
		} else if (qName.equals("festivalName")) {
			travelDto.setFestivalName(temp);
		} else if (qName.equals("festivalType")) {
			travelDto.setFestivalType(temp);
		} else if (qName.equals("festivalPeriod")) {
			travelDto.setFestivalPeriod(temp);
		} else if (qName.equals("festivalPlace")) {
			travelDto.setFestivalPlace(temp);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		temp = new String(ch, start, length);
	}

	public List<TravelDto> getTravels() {
		return travels;
	}
}
