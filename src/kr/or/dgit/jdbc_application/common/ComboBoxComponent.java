package kr.or.dgit.jdbc_application.common;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboBoxComponent extends JPanel {

	private JComboBox<String> comboBox;

	public ComboBoxComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblCombo = new JLabel(title);
		lblCombo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCombo);
		
		comboBox = new JComboBox<>();
		add(comboBox);

	}
	
	public String getComboValue(){
		return (String) comboBox.getSelectedItem();
	}
	
	public void setComboValue(String value){
		comboBox.setSelectedItem(value);
	}
	

}
