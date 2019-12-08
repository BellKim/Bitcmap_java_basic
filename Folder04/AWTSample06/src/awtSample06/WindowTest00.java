package awtSample06;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest00 extends JFrame{//, ActionListener{
	
	JTextField textField;
	JTextArea textArea;
	
	JButton btn1, btn2; 

	
	public WindowTest00() {
		super("간단한 예제");
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JScrollPane scrPane = new JScrollPane(textArea);
		scrPane.setPreferredSize(new Dimension(400, 300));
		
		panel.add(scrPane);
		
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);
		
		btn1 = new JButton(" next insert ");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "next insert ");
				if(!textField.getText().equals("")) {
					String msg = textField.getText() + "\n";
					textArea.append(msg);
				}
				
			}
		});
		
		btn2 = new JButton("prev insert ");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "prev insert ");
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "문장을 작성해 주세요. ");
					return;
				}
				
				try {
					textArea.insert(textField.getText() + "\n", textArea.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//getLineStartOffset = 몇번째 라인에 넣을것이냐
				
				
			}
		});
		
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		
		//layout
		
		Container contentPane = getContentPane();
		contentPane .add(panel, BorderLayout.CENTER);
		contentPane .add(botpan, BorderLayout.SOUTH);
		
		
		setSize(640, 480);	//윈도우의 크기( 폭, 높이)
		setLocation(10, 10);	//창이 실행되는 위치.
		setVisible(true);	//윈도우의 시각화여부
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
	}//end class

	
public static void main(String[] args) {
	new WindowTest00();
}


}//end class
