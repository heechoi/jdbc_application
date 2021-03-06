package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class ViewEmployee extends AbstractView {
	private EmployeeService service;
//	private JPanel contentPane;
//부모에서 생성해주니까 필요없음
/*	public ViewDepartment() {
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		//DepartmentContent의 부모인 JPanel로 변경
		JPanel pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("추가");
		pBtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		pBtn.add(btnCancel);
		
		//DepartmentList의 부모로 변경
		AbstractList pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}*/
	
	
	public ViewEmployee(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
	
		pList = new ListEmployee(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(service);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		service = new EmployeeService();
		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertEmployee((Employee)content);
		
	}

	@Override
	protected void deleteContent(Object item) {
		service.deleteEmployee((Employee)item);
	}

	@Override
	protected void updateContent(Object content) {
		service.updateEmployee((Employee)content);
		
	}

	@Override
	protected Object searchNo(int No) {
		return service.selectEmployeeByNo(new Employee(No));
	}

}
