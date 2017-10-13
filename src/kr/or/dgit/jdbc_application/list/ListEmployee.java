package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class ListEmployee extends AbstractList {

	@Override
	protected void setAlignWidth() {
		setCellWidth(100,100,100,150,150,100);
		setAlign(SwingConstants.CENTER, 0,1,2,3,5);
		setAlign(SwingConstants.RIGHT, 4);

	}

	@Override
	protected String[] getColumnNames() {
		return	new String[]{"사원번호","사원명","직책","관리자","급여","부서"};
	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {
				{1,"이성래","과장","홍길동",3000000,"기획"},
				{1,"이성래","과장","홍길동",3000000,"기획"},
				{1,"이성래","과장","홍길동",3000000,"기획"},
		};
		return data;
	}

	@Override
	public Object getSelectItem() {
		int selectIndex = table.getSelectedRow();
		
		int empNo = (int) table.getValueAt(selectIndex, 0);
		String empName = (String) table.getValueAt(selectIndex, 1);
		Title title =  new Title((String)table.getValueAt(selectIndex, 2));
		Employee manager = new Employee((String)table.getValueAt(selectIndex, 3));
		int salary = (int) table.getValueAt(selectIndex, 4);
		Department dno = new Department((String)table.getValueAt(selectIndex, 5));
		//return null;
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}
