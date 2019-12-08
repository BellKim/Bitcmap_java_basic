package awtSample04;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class windowTest extends Frame implements WindowListener {
	
	
	public windowTest() {
/*
		super("layout");
		setTitle("상단테이블");		
//	setLayout(new FlowLayout());
//		setLayout(new GridLayout(3, 1));//3행 1열로 사용.
//	setLayout(null);	//null로 사용할경우에 일일이 위치를 잡아줘야한다.
		setBounds(0,0,640, 480);
		setVisible(true);
		addWindowListener(this);
*/
		//panel == 종이위에 종이
		setLayout(new GridLayout(2,1));
		
		//label => 위부분
//		Label label = new Label("label");
//		add(label);
		
		myPanel myP = new myPanel();
		add(myP);
		
		//panel
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(1,2));
		panel.setBackground(Color.cyan);
		
		add(panel);
		
		Label label1 = new Label();
		label1.setText("hello");
		panel.add(label1);
		
		Button button = new Button("button");
		add(button);
		
		
		
		setSize(640, 480);
//		setBounds(0,0,640, 480);
		setVisible(true);
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
	public static void main(String[] args) {
		new windowTest();
	}

}
