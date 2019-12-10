package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import NET.WriteClass;

//아이디 등록창.
//아이디를 입력하기 위한 폼이다. 

public class ID  extends JFrame implements ActionListener{
	
	
	
	public static TextField tf = new TextField(8);
	Button btn = new Button("input");
	
	WriteClass wc;
	ClientFrame cf;
	
	
	
	
	
	public ID(WriteClass wc, ClientFrame cf) {
		
		this.wc = wc;
		this.cf = cf;
		
		
		
		setTitle("idImput ");
		setLayout(null);
		
		Label label = new Label(" id : ");
		label.setBounds(50,60,30,30);
		
		add(label);
		
		tf.setBounds(80,60,100,30);
		add(tf);
		
		btn.setBounds(80,110,100,30);
		btn.addActionListener(this);
		
		add(btn);
		setBounds(300,300,250,200);
		
		setBackground(Color.gray);
		
		setVisible(true);
				
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		wc.sendMessage();		//ㅑid  전송	
		cf.isFirst = false;	//client frame 에 있는 isFirst = true 를 false 로 바꿔준다.
							//첫번재 정송이 긑났음.
		cf.setVisible(true);	//채팅창을 활성화한다.
		this.dispose();			//			 
		
		
	}
	
	
	
	
	

}//end class 
