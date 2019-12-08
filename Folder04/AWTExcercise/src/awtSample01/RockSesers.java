package awtSample01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RockSesers extends JFrame{//, ActionListener{
	
	TextField topTextfield, winLoseTextFild;		//승 무 패 표기
	Label label;
	int win=0,mu=0,lose=0;
	JButton scissorsBtn, rockBtn, paperBtn; 

	
	  

	
	public RockSesers() {
		super(" 가위바위보예제 ");
		JPanel mainPanel = new JPanel(new GridLayout(4, 1));
		JPanel lineOne= new JPanel();
		JPanel LineTwo= new JPanel(new GridLayout(1,2));
		JPanel two_one=new JPanel();
		JPanel two_two=new JPanel();
		JPanel LineThree = new JPanel(new GridLayout(1,3));
		JPanel lineFour = new JPanel();
		
		
		LineTwo.setLayout(new GridLayout(2,1));
//		textArea = new JTextArea();
//		textArea.setLineWrap(true);
		
//		JScrollPane scrPane = new JScrollPane(textArea);
		
		label = new Label();
		topTextfield = new TextField();
		winLoseTextFild=new TextField("결과");
		
		topTextfield.setPreferredSize(new Dimension(200, 50));
		topTextfield.setText("");	//Integer.toString(num)
		lineOne.add(topTextfield);
		
		winLoseTextFild.setPreferredSize(new Dimension(100, 50));
		winLoseTextFild.setText("");	//Integer.toString(num)
//		LineThree.add(winLoseTextFild);
		
		JLabel PlayerLabel = new JLabel("Player");
		


		JLabel ComLabel= new JLabel("Computer");
//		ComLabel.setText("Computer");

		
		
		Label playerOut= new Label();
		Label Result = new Label();
		Label ComOut = new Label();
		

		
		scissorsBtn = new JButton("가위");
		rockBtn = new JButton("바위");
		paperBtn = new JButton("보");
		
		rockBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		scissorsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		paperBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
//		lineTwo
		
//		LineThree.add();
		
//		LineOne.add();
		
//		LineTwo.setLocation(p);
//		LineTwo.setSize(d);

		two_one.add(PlayerLabel);
		two_two.add(ComLabel);
		
//		LineTwo.add(PlayerLabel);//,BorderLayout.EAST);
//		LineTwo.add(ComLabel);//,BorderLayout.WEST);
		
		LineTwo.add(two_one,BorderLayout.EAST);
		LineTwo.add(two_two,BorderLayout.WEST);		
		
		LineThree.add(playerOut);
		LineThree.add(Result);
		LineThree.add(ComOut);
		
		lineFour.add(rockBtn);
		lineFour.add(scissorsBtn);
		lineFour.add(paperBtn);
		
		
		mainPanel.add(lineOne);
		mainPanel.add(LineTwo);
		mainPanel.add(LineThree);
		mainPanel.add(lineFour);
		

		
		
		//layout
		
		Container contentPane = getContentPane();
		
//		topTextfield = new TextField();
//		winLoseTextFil
		
		
//		contentPane.add(topTextfield, BorderLayout.NORTH);
		contentPane.add(mainPanel,BorderLayout.CENTER);
		
		
		
		setSize(500, 500);	//윈도우의 크기( 폭, 높이)
		setLocation(10, 10);	//창이 실행되는 위치.
		setVisible(true);	//윈도우의 시각화여부
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}//end class

	public static void main(String[] args) {
		new RockSesers();

	}



}//end class
