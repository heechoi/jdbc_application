package kr.or.dgit.jdbc_application.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SpinnerComponent extends JPanel {

	private JSpinner spSalary;

	public SpinnerComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblSalary = new JLabel(title);
		add(lblSalary);
		
		spSalary = new JSpinner();
		spSalary.setModel(new SpinnerNumberModel(1500000, 1500000, 5000000, 100000));
		add(spSalary);

	}
	
	public int getSpinnerValue(){
		return (int) spSalary.getValue();
	}
	
	public void setSpinnerValue(int value){
		spSalary.setValue(value);
	}
	
	public void isEmptyCheck() throws Exception {
		if(getSpinnerValue()==0){
			spSalary.requestFocus();
			throw new Exception("공백 존재");
		}
	}
}
