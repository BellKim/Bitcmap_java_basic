package DAO;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import SingleTon.Singleton;

public class MainMenu extends Frame implements WindowListener {
	Button insertBtn, showAllBtn, deleteBtn, sortBtn;
	
	public MainMenu() {
		/*
			선수추가
			삭제
			조회
			수정
			
		
		*/
		setLayout(null);
		
		insertBtn = new Button(" Insert ");
		insertBtn.setBounds(100, 100, 100, 30);
		insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(false);
				s.insert.setVisible(true);
				s.showAll.setVisible(false);
				s.delete.setVisible(false);
				s.sort.setVisible(false);
			}
		});
		
		showAllBtn = new Button(" ShowAll ");
		showAllBtn.setBounds(100, 200,100,30);
		showAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(false);
				s.insert.setVisible(false);
				s.showAll.setVisible(true);
				s.delete.setVisible(false);
				s.sort.setVisible(false);
				
			}
		});
		
		deleteBtn = new Button(" Delete ");
		deleteBtn.setBounds(100, 300,100,30);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(false);
				s.insert.setVisible(false);
				s.showAll.setVisible(false);
				s.delete.setVisible(true);
				s.sort.setVisible(false);
				
			}
		});
		
		
		sortBtn = new Button(" Sort ");
		sortBtn.setBounds(100, 400,100,30);
		sortBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(false);
				s.insert.setVisible(false);
				s.showAll.setVisible(false);
				s.delete.setVisible(false);
				s.sort.setVisible(true);
				
				
			}
		});
		
		
		
		
		add(insertBtn);
		add(showAllBtn);
		add(deleteBtn);
		add(sortBtn);
		
		
		
		
		
		
		setSize(640, 480);
	//	setBounds(0,0,1200, 800);
		setLocation(0,0);
		setBackground(Color.gray);
		setVisible(false);//싱글톤 제어를위해서 비지블 false로전환 
		addWindowListener(this);
		

	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
