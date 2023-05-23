package com.ssafy.trip.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.ssafy.trip.model.dto.TravelDto;
import com.ssafy.trip.model.dto.TravelSearchDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.dto.TripSearchDto;
import com.ssafy.trip.model.service.TravelService;
import com.ssafy.trip.model.service.TravelServiceImpl;
import com.ssafy.trip.model.service.TripService;
import com.ssafy.trip.model.service.TripServiceImpl;

public class TravelInfoView {
	/** model들 */
	private TravelService travelService;

	/** 축제 화면 */
	private JFrame frame;

	/** 조회 내용 표시할 table */
	private DefaultTableModel travelModel;
	private JTable travelTable;
	private JScrollPane travelPan;
	private String[] title = { "번호", "축제이름", "축제장소", "개최기간", "축제유형" };
	
	// tripInfoView에서 가져온 Dto
	private TripDto travelTo;

	public TravelInfoView(TripDto travelTo) {
		this.travelTo = travelTo;
		
		/* Service들 생성 */
		travelService = new TravelServiceImpl();

		/* 축제 화면 설정 */
		frame = new JFrame("Enjoy! Festival!!! - 축제정보");
		
		showTravles();
		setMain();
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}

	/** 메인 화면인 축제 목록을 위한 화면 셋팅하는 메서드 */
	public void setMain() {
		/* 오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightTop = new JPanel(new GridLayout(4, 2));

		JPanel rightCenter = new JPanel(new BorderLayout());
		
		travelTable = new JTable(travelModel);
		travelPan = new JScrollPane(travelTable);
		travelTable.setColumnSelectionAllowed(false);
		rightCenter.add(new JLabel("축제 정보", JLabel.CENTER), "North");
		rightCenter.add(travelPan, "Center");

		right.add(rightTop, "North");
		right.add(rightCenter, "Center");

		JPanel mainP = new JPanel(new GridLayout(1, 2));
		mainP.add(right);

		mainP.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		frame.add(mainP, "Center");
	}
	
	/**
	 * 축제 목록을 갱신하기 위한 메서드
	 */
	public void showTravles() {
		TravelSearchDto travelSearchDto = new TravelSearchDto();
		List<TravelDto> travles = travelService.searchAll(travelSearchDto);
		List<TravelDto> printTravles = new ArrayList();
		
		travelModel = new DefaultTableModel(title, 20);
		
		if (travles != null) {
			int i = 0;
			String getStreetAddress = travelTo.getStreetAddress();
			String getLotAddress = travelTo.getLotAddress();
			
			for (TravelDto travel : travles) {
				if (getStreetAddress.contains(travel.getRegion()) || getLotAddress.contains(travel.getRegion())) {
					printTravles.add(travel);
				}
			}
			
			String[][] data = new String[printTravles.size()][5];
			
			for (TravelDto printTravle : printTravles) {
				data[i][0] = "" + printTravle.getNum();
				data[i][1] = printTravle.getFestivalName();
				data[i][2] = printTravle.getTravelDestination();
				data[i][3] = printTravle.getFestivalPeriod();
				data[i++][4] = printTravle.getFestivalType();
				
				travelModel.setDataVector(data, title);
			}
		}
	}
}
