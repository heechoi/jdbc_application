package kr.or.dgit.jdbc_application.dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title title; //join이 필요한 것, 그냥 int를 해도 되나 그러면 query문을 따로 생성해주어야한다.
	private Employee manager;
	private int salary;
	private Department dno;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dno) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dno = dno;
	}
	

	public Employee(int empNo) {
		this.empNo = empNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s]", empNo, empName,
				title.getTitleName(), manager.getEmpName(), salary, dno.getDeptName());
	}
	
	
}
