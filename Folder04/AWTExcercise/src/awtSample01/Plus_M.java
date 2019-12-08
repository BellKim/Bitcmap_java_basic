package awtSample01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Plus_M extends JFrame {// , ActionListener{

	TextField textfield;
	JTextArea textArea;
	int num = 0;
	JButton btn1, btn2, btn3;

	public Plus_M() {
		super(" 업,다운카운트 에제. ");
		JPanel panel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel PlusMinusPan = new JPanel();

		centerPanel.setLayout(new GridLayout(2, 1));
//		textArea = new JTextArea();
//		textArea.setLineWrap(true);

//		JScrollPane scrPane = new JScrollPane(textArea);

		textfield = new TextField();
		textfield.setPreferredSize(new Dimension(100, 50));
		textfield.setText(String.valueOf(num)); // Integer.toString(num)
		panel.add(textfield);

		btn1 = new JButton(" ( + ) ");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Plus");
//				String msg = textfield.getText() + "\n";
//				textArea.append(msg);
				num += 1;
				textfield.setText(String.valueOf(num));
			}
		});

		btn2 = new JButton(" ( - ) ");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Negative");
//				String msg = textfield.getText() + "\n";
//				textArea.append(msg);
				num -= 1;
				textfield.setText(String.valueOf(num));
			}
		});

		PlusMinusPan.add(btn1);
		PlusMinusPan.add(btn2);

		btn3 = new JButton(" ( R E S E T ) ");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "R E S E T");
				num = 0;
				textfield.setText(String.valueOf(num));

			}
		});
		centerPanel.add(PlusMinusPan);
		centerPanel.add(btn3);

		// layout

		Container contentPane = getContentPane();

		contentPane.add(textfield, BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);

//		contentPane.add(btn3, BorderLayout.SOUTH);

		setSize(200, 200); // 윈도우의 크기( 폭, 높이)
		setLocation(10, 10); // 창이 실행되는 위치.
		setVisible(true); // 윈도우의 시각화여부

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// end class

	public static void main(String[] args) {
		new Plus_M();

	}

}// end class
