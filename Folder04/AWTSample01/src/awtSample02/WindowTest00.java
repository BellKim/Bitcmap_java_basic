package awtSample02;

import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class WindowTest00 extends JFrame implements WindowListener {
	
	public WindowTest00() {
		super();
		setTitle("레이블");
		
		setBounds(0,0,640, 480);
		setVisible(true);
		addWindowListener(this);
		Label label = new Label();
		
		label.setText("여기가 레이블입니다 ");
		add(label);
		
		System.out.println("WindowTest WindowTest() ");
		
		Label lable1 = new Label("추가레이블입니다. ");
		add(lable1);
		
		
		//팝업이 생성됩니다. 
		JOptionPane.showMessageDialog(null, "windowTestWindowTest(); 실행 ");
		
		
		
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
