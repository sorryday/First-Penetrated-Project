package com.ssafy.trip.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ssafy.trip.model.dto.TripDto;
public class SelectedPopUpView {
	// tripInfoView에서 가져온 Dto
	private TripDto travelTo;
	
	/** 선택 화면 */
	private JFrame frame;
	
	// 팝업 선택 버튼
	private JButton festivalBt;
	private JButton storeBt;
	
	public SelectedPopUpView(TripDto travelTo) {
		this.travelTo = travelTo;
		
		/* 축제 화면 설정 */
		frame = new JFrame("축제 정보 혹은 상권 정보를 선택하세요.");
		setUI();
		
		frame.setSize(400, 100);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	private void setUI() {
		festivalBt = new JButton("축제 정보");
		storeBt = new JButton("상권 정보");
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		
		northPanel.add(new JLabel("선택한 관광지 근처축제 정보 혹은 상권 정보를 선택하세요.", JLabel.CENTER), "North");
		
		JPanel seletedPanel = new JPanel();
		seletedPanel.add(festivalBt, "West");
		seletedPanel.add(storeBt, "East");
		
		northPanel.add(seletedPanel);
		
		frame.add(northPanel, "Center");
		
		// 축제 화면 이동 리스너
		ActionListener festivalBtHandler = e -> onTrvelInfoView();
		festivalBt.addActionListener( festivalBtHandler );
		
		// 상가 화면 이동 리스너
		ActionListener storeBtHandler = e -> onStoreInfoView();
		storeBt.addActionListener( storeBtHandler );
	}
	
	private void onTrvelInfoView() {
		frame.dispose();
		new TravelInfoView(travelTo);
	}
	
	private void onStoreInfoView() {
		frame.dispose();
		try {
			new StoreInfoView(travelTo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
