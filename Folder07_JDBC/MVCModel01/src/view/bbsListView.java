package view;

import java.awt.Color;

import javax.swing.JFrame;

public class bbsListView extends JFrame {

	public bbsListView() {
		super("게시판");
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
