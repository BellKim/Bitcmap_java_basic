package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.MemberDTO;
import javabean.BbsDao;
import javabean.MemberDAO;

public class bbsDetail extends JFrame implements ActionListener, WindowListener{
	   private JTextField writerTextF;
	   private JTextField wdateTextF;
	   private JTextField countTextF;
	   private JTextField titleTextF;
	   private JTextArea contentsTextF;
	   
	   private JButton updateBtn;
	   private JButton deleteBtn;
	   
	   public bbsDetail() {
	      super("글보기?");
	      setLayout(null);
	      BbsDao bbdao = BbsDao.getInstance();
	      JLabel wLabel = new JLabel("");
	      wLabel.setBounds(100, 10, 120, 15);
	      add(wLabel);
	      
	      JLabel writerLabel = new JLabel("작성자:");
	      writerLabel.setBounds(31, 60, 67, 15);
	      add(writerLabel);
	      
	      MemberDAO dao = MemberDAO.getInstance();
	      writerTextF = new JTextField(dao.getLoginID());
	      writerTextF.setBounds(100, 60, 150, 20);
	      writerTextF.setEditable(false);
	      add(writerTextF);
	      writerTextF.setColumns(10);
	      
	      
	      JLabel wdateLabel = new JLabel("작성일:");
	      wdateLabel.setBounds(31, 104, 67, 15);
	      add(wdateLabel);
	      
	      BbsDao bDao = BbsDao.getInstance();
	      wdateTextF = new JTextField(bbdao.getBdto().getWdate());
	      wdateTextF.setBounds(100, 104, 150, 20);
	      add(wdateTextF);
	      
	      JLabel countLabel = new JLabel("조회수");
	      countLabel.setBounds(31, 148, 67, 15);
	      add(countLabel);
	      
	      countTextF = new JTextField(bbdao.getBdto().getReadcount());
	      countTextF.setBounds(100, 148, 150, 20);
	      add(countTextF);
	      
	      JLabel titleLabel = new JLabel("제목:");
	      titleLabel.setBounds(31, 192, 67, 15);
	      add(titleLabel);
	      
	      titleTextF = new JTextField(bbdao.getBdto().getTitle());
	      titleTextF.setBounds(100, 192, 150, 20);
	      add(titleTextF);
	      
	      JLabel contentsLabel = new JLabel("내용:");
	      contentsLabel.setBounds(31, 236, 67, 15);
	      add(contentsLabel);
	      
	      contentsTextF = new JTextArea(bbdao.getBdto().getContent());
	      contentsTextF.setLineWrap(true);
	      
	      JScrollPane scrPane = new JScrollPane(contentsTextF);
	      scrPane.setPreferredSize(new Dimension(200,120));
	      scrPane.setBounds(31, 260, 250, 140);
	      add(scrPane);
	      
	      updateBtn = new JButton("수정");
	      updateBtn.addActionListener(this);
	      updateBtn.setBounds(31, 410, 100, 20);
	      add(updateBtn);
	      
	      deleteBtn = new JButton("삭제");
	      deleteBtn.addActionListener(this);
	      deleteBtn.setBounds(150, 410, 100, 20);
	      add(deleteBtn);

	      
	      
	      
	      setBounds(100, 100, 320, 480);
	      setVisible(true);
	      
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	   }

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      // TODO Auto-generated method stub
	      JButton btn = (JButton)e.getSource();
	      String btnTitle = btn.getLabel();
	      
	      MemberDAO dao = MemberDAO.getInstance();
	      if(btn == deleteBtn) {
	         MemberDTO mem = dao.login(dao.getLoginID(), null);
	      }
	   }

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		new bbsListView();
		this.dispose();
		
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
