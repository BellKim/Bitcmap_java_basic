package View;

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

import main.singleton.Singleton;

public class OrderList_03Result extends JFrame implements MouseListener, ActionListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	private JButton AddOrder;//추가주문하기버튼
	private JButton payment;//결제하기버튼
	
	
	String columnNames[] = {"Espresso Beverages", "크기", "시럽", "샷추가", "휘핑크림", "잔", "총액" };
	
	Object rowData[][];	
	DefaultTableModel model;	// table의 넓이를 설정
	
		
	List<String> list = null;//추후에 추가될 메뉴 리스트. DTO자료형으료 교체
	
	
	public OrderList_03Result() {
		super("메뉴판");
		setLayout(null);
		
		//게시판에 들어오자마자 리스트를 받아오기 위해서 기본 데잍 ㅓ셋팅. 
//		Singleton si = Singleton.getInstance();
//		list = si.bbsCtrl.getBbsList();
		
		
		JLabel label = new JLabel(" 현재까지 주문한 내역입니다.\n 확인후 결제를 눌려주세요.");
		label.setBounds(10, 10, 400, 15);
		add(label);
		
		this.list = list;//리스트에 들어갈 데이터를 이 클래스 안에 대입시킨다.
		
//		rowData = new Object[list.size()][7];
		rowData = new Object[1][7];//임시
		
		
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i <  1; i++) { 	// list.size(); i++) {
//			BbsDto dto = list.get(i);
//			
//			rowData[i][0] = list.get(i).getSeq();			// 글의 번호
//			if(dto.getDel() == 1) {		// 글제목
//				rowData[i][1] = "  ******이 글은 삭제되었습니다*****";
//			}else {
//				rowData[i][1] = dto.getTitle();
//			}			
//			rowData[i][2] = dto.getId();	// 작성자
		}
		
		
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
			
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(300);	// "Espresso Beverages"
		jtable.getColumnModel().getColumn(1).setMaxWidth(50);	// "시럽"
		jtable.getColumnModel().getColumn(2).setMaxWidth(50);	// "크기"
		jtable.getColumnModel().getColumn(3).setMaxWidth(50);	// "샷추가"
		jtable.getColumnModel().getColumn(4).setMaxWidth(50);	// "휘핑크림"
		jtable.getColumnModel().getColumn(5).setMaxWidth(50);	// "잔"
		jtable.getColumnModel().getColumn(6).setMaxWidth(100);	// "총액"
		
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
//		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
//		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
//		"Espresso Beverages", "SHORT", "Tall", "Grande"	
		
		
		
		AddOrder = new JButton(" 주문추가 ");
		AddOrder.addActionListener(this);
		AddOrder.setBounds(10, 380, 150, 50);
		add(AddOrder);
		
		payment = new JButton(" 결제하기 ");
		payment.addActionListener(this);
		payment.setBounds(460, 380, 150, 50);
		add(payment);
		
		
		
		
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//end constructor


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton)e.getSource();
//		Singleton s = Singleton.getInstance();
		if(btn == AddOrder) {
			System.out.println("주문추가하기 버튼 =  " + AddOrder.getText());
			
		}else if(btn == payment){
			System.out.println(" 최종결제하기  버튼 = " + payment.getText());
		}
		
		
		
		
		
		
		
		
		
		
	}

//마우스리스너 마우스리스너
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

	
	
	
	

	
	
	
	
	
	

}//end class
