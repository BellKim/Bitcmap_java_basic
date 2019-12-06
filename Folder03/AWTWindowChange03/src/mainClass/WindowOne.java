 package mainClass;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowOne extends Frame implements WindowListener {
	
	public WindowOne() {
		
		
		
		setLayout(null);
		
		Button btn = new Button("move Win");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.win1.setVisible(false);
				s.win2.setVisible(true);
				
			}
		});
		
		add(btn);
		
		
		
		
		setSize(640, 480);
	//	setBounds(0,0,1200, 800);
		setLocation(0,0);
		setBackground(Color.RED);
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
