package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.dto.Department;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	protected AbstractContent<?> pContent;
	//protected AbstractContent pContent;
	protected AbstractList pList;
	private JButton btnOk;
	
	public AbstractView(String title) {
		createService();
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		//DepartmentContent의 부모인 JPanel로 변경
		//JPanel pContent = createContent();
		pContent = createContent(); //필드로
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		pBtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		//DepartmentList의 부모로 변경 AbstractList로 
		 pList = createList();
		 pList.setPopupMenu(createPopupMenu());
		contentPane.add(pList, BorderLayout.CENTER);
	}
	private JPopupMenu createPopupMenu(){
		JPopupMenu popUpMenu = new JPopupMenu();
		JMenuItem delItem = new JMenuItem("삭제");
		JMenuItem updateItem = new JMenuItem("수정");
		JMenuItem searchItem = new JMenuItem("검색");
		
		delItem.addActionListener(this);
		updateItem.addActionListener(this);
		searchItem.addActionListener(this);
		
		popUpMenu.add(delItem);
		popUpMenu.add(updateItem);
		popUpMenu.add(searchItem);
		
		return popUpMenu;
	}
	
	protected abstract void createService();//service가 각각 다르기 때문에 추상화로
		
	protected abstract AbstractList createList();

	//protected abstract JPanel createContent();
	protected abstract AbstractContent<?> createContent();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			if(e.getActionCommand().equals("추가")){
				btnOkActionPerformed(e);
			}
			if(e.getActionCommand().equals("수정")){
				//pContent에서 입력된 내용 가져옴
				//입력된 DTo를 service를 이용해서 db에 업데이트
				updateContent(pContent.getContent());
				
				//load
				pList.loadData();
				//clear
				//pContent.clear();
				//btn 수정->추가로
				//btnOk.setText("추가");
			}
			if(e.getActionCommand().equals("확인")){
				//pcontent의 내용을 clear
				//pContent.clear();
				//pContent의 내용을 setEnable();
				//setEnable(true);
				//btn 확인->추가
				//btnOk.setText("추가");
			}
			pContent.clear();
			btnOk.setText("추가");
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if(e.getActionCommand().equals("삭제")){
			//리스트에서 선택되 item을 가져와서
			
			//service에서 delete호출
			deleteContent(pList.getSelectItem());
			pList.loadData();
		}
		if(e.getActionCommand().equals("수정")){
			//리스트에서 선택되 content을 가져와서
			//가져온 content pContent에 setContent()호출
			//pContent.setContent(pList.getSelectItem());
			pContent.showContent(pList.getSelectItem());
			//버튼의 글자를 "추가" 에서 "수정"으로 
			btnOk.setText("수정");
		}
		if(e.getActionCommand().equals("검색")){
			//다일로그 상자를 띄워서 사원번호, 부서번호, 직책번호를 가져와서 
			int No =Integer.parseInt(JOptionPane.showInputDialog("번호를 입력하세요"));
			Object item = searchNo(No);
			pContent.showContent(item);
			//해당하는 번호로 service에서 검색한 content를 가져옴
			
			//pContent.setContent(searchContent(item));
			//검색된 content를 pContent.setContent()를 호출
			//pContent setEnable(false)
			//btn을 확인으로 바꿈
			btnOk.setText("확인");
		}
	}
	
	
	
	protected  void btnCancelActionPerformed(ActionEvent e){
		pContent.clear();
		btnOk.setText("추가");
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		//공백확인
		try {
			pContent.isEmptyCheck();
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			//e1.printStackTrace();
			return;
		}
		//pContent에서 입력된 내용(DTO)을 가져옴
		Object content = pContent.getContent();
		//JOptionPane.showMessageDialog(null, content);
		
		
		//입렬된 DTO를 service를 이용해서 DB에 insert
		insertContent(content);
		//Plist에서 목룍을 새로 load
		pList.loadData();
		pContent.clear();
	
	}

	protected abstract void insertContent(Object content);
		
	protected abstract void deleteContent(Object item);
	
	protected abstract void updateContent(Object content);
	
	protected abstract Object searchNo(int No);
	
}
