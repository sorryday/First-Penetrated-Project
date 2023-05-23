package com.ssafy.trip.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.store.StoreDto;
import com.ssafy.store.StoreServiceImpl;
import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TravelSearchDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.service.TravelService;
import com.ssafy.trip.model.service.TravelServiceImpl;

public class StoreInfoView {
	/** model들 */
	private StoreServiceImpl storeService;

	/** 상권 화면 */
	private JFrame frame;

	/** 조회 내용 표시할 table */
	private DefaultTableModel travelModel;
	private JTable travelTable;
	private JScrollPane travelPan;
	private String[] title = { "번호", "상호명", "상권업종중분류명", "시도명", "지번주소", "도로명주소"};
	
	// tripInfoView에서 가져온 Dto
	private TripDto travelTo;

	public StoreInfoView(TripDto travelTo) throws Exception {
		this.travelTo = travelTo;
		
		/* Service들 생성 */
		storeService = new StoreServiceImpl();

		/* 상권 화면 설정 */
		frame = new JFrame("Enjoy! Store!!! - 상권 정보");
		
		setStoreDate();
		showTravles();
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	// 상권 데이터 셋팅
	private void setStoreDate() throws Exception {
		storeService.setDataCsv(travelTo);
	}
	/** 상권 목록을 위한 화면 셋팅하는 메서드 */
	public void setMain() {
		/* 오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));

		JPanel rightCenter = new JPanel(new BorderLayout());
		
		travelTable = new JTable(travelModel);
		travelPan = new JScrollPane(travelTable);
		travelTable.setColumnSelectionAllowed(false);
		rightCenter.add(new JLabel("상권 정보", JLabel.CENTER), "North");
		rightCenter.add(travelPan, "Center");

		right.add(rightTop, "North");
		right.add(rightCenter, "Center");

		JPanel mainP = new JPanel(new GridLayout(1, 2));

		mainP.add(right);

		mainP.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		frame.add(mainP, "Center");
	}
	
	/**
	 * 상권 목록을 갱신하기 위한 메서드
	 */
	public void showTravles() {
		List<StoreDto> sDtoList = storeService.getList();
		List<StoreDto> printStore = new ArrayList();
		
		travelModel = new DefaultTableModel(title, 20);
		
		if (sDtoList != null) {
			int i = 0;
			String[] travelToArr = null;
			
			if (travelTo.getStreetAddress().equals("")) {
				travelToArr = travelTo.getLotAddress().split(" ");
			} else if (travelTo.getLotAddress().equals("")) {
				travelToArr = travelTo.getStreetAddress().split(" ");
			} else {
				travelToArr = travelTo.getLotAddress().split(" ");
			}
			
			for (StoreDto store : sDtoList) {
				if (store.getProvince().contains(travelToArr[0]) && store.getLotAddress().contains(travelToArr[1])) {
					printStore.add(store);
				}
			}
			
			String[][] data = new String[printStore.size() + 1][6];
			
			int numFlag = 1;
			for (StoreDto p_store : printStore) {
				data[i][0] = "" + numFlag;
				data[i][1] = p_store.getBusinessName();
				data[i][2] = p_store.getBusinessSelectedName();
				data[i][3] = p_store.getProvince();
				data[i][4] = p_store.getLotAddress();
				data[i++][5] = p_store.getStreetAddress();
				
				travelModel.setDataVector(data, title);
				numFlag += 1;
			}
		}
	}
}
