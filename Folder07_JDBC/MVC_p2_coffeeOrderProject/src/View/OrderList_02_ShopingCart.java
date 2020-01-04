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

import Controller.dto.orderList;
import main.singleton.Singleton;

public class OrderList_02_ShopingCart extends JFrame implements MouseListener, ActionListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	private JButton addOrder;//추가주문하기버튼
	private JButton payment;//결제하기버튼
	
	
	String columnNames[] = {"주문한 커피", "사이즈", "시럽", "샷추가", "휘핑추가", "수량", "가격"};
	
	Object rowData[][] = null;	
	DefaultTableModel model;	// table의 넓이를 설정
	List<orderList> list = null;
	Singleton si = Singleton.getInstance();
	
	public OrderList_02_ShopingCart() {
		super("메뉴판");
		setLayout(null);
		
		//게시판에 들어오자마자 리스트를 받아오기 위해서 기본 데잍 ㅓ셋팅. 
		list = si.orderCtrl.getFromCart();
		JLabel label = new JLabel(""+si.getLoginId()+"님이 현재까지 주문한 내역입니다.\n 확인후 결제를 눌려주세요.");
		label.setBounds(10, 10, 400, 15);
		add(label);
		this.list = list;//리스트에 들어갈 데이터를 이 클래스 안에 대입시킨다.		
		rowData = new Object[list.size()][columnNames.length];

		
		
		System.out.println("받아온 내역  ");
		System.out.println(list.toString());
		System.out.println("받아온 내역  ");
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for (int i = 0; i <list.size(); i++) {
			String coffeeName = list.get(i).getName();
			String coffeeSize = list.get(i).getSize();
			list =  si.orderCtrl.getPrice(list);
			int coffeePrice = list.get(i).getPrice();
			
//			System.out.println("커피가격 받아왔나 " + coffeePrice);
//			System.out.println("쇼핑카트리스트 = "+list.get(i).getName());
			
			rowData[i][0] = list.get(i).getName();
			rowData[i][1] = list.get(i).getSize();
			rowData[i][2] = list.get(i).getSyrup();
			rowData[i][3] = list.get(i).isAddShot();
			rowData[i][4] = list.get(i).isWhiping();
			rowData[i][5] = list.get(i).getAmount();
			rowData[i][6] = (list.get(i).getAmount())*(list.get(i).getPrice());
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
			
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(200);	// "주문한 커피"
		jtable.getColumnModel().getColumn(1).setMaxWidth(80);	// "사이즈"
		jtable.getColumnModel().getColumn(2).setMaxWidth(70);	// "시럽추가"
		jtable.getColumnModel().getColumn(3).setMaxWidth(50);	// "샷추가"
		jtable.getColumnModel().getColumn(4).setMaxWidth(60);	// "휘핑추가"
		jtable.getColumnModel().getColumn(5).setMaxWidth(50);	// "수량"
		jtable.getColumnModel().getColumn(6).setMaxWidth(100);	// "갯수당 가격 " (개당가격*수량) 
		
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
//		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
//		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
//		"Espresso Beverages", "SHORT", "Tall", "Grande"	
		
		
		
		int totalPrice = 0;
		for (int i = 0; i < jtable.getRowCount(); i++) {
			totalPrice += (int)(jtable.getValueAt(i, 6));
		}
		
		
		
		JLabel loginLabel = new JLabel("총 금액 : " + totalPrice + " 원");
		loginLabel.setBounds(460, 350, 150, 30);
		add(loginLabel);
		
		addOrder = new JButton(" 추가주문 ");
		addOrder.addActionListener(this);
		addOrder.setBounds(300, 380, 150, 50);
		add(addOrder);
		
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
		if(btn == addOrder) {
			System.out.println("주문추가하기 버튼 =  " + addOrder.getText());
			si.orderCtrl.showOrderList();
			this.dispose();
			
		}else if(btn == payment) {
			System.out.println("결제하기 버튼 =  " + payment.getText());
			//주문내역 최종 결제. ordercontroller 에서 사용자 아이디까지 포함해서 insert 한다. 
			
			String userInfo = si.getLoginId();
			si.orderCtrl.paymentNow(list, userInfo);
		}
	}//end actionPerformed

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
