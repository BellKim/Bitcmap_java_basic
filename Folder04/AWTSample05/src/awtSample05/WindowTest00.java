package awtSample05;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest00 extends Frame implements WindowListener{//, ActionListener{
	
	Label label;
	Button btn1, btn2;
	
	public WindowTest00() {
		super("간단한 예제");
		setLayout(null);
		/*
			resource(자원) : button, panel, testfield -> hanele(번호)
		*/
		
		label = new Label("레이블");
		label.setBounds(100,100,300,30);
		add(label);
		
//		btn1 = new Button("버튼 one");
//		btn1.setBounds(100, 160, 150,30);
//		btn1.addActionListener(this);
//		add(btn1);
//		
//		
//		btn2 = new Button("버튼 two" );
//		btn2.setBounds(300, 160, 150, 30);
//		btn2.addActionListener(this);
//		add(btn2);
		
		btn1 = new Button("버튼 one");
		btn1.setBounds(100, 160, 150,30);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println();
				label.setText("one 버튼이 클릭. !! ");
				
			}
		});
		add(btn1);
		
		
		setSize(640, 480);	//윈도우의 크기( 폭, 높이)
		setLocation(10, 10);	//창이 실행되는 위치.
		setVisible(true);	//윈도우의 시각화여부
		
		addWindowListener(this); 	//윈도우 리스너의 메소드 추가여부
		
		
		
		
	}//end class
/*	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "버튼클릭 ");
		
		Button btn = (Button)e.getSource();
		String btntitle = btn.getLabel();
		
		if(btntitle.equals("버튼 one")) {
			JOptionPane.showMessageDialog(null, "버튼클릭 ");
			label.setText("111111");
			
		}else if(btntitle.equals("버튼 two")) {
			
			label.setText("two 버튼이 입력되었습니다. ");
			
		}
		
		
	}
	*/
	/*
		액션리스너 임플리먼트하고, 버튼마다 	btn2.addActionListener(this); 를 추가해주고, 
	
*/
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println(" windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("window closeing ");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println(" windowClosed ");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("window Iconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println(" windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println(" window Activated ");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("window Deactived ");
		
	}



}//end class
