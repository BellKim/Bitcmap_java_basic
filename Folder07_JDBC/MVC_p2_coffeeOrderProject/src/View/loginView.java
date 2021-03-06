package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.singleton.Singleton;


public class loginView extends JFrame implements ActionListener{
	
	private JTextField idTextF;
	private JPasswordField pwTextF;
	
	private JButton logBtn;
	private JButton accountBtn;
	
	public loginView() {
		super("로그인");
		setLayout(null);
		
		JLabel loginLabel = new JLabel("로그인 화면");
		loginLabel.setBounds(100, 10, 120, 15);
		add(loginLabel);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTextF = new JTextField(10);
		idTextF.setBounds(100, 60, 100, 20);
		add(idTextF);
		
		JLabel passLabel = new JLabel("PW:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		pwTextF = new JPasswordField();
		pwTextF.setBounds(100, 104, 100, 20);
		add(pwTextF);
				
		logBtn = new JButton("log-in");
		logBtn.setBounds(240, 60, 100, 65);
		//x y 너비 높이
		logBtn.addActionListener(this);
		add(logBtn);
		
		accountBtn = new JButton("회원가입");
		accountBtn.setBounds(30, 140, 310, 40);
		accountBtn.addActionListener(this);
		add(accountBtn);
		
		setBounds(200, 200, 400, 260);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				System.exit(0);				
			}			
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		JButton btn = (JButton)e.getSource();
				
		MemberDao dao = MemberDao.getInstance();
		if(btn == logBtn){	// log in
			MemberDto mem = dao.login(idTextF.getText(), pwTextF.getText()); 
			if(mem == null) {
				JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다");
			}else {
				JOptionPane.showMessageDialog(null, mem.getId() + "님 환영합니다");
				this.dispose();
				
				// login한 id를 저장	-> Session(Web)
				dao.setLoginID(mem.getId());
				
				new bbsListView();
			}			
		}
		else if(btn == accountBtn){ // 회원가입
			new accountView();
			this.dispose();
		}
		*/
		JButton btn = (JButton)e.getSource();
		Singleton s = Singleton.getInstance();
		if(btn == logBtn) {
			System.out.println("로그인 버튼 입력됨.");
			s.memCtrl.loginAf(idTextF.getText(), pwTextF.getText());
			this.dispose();
			
		}else {
			s.memCtrl.regi();
			this.dispose();
		}
		
	}
	

}
