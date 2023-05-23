package com.ssafy.store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssafy.trip.model.dto.TripDto;

public class StoreServiceImpl implements StoreService{
	List<StoreDto> StoreDtoList = new ArrayList();

	@Override
	public List<StoreDto> getList() {
		return StoreDtoList;
	}

	@Override
	public void setDataCsv(TripDto travelTo) {
		String[] travelToTemp = null;
		
		if (travelTo.getStreetAddress().equals("")) {
			travelToTemp = travelTo.getLotAddress().split(" ");
		} else if (travelTo.getLotAddress().equals("")) {
			travelToTemp = travelTo.getStreetAddress().split(" ");
		} else {
			travelToTemp = travelTo.getLotAddress().split(" ");
		}
		
		String travelProvince = travelToTemp[0]; // travelTo의 시도명
		
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("res/상권_" + travelProvince + ".csv"));
			
			String line = "";
		    try {
		    	int i = 0;
		        while ((line = file.readLine()) != null) {
		        	if (i != 0) {
						String[] arr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.

						StoreDto sDto = new StoreDto();
						sDto.setBusinessName(arr[1]);
						sDto.setBusinessSelectedName(arr[6]);
						sDto.setProvince(arr[12]);
						sDto.setLotAddress(arr[24]);
						sDto.setStreetAddress(arr[26]);
						
						StoreDtoList.add(sDto);
		        	}
				    i += 1;
		        }

		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (file != null) {
		          file.close();
		        }
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		    }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
