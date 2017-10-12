package kr.or.dgit.jdbc_application.common;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ComboBoxComponent<T> extends JPanel {

	private JComboBox<T> comboBox;

	public ComboBoxComponent(String title) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblCombo = new JLabel(title);
		lblCombo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCombo);
		
		comboBox = new JComboBox<>();
		add(comboBox);

	}
	
	public int getSelectedIndex(){
		return comboBox.getSelectedIndex();
	}
	

	@SuppressWarnings("unchecked")
	public T getSelectedItem(){
		return (T)comboBox.getSelectedItem();
	}
	
	public void setSelectedIndex(int index){
		comboBox.setSelectedIndex(index);
	}
	
	public void setSelectedItem(T item){
		comboBox.setSelectedItem(item);
	}

	public void setComboBoxModel(Vector<T> lists){
		ComboBoxModel<T> model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(model);
	}
	
	public JComboBox<T> getCombo() {
		return comboBox;
	}
	
	public void isEmptyCheck() throws Exception{
		if (comboBox.getSelectedIndex()==-1){
			comboBox.requestFocus();
			throw new Exception("선택 하지 않음");
		}
	}

	public void setEnable(boolean isEnable) {
		comboBox.setEnabled(isEnable);		
	}
	

}
