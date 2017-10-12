package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.ComboBoxComponent;
import kr.or.dgit.jdbc_application.common.SpinnerComponent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings("serial")
public class EmployeeComponent extends JPanel {

	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboBoxComponent<Title> pTitle;
	private SpinnerComponent pSalary;
	private ComboBoxComponent<Department> pDno;
	private ComboBoxComponent<Employee> pManager;

	public EmployeeComponent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원명");
		add(pEmpName);
		
		pTitle = new ComboBoxComponent<>("직책");
		add(pTitle);
		
		pManager = new ComboBoxComponent<>("관리자");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		add(pSalary);
		
		pDno = new ComboBoxComponent<>("부서");
		add(pDno);
		
		setDeptModel();
		setTitleMOdel();
		setManagerModel();
	}
	private void setManagerModel() {
		Vector<Employee> lists = new Vector<>();
		lists.add(new Employee(2, "서현진",new Title(1, "사장"),new Employee(1), 2000000, new Department(1)));
		lists.add(new Employee(1));
		//lists.add(new Employee(1));
		pManager.setComboBoxModel(lists);				
	}
	
	private void setTitleMOdel() {
		Vector<Title> lists = new Vector<>();
		lists.add(new Title(1, "사장"));
		lists.add(new Title(2, "대리"));
		lists.add(new Title(3, "사원"));
		pTitle.setComboBoxModel(lists);		
	}
	public void setDeptModel(){
		Vector<Department> lists = new Vector<>();
		lists.add(new Department(1, "개발", 10));
		lists.add(new Department(2, "연구", 9));
		lists.add(new Department(3, "영업", 13));
		pDno.setComboBoxModel(lists);
	}
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = new Employee(empNo);
		int salary = pSalary.getSpinValue();
		Department dno = pDno.getSelectedItem();
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pDno.setSelectedItem(employee.getDno());
		pManager.setSelectedItem(employee.getManager());
		pSalary.setSpinValue(employee.getSalary());
		pTitle.setSelectedItem(employee.getTitle());
	}
	
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}
}
