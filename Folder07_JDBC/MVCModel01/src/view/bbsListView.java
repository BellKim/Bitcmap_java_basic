package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.BbsDTO;
import javabean.BbsDao;
import javabean.MemberDAO;

public class bbsListView extends JFrame implements MouseListener, ActionListener{
	
	private JTable jtable;
	private JScrollPane jscrPane;//스크롤 생겨나는영역
	
	private JButton writeBtn;
	private JButton logoutBtn;
	
	String ColumnNames[] = {
		"번호", "제목", "작성자"	
	};
	Object rowData[][];
	DefaultTableModel model;		//table의 넓이를 설정하기 위해서 필요.
	List<BbsDTO> list= null;

	public bbsListView() {		//테이블 구조로 되어있는 글 리스트 
		super("게시판");
		setLayout(null);
		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		//dao를 통해서 list를 취득한다.
		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList();
		
		//JTable의 ROW 를 생성 
		rowData = new Object[list.size()][3];//ColumnNames 의 사이즈.
		
		//list  에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			BbsDTO dto = list.get(i);
			
//			if(list.get(i).getDel() ==1) {//del이 1일경우, 다음리스트를 불러오며, list.size()+1일경우 조건문을 탈출하도록함.  
//				if(list.size()<list.get(i).getDel()) {
//					break;
//				}else {
//					i++;
//				}
//			}else {
				rowData[i][0] = i + 1;//글번호.
				rowData[i][1] = dto.getTitle();	//글제목
				rowData[i][2] = dto.getId();
//			}
		}
		
		//테이블 관련
		//테이블 쪽을 설정하기 위한 model
		model = new DefaultTableModel(ColumnNames, 0);
		model.setDataVector(rowData, ColumnNames);
		
		//테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
		
		//column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);	//번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);	//제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);	//작성자
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(10, 10, 100, 20);
		writeBtn.addActionListener(this);						   
		add(writeBtn);
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(510, 10, 100, 20);
		
		
		logoutBtn.addActionListener(this);
		add(logoutBtn);
		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == logoutBtn){
			MemberDAO dao = MemberDAO.getInstance();
			dao.setLoginID("");
			this.dispose();
			new loginView();
			
		}else if(obj == writeBtn){
			this.dispose();
			new bbsAddView();	
		}	
	}
	

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	

		Object obj = e.getSource();
		
		System.out.println(jtable.getSelectedColumn());
		System.out.println(jtable.getSelectedRow());
		System.out.println();
		int rowNum = jtable.getSelectedRow();
		list.get(rowNum);
		System.out.println(list.get(jtable.getSelectedRow()).toString());
		BbsDao sendToBbsDetail = 
		
		
		
		
		
//		클릭시 창이 뜬다.
		new bbsDetail();
		this.dispose();
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
