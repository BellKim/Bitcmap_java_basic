package awtSample06;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class windowTest01 implements WindowListener {
	
	public windowTest01() {
		Frame frame = new Frame();
		frame.setTitle(" 윈도우 상단 제목부분 입니다. ");
		frame.setSize(640,480);
		frame.setLocation(100,180);
		frame.setBackground(Color.blue);
		
		frame.setVisible(true);//시각화 여부. 
		
		frame.addWindowListener(this);
		
		
		
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
	public static void main(String[] args) {
		new windowTest01();
	}

}
