package Template;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class motionListener extends Frame implements WindowListener, MouseListener, MouseMotionListener{//mouselistener
	
	Label label;
	int x, y;
	
	public motionListener() {
		super("mouse event");
		setLayout(null);
		
		
		label = new Label("x, y");
		label.setBounds(50, 100, 200, 300);
		add(label);
		setSize(800,600);
	//	setSize(640, 480);
	//	setBounds(0,0,1200, 800);
		setLocation(0,0);
		setVisible(true);
		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	public void method() {
	}
	
		


	@Override
	public void mouseDragged(MouseEvent e) {
		saySomething("Mouse dragged", e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		saySomething("Mouse mouseMoved", e);
		
	}
	
	public void saySomething(String eventDescription, MouseEvent e) {
		label.setText(eventDescription 
                + " (" + e.getX() + "," + e.getY() + ")"
                + " \n detected on "
                + e.getComponent().getClass().getName()
                );
		label.setBounds(e.getX(), e.getY(), 500, 100);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
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
