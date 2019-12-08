package awtSample08;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class windowTest08 extends Frame implements WindowListener{	//아이템리스너
	
	Choice choice;
	Label label;
	
	
	
	/*
		AWT - choice
		Swing - JComboBox
		
	*/
	
	
	public windowTest08() {
		super();
		setTitle("windowtest08");
		setLayout(new FlowLayout());
		
		choice = new Choice();
		choice.add("사과");
		choice.add("망고");
		choice.add("오렌지");
		choice.add("포도");
		choice.add("배");
		choice.add("용과");
		
//		choice.addItemListener(this);
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText(choice.getSelectedItem());
				
			}
		});
		
		add(choice);
		
		label = new Label("-=--");
		add(label);

		
		
		setLayout(new FlowLayout());
		setBounds(0,0,640, 480);
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
