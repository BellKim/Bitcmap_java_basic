package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.BbsDto;
import javabean.BbsDao;

public class bbsListView extends JFrame implements MouseListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	private JButton writeBtn;	
	
	String columnNames[] = {
		"번호", "제목", "작성자"	
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	// table의 넓이를 설정
	
	List<BbsDto> list = null;
	
	public bbsListView() {
		super("게시판");
		
		setLayout(null);
				
		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		// dao를 통해서 list를 취득
		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList();
		
		// jtable row를 생성
		rowData = new Object[list.size()][3];
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i < list.size(); i++) {
			BbsDto dto = list.get(i);
			
			rowData[i][0] = i + 1;			// 글의 번호
			rowData[i][1] = dto.getTitle();	// 글의 제목
			rowData[i][2] = dto.getId();	// 작성자
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
		
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);	// 번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);	// 제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);	// 작성자
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		writeBtn = new JButton("글쓰기");
		writeBtn.setBounds(510, 10, 100, 20);
		add(writeBtn);		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
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

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
