package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;

public class DepartmentContent extends AbstractContent<Department> {

	private TextFieldComponent pDeptNo;
	private TextFieldComponent pDeptName;
	private TextFieldComponent pFloor;

	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pDeptNo = new TextFieldComponent("부서번호");
		add(pDeptNo);
		
		pDeptName = new TextFieldComponent("부서명");
		add(pDeptName);
		
		//design에서 jpanel 우클릭 - morph-subclass-textfieldcomponent class를 해주면 자동 생성
		
		pFloor = new TextFieldComponent("위치");
		add(pFloor);
		
	}
	@Override
	public Department getContent(){
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		
		return new Department(deptNo, deptName, floor);
	}
	@Override
	public void setContent(Department department){
		//Department department = (Department)obj;
		pDeptNo.setTextValue(department.getDeptNo()+"");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor()+"");
	}
	@Override
	public void isEmptyCheck() throws Exception{
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}
	@Override
	public void clear() {
		pDeptNo.setTextValue("");
		pDeptName.setTextValue("");
		pFloor.setTextValue("");
	}
	@Override
	public void showContent(Object content) {
		pDeptNo.setEnable(false);
		setContent((Department)content);
	}

}
