package kr.or.dgit.jdbc_application.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SpinnerComponent extends JPanel {

	private JSpinner spSalary;

	public SpinnerComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblSalary = new JLabel(title);
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSalary);
		
		spSalary = new JSpinner();
		spSalary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		add(spSalary);

	}
	public JSpinner getComponent() {
		return spSalary;
	}

	public void isEmptyCheck() throws Exception {
		if (spSalary.getValue().toString().equals("")) {
			spSalary.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public void setSpinValue(int value){
		spSalary.setValue(value);
	}
	
	public int getSpinValue(){
		Number n = (Number) spSalary.getValue();
		return  n.intValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize){
		SpinnerModel model = new SpinnerNumberModel(value, minimum, maximum, stepSize);
		spSalary.setModel(model);
	}

	public void setEnable(boolean isEnable) {
		spSalary.setEnabled(isEnable);		
	}
}
