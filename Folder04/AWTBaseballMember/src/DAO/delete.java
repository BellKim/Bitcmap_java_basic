package DAO;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import SingleTon.Singleton;

public class delete extends Frame implements WindowListener {

	Button MainMenu;

	public delete() {
		super("Delete 입니다. ");
		setLayout(null);

		MainMenu = new Button(" MainMenu ");
		MainMenu.setBounds(100, 200, 100, 30);
		MainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(true);
				s.insert.setVisible(false);
				s.showAll.setVisible(false);
				s.delete.setVisible(false);
				

			}
		});
		
		
		

		add(MainMenu);
	

		setSize(1024, 480);
		// setBounds(0,0,1200, 800);
		setLocation(0, 0);
		setBackground(Color.green);
		setVisible(false);// 싱글톤 제어를위해서 비지블 false로전환
		addWindowListener(this);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

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
