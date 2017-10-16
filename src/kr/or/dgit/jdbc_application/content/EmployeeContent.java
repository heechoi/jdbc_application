package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.ComboBoxComponent;
import kr.or.dgit.jdbc_application.common.SpinnerComponent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class EmployeeContent extends JPanel implements ActionListener{

	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboBoxComponent<Title> pTitle;
	private SpinnerComponent pSalary;
	private ComboBoxComponent<Department> pDno;
	private ComboBoxComponent<Employee> pManager;
	private EmployeeService service;
	
	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		
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
		pDno.getCombo().addActionListener(this);
		add(pDno);
		
		setDeptModel();
		setTitleMOdel();
		setManagerModel();
	}
	
/*	private void setManagerByDno(EmployeeService service) {
		Department dept = pDno.getSelectedItem();
		Employee ceo = new Employee(4377);
		
		List<Employee> lists = service.selectEmployeeByDno(dept);
		if (!lists.contains(ceo)){
			lists.add(service.selectEmployeeByNo(new Employee(4377)));
		}
		Vector<Employee> manager = new Vector<>(lists);
		pManager.setComboBoxModel(manager);
	}

	private void setManagerModel() {
		List<Employee> lists = service.selectEmployeeByAll();
		Vector<Employee> manager = new Vector<>(lists);
		pManager.setComboBoxModel(manager);	
	}*/
	private void setManagerModel() {
		List<Employee> lists = service.selectEmployeeByDno(pDno.getSelectedItem());
		Employee ceo = new Employee(4377);
		if(!lists.contains(ceo)){
			lists.add(service.selectEmployeeByNo(new Employee(4377)));
		}
			
		
		Vector<Employee> managers = new Vector<>(lists);
	/*	Vector<Employee> lists = new Vector<>();
		lists.add(new Employee(2, "서현진",new Title(1, "사장"),new Employee(1), 2000000, new Department(1)));
		lists.add(new Employee(1));
		//lists.add(new Employee(1));
*/		pManager.setComboBoxModel(managers);				
	}
	
	private void setTitleMOdel() {
		//Vector<Title> lists = new Vector<>();
		List<Title> lists = service.selectTitleByAll();
		Vector<Title> titles = new Vector<>(lists);
		
		pTitle.setComboBoxModel(titles);		
	}
	public void setDeptModel(){
		List<Department> lists = service.selectDepartmentByAll();
		Vector<Department> depts = new Vector<>(lists);
	/*	lists.add(new Department(1, "개발", 10));
		lists.add(new Department(2, "연구", 9));
		lists.add(new Department(3, "영업", 13));*/
		pDno.setComboBoxModel(depts);
	}
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pDno.getCombo()) {
			setManagerModel();
		}
	}
	
}
