package DAO;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import SingleTon.Singleton;

public class Insert extends Frame implements WindowListener, ItemListener {

	Button MainMenu, dataInsert;
	Checkbox selectPitcher, selectBatter;
//	Panel basePanel, pitcherPanel, batterPanel;
	Panel basePanel, pitcherPanel,typeSelectPanel, batterPanel, bottomPanel;

	// 레이블 생성
	Label lbl1 = new Label(" ID :");
	Label lbl2 = new Label(" NAME :");
	Label lbl3 = new Label(" AGE :");
	Label lbl4 = new Label(" HEIGHT :");

	Label lbl5 = new Label(" WIN :");
	Label lbl6 = new Label(" LOSE :");
	Label lbl7 = new Label(" DEFENCE :");

	/*Label lbl8 = new Label(" A :");
	Label lbl9 = new Label(" B :");
	Label lbl10 = new Label(" C :");*/

	TextField txt5 = new TextField("win",20 );
	TextField txt6 = new TextField("lose",20 );
	TextField txt7 = new TextField("defence",20 );

	/*TextField txt8 = new TextField("타수", 20);
	TextField txt9 = new TextField("안타수", 20);
	TextField txt10 = new TextField("타율", 20);*/

	public Insert() {
		super("INSERT 입니다. ");
		//setLayout(new GridLayout(6,1));

		MainMenu = new Button(" MainMenu ");
		MainMenu.setBounds(100, 200, 100, 30);
		MainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.main.setVisible(true);
				s.insert.setVisible(false);
				s.showAll.setVisible(false);
				s.delete.setVisible(false);
				s.sort.setVisible(false);

			}
		});
		

		dataInsert = new Button(" dataInsert ");
		dataInsert.setBounds(100, 300, 100, 30);
		dataInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				System.out.println("datainsertButton");

			}
		});

		CheckboxGroup selectTypeGroup = new CheckboxGroup();
		selectPitcher = new Checkbox("Pitcher",selectTypeGroup,true );
		selectBatter = new Checkbox("Batter", selectTypeGroup, false);
		
		
		
		
		
		
		

		
        // 레이블 생성
       /* Label lbl1 = new Label(" ID :");
        Label lbl2 = new Label(" NAME :");
        Label lbl3 = new Label(" AGE :");
		Label lbl4 = new Label(" HEIGHT :");
		
        Label lbl5 = new Label(" WIN :");
        Label lbl6 = new Label(" LOSE :");
		Label lbl7 = new Label(" DEFENCE :");
		
        Label lbl8 = new Label(" A :");
        Label lbl9 = new Label(" B :");
        Label lbl10 = new Label(" C :");*/
        
        

        TextField txt1 = new TextField("ID", 20 );
        TextField txt2 = new TextField("name",20 );
        TextField txt3 = new TextField("age",20 );
        TextField txt4 = new TextField("height",20 );
        
        /*TextField txt5 = new TextField("win",20 );
        TextField txt6 = new TextField("lose",20 );
        TextField txt7 = new TextField("defence",20 );
        
        TextField txt8 = new TextField("타수", 20);
        TextField txt9 = new TextField("안타수", 20);
        TextField txt10 = new TextField("타율", 20);*/
        
        
		basePanel = new Panel(new GridLayout(4,1));
		pitcherPanel = new Panel(new GridLayout(3,1));
		typeSelectPanel = new Panel(new GridLayout(1,2));
		bottomPanel = new Panel(new GridLayout(1,2));

		basePanel.add(lbl1);
		basePanel.add(txt1);
		basePanel.add(lbl2);
		basePanel.add(txt2);
		basePanel.add(lbl3);
		basePanel.add(txt3);
		basePanel.add(lbl4);
		basePanel.add(txt4);
		
		typeSelectPanel.add(selectPitcher);
		typeSelectPanel.add(selectBatter);

		pitcherPanel.add(lbl5);
		pitcherPanel.add(txt5);
		pitcherPanel.add(lbl6);
		pitcherPanel.add(txt6);
		pitcherPanel.add(lbl7);
		pitcherPanel.add(txt7);

		//5,6,7은 핏처
		//8,9,10은 타자.

        // 패널 생성

		
        bottomPanel.add(MainMenu);
        bottomPanel.add(dataInsert);
        
		add(basePanel);
		add(typeSelectPanel);
		add(pitcherPanel);
		add(bottomPanel);
	
		setLayout(new FlowLayout());
		setSize(400, 450);
		setBounds(0,0,400, 450);
		setResizable(false);
		setLocation(0, 0);
		setBackground(Color.gray);
		setVisible(false);// 싱글톤 제어를위해서 비지블 false로전환
		addWindowListener(this);
		selectPitcher.addItemListener(this);
		selectBatter.addItemListener(this);
		


	}
	
	////
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		Checkbox cb = (Checkbox)obj;
		
		System.out.println("cb = "+cb);
		
		
		
		if(cb ==selectPitcher) {
			
//			JOptionPane.showMessageDialog(null, "pitcher ");

			//pitcherPanel.setVisible(true);
			//batterPanel.setVisible(false);
			lbl5.setText("WIN");
			lbl6.setText("LOSE");
			lbl7.setText("DEFENCE");
			txt5.setText("WIN");
			txt6.setText("LOSE");
			txt7.setText("DEFENCE");
			
		}else if(cb == selectBatter) {
//			JOptionPane.showMessageDialog(null, "Batter ");
			//pitcherPanel.setVisible(false);
			//batterPanel.setVisible(true);

			lbl5.setText("A");
			lbl6.setText("B");
			lbl7.setText("C");
			txt5.setText("타수");
			txt6.setText("안타율");
			txt7.setText("타율");
		}
		
		
		
		
	}
	
////
	@Override
	public void windowOpened(WindowEvent e) {
//		batterPanel.setVisible(false);
//		java.awt.Checkbox
//		Object obj = e.getSource();
//		Checkbox cb = (Checkbox)obj;
//		System.out.println("checkbox status = "+cb.getCheckboxGroup().getSelectedCheckbox());
//		

		
		

	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {


	}

	@Override
	public void windowActivated(WindowEvent e) {


	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
