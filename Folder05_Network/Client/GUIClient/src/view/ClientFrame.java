package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import NET.WriteClass;

//체팅창이 들어가는것.
public class ClientFrame extends JFrame implements WindowListener, ActionListener {
	public Socket socket;
	WriteClass wc;// Writeclass 인스턴스 생성. 전송을 담당하는 클레스이다.

	public JTextField textF = new JTextField(14); // 입력창
	public JTextArea textA = new JTextArea(); //

	JButton btnTransfer = new JButton(" S E N D ");
	JButton btnExit = new JButton(" E X I T ");

	JPanel panel = new JPanel();
	
	public boolean isFirst = true;		//첫 전송인지 여부를 판정함.(ID) 
	
	public ClientFrame(Socket socket) {
		super("CATTINGGGGGGGGGG");
		this.socket = socket;//소켓에 저장해서 전송한다. 
		
		wc = new WriteClass(this);	//전송 클래스 생성.  
		
		new ID(wc, this);
		
		JScrollPane scrPane = new JScrollPane(textA);
		scrPane.setPreferredSize(new Dimension(200, 120));
		
		add("Center", scrPane);
		
		panel.add(textF);
		panel.add(btnTransfer);
		panel.add(btnExit);
		
		add("South",panel);
		
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		
		
		textF.addActionListener(this);
		
		setBounds(300, 300, 450, 300);
		setVisible(false);
	}
	@Override
	public Font getFont() {
		return super.getFont();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnTransfer || obj == textF) {
			if(textF.getText().trim().equals("")) return;
			String id = ID.tf.getText();
			//TextArea 문자열 작성해서 추가.
			textA.append("["+id	+"]" + textF.getText()+"\n");
			
			//server로 전송
			wc.sendMessage();
			textF.setText("");
			
		}else if(obj == btnExit) {
			
		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
