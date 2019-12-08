package awtSample09;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class windowTest09 extends Frame implements WindowListener{	//아이템리스너
	
	/**
	 * 
	 */
	
	Image img = null;
	Image pngImg = null;
	
	
	
	/*
		
		
	*/
	
	
	public windowTest09() {
		super();
		setTitle("image down");
		setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
//		img = tk.getImage("house.jpg");
//		img = tk.getImage("d:\\tmp\\pig.png");
		img = tk.getImage("\\\\192.168.3.3\\공유\\경치.gif");
		
		pngImg = tk.getImage("bird.png");
		
		
		img.getWidth(this);
		img.getHeight(this);
		
		
	

		setLocation(0, 0);
		setSize(640, 480);
		
		
	//	setBounds(0,0,1200, 800);
		setVisible(true);
		addWindowListener(this);
	}//end end method


//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		Choice ch = (Choice)e.getSource();
//		String selected = ch.getSelectedItem();
//		//선택한 아이템이 나타난다. 
//		label.setText(selected);
//		
//	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		int imgWidth = img.getWidth(this);
		int imgWheight = img.getHeight(this);
		
		System.out.println(imgWidth);
		System.out.println(imgWheight);
		
		setSize(imgWidth, imgWheight);
		
		g.drawImage(img, 0, 0, this);
		g.drawImage(pngImg, 200, 200, this);
		
		
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
