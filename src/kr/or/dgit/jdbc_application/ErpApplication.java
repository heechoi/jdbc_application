package kr.or.dgit.jdbc_application;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.view.AbstractView;
import kr.or.dgit.jdbc_application.view.ViewDepartment;
import kr.or.dgit.jdbc_application.view.ViewEmployee;
import kr.or.dgit.jdbc_application.view.ViewTitle;

public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDepartment;
	private JButton btnTitle;
	private JButton btnEmployee;

	private AbstractView deptFr;
	private AbstractView titleFr;
	private AbstractView empFr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErpApplication() {
		setTitle("회사 ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 101);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);

		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);

		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
	}

	protected void btnDepartmentActionPerformed(ActionEvent e) {
		if (deptFr == null){
			deptFr = new ViewDepartment("부서관리");
		}
		deptFr.setVisible(true);
	}

	protected void btnTitleActionPerformed(ActionEvent e) {
		if (titleFr == null){
			titleFr = new ViewTitle("직책관리");
		}
		titleFr.setVisible(true);
	}

	protected void btnEmployeeActionPerformed(ActionEvent e) {
		if (empFr == null){
			empFr = new ViewEmployee("사원관리");
		}
		empFr.setVisible(true);
	}
}

