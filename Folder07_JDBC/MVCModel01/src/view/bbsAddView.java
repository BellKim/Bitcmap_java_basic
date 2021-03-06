package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.BbsDTO;
import javabean.BbsDao;
import javabean.MemberDAO;


public class bbsAddView extends JFrame implements ActionListener, WindowListener{

	JTextField writerText;
	JTextField titleText;
	JTextArea contentArea;
	
	JButton btn;
	JButton backBtn;
	
	public bbsAddView() {//로그인한 후 글쓰기창
		super("글쓰기");
		setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 120, 15);
		add(writerLabel);		
		
		MemberDAO dao = MemberDAO.getInstance();
				
		writerText = new JTextField(dao.getLoginID());
		writerText.setBounds(120, 10, 200, 20);
		writerText.setEditable(false);		
		add(writerText);
		
		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 40, 120, 15);
		add(titleLabel);
		
		titleText = new JTextField();
		titleText.setBounds(120, 40, 350, 20);
		add(titleText);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 70, 120, 15);
		add(contentLabel);
		
		contentArea = new JTextArea();	
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 100, 460, 300);
		add(scrPane);
		
		btn = new JButton("글올리기");
		btn.setBounds(150, 420, 100, 20);		
		add(btn);
		
		setBounds(100, 100, 500, 500);
		setVisible(true);	
		
		backBtn = new JButton("목록");
		backBtn.setBounds(10, 420, 100, 20);		
		add(backBtn);
		
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn.addActionListener");
								
				String id = dao.getLoginID();
				String title = titleText.getText();
				String content = contentArea.getText();
				
//				System.out.println("ID 값을 출력합니다. " + id+"\n title = " + title +"\n content = " + content);
				
				BbsDao dao = BbsDao.getInstance();
												
				BbsDTO dto = new BbsDTO(0, id, title, content, null, 0, 0);				
				boolean b = dao.writeBBS(dto);
				if(b){
					JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
					new bbsListView();
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
				}
				
			}
		});
		
		backBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bbsListView();
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	
//윈도우 리스너 
	@Override
	public void windowOpened(WindowEvent e) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
