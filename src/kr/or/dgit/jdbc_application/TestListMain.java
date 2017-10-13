package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;

public class TestListMain {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10,10,300,450);
		
		
		//AbstractList ld = new ListDepartment();
		//AbstractList ld = new ListTitle();
		
		AbstractList ld = new ListEmployee();
		
		//ld.getSelectItem()
		jf.add(ld);
		
		JButton btn = new JButton("test");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = ld.getSelectItem();
				JOptionPane.showMessageDialog(null, obj); //toString이 호출되어서 출력
				
			}
		});
		jf.add(btn,BorderLayout.SOUTH);
		jf.setVisible(true);
	}

}
