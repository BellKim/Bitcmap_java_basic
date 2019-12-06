package awtSample04;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class myPanel extends Panel {
	
	public myPanel() {
		setLayout( new GridLayout(3, 1));
		setBackground(Color.yellow);
		
		Label l1 = new Label("MyPanel label1 ");
		Label l2 = new Label("MyPanel label1 ");
		Label l3 = new Label("MyPanel label1 ");
		add(l1);
		add(l2);
		add(l3);
	}

}
