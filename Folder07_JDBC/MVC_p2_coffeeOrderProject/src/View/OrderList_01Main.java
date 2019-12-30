package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OrderList_01Main extends JFrame implements ActionListener {
	private JTextField idTextF;
	private JTextField passTextF;
	private JTextField nameTextF;
	private JTextField ageTextF;	
	
	private JButton accountBtn;
	private JButton idBtn;	
	
	
	public OrderList_01Main() {
		super("주문");
		setLayout(null);		
		
		JLabel loginLabel = new JLabel("주문화면입니다. 가격표는 오른쪽");
		loginLabel.setBounds(100, 10, 300, 15);
		add(loginLabel);
		
		
		
		

		
		JLabel ageLabel = new JLabel("Age :");
		ageLabel.setBounds(31, 192, 67, 15);
		add(ageLabel);
		
		ageTextF = new JTextField();
		ageTextF.setBounds(100, 192, 150, 20);
		add(ageTextF);
		
		accountBtn = new JButton("주문하기");
		accountBtn.addActionListener(this);
		accountBtn.setBounds(31, 236, 280, 50);
		
		add(accountBtn);		
		
		getContentPane().setBackground(new Color(0, 255, 0));
		setBounds(100, 100, 700, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
