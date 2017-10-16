package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.service.DepartmentService;

public class ListDepartment extends AbstractList {
	
	private DepartmentService service;
	
	public ListDepartment(DepartmentService service) {
		//super();생략
		this.service = service;
	}

	/*
	 * private JTable table; //공통의 것들을 추상화 클래스로 바꿈
	 * 
	 * public ListDepartment() { setLayout(new BorderLayout(0, 0));
	 * 
	 * JScrollPane scrollPane = new JScrollPane(); add(scrollPane,
	 * BorderLayout.CENTER);
	 * 
	 * table = new JTable(); scrollPane.setViewportView(table);
	 * 
	 * loadData(); }
	 * 
	 * private void loadData() { DefaultTableModel model = new
	 * DefaultTableModel(getData(), getColumnNames()); table.setModel(model);
	 * setAlignWidth();
	 * 
	 * setWidth(100,150,50); //셀의 폭을 조절 setAlign(SwingConstants.CENTER,0,2);
	 * //table이 바뀔때 마다 새롭게 호출하게 해주어야한다. 정렬을 할려면 새로 불러서 보여줘야한다.
	 * setAlign(SwingConstants.RIGHT, 1); }
	 */
	@Override
	protected void setAlignWidth() {
		setCellWidth(100, 150, 50); // 셀의 폭을 조절
		setAlign(SwingConstants.CENTER, 0, 2); // table이 바뀔때 마다 새롭게 호출하게 해주어야한다.
												// 정렬을 할려면 새로 불러서 보여줘야한다.
		setAlign(SwingConstants.RIGHT, 1);
	}

	/*
	 * private void setWidth(int...width){ TableColumnModel cModel =
	 * table.getColumnModel(); for(int i=0;i<width.length;i++){
	 * cModel.getColumn(i).setPreferredWidth(width[i]); }
	 * cModel.getColumn(0).setPreferredWidth(100); //비율로 적절히 맞춰서 width가 나타난다.
	 * cModel.getColumn(1).setPreferredWidth(150);
	 * cModel.getColumn(2).setPreferredWidth(50); } private void setAlign(int
	 * align,int...idx) { //0번 컬림을 정렬(Letf,Right,Center)
	 * DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); //컬럼에
	 * 해당하는 셀을 정렬하겠다. 컬럼끼리 같은 정렬을 해야한다. row는 따로 불가능
	 * dtcr.setHorizontalAlignment(align); //하나의 셀을 가운데 정렬을 하겠다.
	 * 
	 * TableColumnModel cModel = table.getColumnModel(); //department에서는 3개가
	 * 존재한다.(부서번호, 부서명, 위치)
	 * 
	 * //idx=[0,2] //int...idx가변인수 for(int i=0;i<idx.length;i++){
	 * //0[0]~0[2],2[0]~2[2] cModel.getColumn(idx[i]).setCellRenderer(dtcr);
	 * //부서번호를 모두 가운데 정렬하겠다.0~2까지 3개 존재 }
	 * 
	 * 
	 * }
	 */ @Override
	protected String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "위치" };
	}

	@Override
	protected Object[][] getData() {
		List<Department> lists = service.selectDepartmentByAll();
		//Object[][] datas = { { 1, "개발", 10 }, { 2, "인사", 20 }, { 3, "마케팅", 30 } };
		Object[][] datas = new Object[lists.size()][];
		for(int i = 0 ; i<lists.size();i++){
			datas[i]  = lists.get(i).toArray();
		}
			
		
		return datas;
	}

	@Override
	public Object getSelectItem() {
		int selectedIndex = table.getSelectedRow();
		
		//System.out.println(table.getSelectedRow()); //row를 선택했을때 test해본것  row는 0부터 시작한다. 
		
		int deptNo = (int) table.getValueAt(selectedIndex, 0);
	/*	String deptName = (String) table.getValueAt(selectedIndex, 1);
		int floor = (int) table.getValueAt(selectedIndex, 2);
		
		return new Department(deptNo, deptName, floor);*/
		
		return service.selectDepartmentByNo(new Department(deptNo));
	}

}
