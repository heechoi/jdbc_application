package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

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
	private ComboBoxComponent pTitle;
	private SpinnerComponent pSalary;
	private ComboBoxComponent pDno;
	private ComboBoxComponent pManager;

	public EmployeeComponent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원명");
		add(pEmpName);
		
		pTitle = new ComboBoxComponent("직책");
		add(pTitle);
		
		pManager = new ComboBoxComponent("관리자");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		add(pSalary);
		
		pDno = new ComboBoxComponent("부서");
		add(pDno);
		
	}
	
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = new Title(Integer.parseInt(pTitle.getComboValue()));
		Employee manager = new Employee(Integer.parseInt(pManager.getComboValue()));
		int salary =  pSalary.getSpinnerValue();
		Department dno =  new Department(Integer.parseInt(pDno.getComboValue()));
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName()+"");
		pTitle.setComboValue(employee.getManager()+"");
		pManager.setComboValue(employee.getManager()+"");
		pSalary.setSpinnerValue(employee.getSalary());
		pDno.setComboValue(employee.getDno()+"");
		
	}
	public void isEmptyCheck() throws Exception{
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
	}
}
