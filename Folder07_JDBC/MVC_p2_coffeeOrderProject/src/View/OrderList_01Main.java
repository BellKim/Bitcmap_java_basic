package View;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OrderList_01Main extends JFrame implements ActionListener, ItemListener, MouseListener {

	private JTextField orderCountTextF;	
	private JButton MenuButton;
	
	JRadioButton size1, size2, size3, syrupOption1, syrupOption2, syrupOption3;    
	Label label1, label2;
	JRadioButton jradiobutton;
	
	//OtherSelect 기타
    JLabel othersTitle;  
    JCheckBox addShot,addWhiping;  
    
    //커피선택
    JComboBox<String> coffeeListBox;
    
    //최종주문
    JButton finalOrder;
    
    //
	

	
	public OrderList_01Main() {
		super("주문");
		setLayout(null);		
		
		JLabel loginLabel = new JLabel("주문화면입니다. 가격표는 오른쪽");
		loginLabel.setBounds(100, 10, 300, 15);
		add(loginLabel);
		
		MenuButton = new JButton("Show MenuAll");
		MenuButton.addActionListener(this);
		MenuButton.setBounds(500, 10, 150, 50);
		
		add(MenuButton);
		
		
		String[] coffeeList = {
				"헤이즐넛 카라멜 모카",
				"카라멜  마끼아또",
				"화이트 초콜릿 모카",
				"카라멜 모카",
				"카페 모카",
				"카라멜 라떼",
				"카페 라떼",
				"카푸치노",
				"아메리카노",
				"오늘의 커피"};

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		coffeeListBox = new JComboBox(coffeeList);
		coffeeListBox.setSelectedIndex(coffeeList.length-1);
		coffeeListBox.setBounds(80, 100, 500, 30);
		coffeeListBox.addActionListener(this);
		add(coffeeListBox);
		
		
		//=============================================
		//사이즈 라디오버튼 
        size1 = new JRadioButton("Short");
        size2 = new JRadioButton("Tall");
        size3 = new JRadioButton("Grande");        
 
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(size1);
        sizeGroup.add(size2);
        sizeGroup.add(size3);
        
        size1.setBounds(100,200,100,30);
        size2.setBounds(100,220,100,30);
        size3.setBounds(100,240,100,30);
        size1.addActionListener(this);
        size2.addActionListener(this);
        size3.addActionListener(this);
        
        //=================================================
		//시럽 라디오버튼
        syrupOption1 = new JRadioButton("바닐라");
        syrupOption2 = new JRadioButton("카라멜");
        syrupOption3 = new JRadioButton("헤이즐럿");        
 
        ButtonGroup SyrupGroup = new ButtonGroup();
        SyrupGroup.add(syrupOption1);
        SyrupGroup.add(syrupOption2);
        SyrupGroup.add(syrupOption3);
        
        syrupOption1.setBounds(250,200,100,30);
        syrupOption2.setBounds(250,220,100,30);
        syrupOption3.setBounds(250,240,100,30);
        syrupOption1.addActionListener(this);
        syrupOption2.addActionListener(this);
        syrupOption3.addActionListener(this);
        

        add(size1);
        add(size2);
        add(size3);
        add(syrupOption1);
        add(syrupOption2);
        add(syrupOption3);

		//================================================
        //OtherSelect 기타
        othersTitle=new JLabel(" 기타 ");  
        othersTitle.setBounds(400,180,300,20);
        
        addShot=new JCheckBox("샷추가");  
        addShot.setBounds(400,200,100,30);  
        addWhiping=new JCheckBox("휘핑크림");  
        addWhiping.setBounds(400,240,150,20);  
        
        add(othersTitle);add(addShot);add(addWhiping);  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
        //================================================
		
		
		JLabel ageLabel = new JLabel("주문수량 : ");
		ageLabel.setBounds(31, 300, 67, 15);
		add(ageLabel);
		
		orderCountTextF = new JTextField();
		orderCountTextF.setBounds(100, 300, 150, 20);
		add(orderCountTextF);
		
		
		finalOrder = new JButton(" 주문하기 ");
		finalOrder.addActionListener(this);
		finalOrder.setBounds(500, 10, 150, 50);
		add(finalOrder);
		

		getContentPane().setBackground(new Color(0, 255, 0));
		setBounds(100, 100, 700, 500);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = null;
		JComboBox<String> jcbox = null;
		JRadioButton rBtn = null;
		 Object source = e.getSource();
		 if (source instanceof JButton) {
			 btn = (JButton)e.getSource();
			 } else if (source instanceof JComboBox) {
				 jcbox = (JComboBox<String>)e.getSource();
		    } else if(source instanceof JRadioButton) {
		    	rBtn = (JRadioButton)e.getSource();
		    }
		
		
		
		
		
		
		//커피선택
		if(jcbox == coffeeListBox) {
			System.out.println("선택된 커피  : " + coffeeListBox.getSelectedItem());
		}
		
		
		//사이즈 선택
		if(size1.isSelected()){    
//			JOptionPane.showMessageDialog(this,"You are Male.");    
			System.out.println("size_short = " + size1.getLabel());
		}else if(size2.isSelected()){    
//			JOptionPane.showMessageDialog(this,"You are Male.");    
			System.out.println("size_short = " + size2.getLabel());
		}else if(size3.isSelected()){    
//			JOptionPane.showMessageDialog(this,"You are Male.");    
			System.out.println("size_short = " + size3.getLabel());
		}
		
		//시럽선택
		if(syrupOption1.isSelected()){    
			System.out.println("select_syrup = " + syrupOption1.getLabel());    
		}else if(syrupOption2.isSelected()){    
			System.out.println("select_syrup = " + syrupOption2.getLabel());    
		}else if(syrupOption3.isSelected()){    
			System.out.println("select_syrup = " + syrupOption3.getLabel());
		}
		
		//기타선택
		if(addShot.isSelected()) {
			System.out.println("addShot 체크박스 선택됨. " + addShot.getLabel());
		}
		if(addWhiping.isSelected()) {
			System.out.println("addWhiping 체크박스 선택됨. " +addWhiping.getLabel());
		}
		
		System.out.println("입력된 수량출력 " + orderCountTextF.getText());
		
		
//		Singleton s = Singleton.getInstance();
//		if(btn == AddOrder) {
//			System.out.println("주문추가하기 버튼 =  " + AddOrder.getText());
//			
//		}
//		
	}


// ITEM LISTENER
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseClicked(MouseEvent e) {

		
	}




	@Override
	public void mousePressed(MouseEvent e) {

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
