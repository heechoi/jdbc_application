package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;

public class ViewTitle extends AbstractView {

	private JPanel contentPane;
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
	
	public ViewTitle(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle();
		return pList;
	}

	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}
