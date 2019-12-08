package mouselistener;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table extends JFrame implements WindowListener, MouseListener{//mouselistener
	JTable table;
	JScrollPane scrPane;
	String columnNames[] = {
			"상품번호", "상품명", "상품가격", "상품회사"
	};
	
	Object rowDatas[][] = {
			{1001, "맛동산", 1000, "오리온"},
			{1002, "빅파이", 1200, "해태"},
			{1003, "몽쉘", 1500, "롯데"},
			{1004, "감자깡", 1900, "몰라"},
			
	};//데이터를 삽입하는 배열이다. 
	
	
	
	public Table() {
		super();

	table = new JTable(rowDatas, columnNames);
	table.addMouseListener(this);
	scrPane = new JScrollPane(table);
	add(scrPane);
	
	

		
		
		setSize(640, 480);
//		setBounds(0,0,1200, 800);
		setLocation(100,0);
		setVisible(true);
		addWindowListener(this);


	}


	@Override
	public void mousePressed(MouseEvent e) {
		int rowNum = table.getSelectedRow();
		JOptionPane.showMessageDialog(null, "rowNum = " + rowNum);
		
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


	@Override
	public void mouseClicked(MouseEvent e) {
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

}
