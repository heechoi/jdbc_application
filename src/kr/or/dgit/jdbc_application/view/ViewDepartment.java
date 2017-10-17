package kr.or.dgit.jdbc_application.view;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.DepartmentService;

public class ViewDepartment extends AbstractView{
	private DepartmentService service;
	private AbstractList pList;
	//private JPanel contentPane;
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
	//private DepartmentContent pContent;
	
	public ViewDepartment(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
		//DepartmentService ds = new DepartmentService();
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();
	}

	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department)content);
		
	}

	@Override
	protected void deleteContent(Object item) {
		service.deleteDepartment((Department)item);
		
	}

	@Override
	protected void updateContent(Object content) {
	
		service.updateDepartment((Department)content);
		
	}

	@Override
	protected Object searchNo(int No) {
		return service.selectDepartmentByNo(new Department(No));
	}



}
