package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dto.Department;

public class DepartmentService {
	private SqlDao<Department> deptDao;

	public DepartmentService() {
		deptDao =  DepartmentDao.getInstance();
	}
	
	public void insertDepartment(Department dept){
		try {
			deptDao.insertItem(dept);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public void deleteDepartment(Department dept){
		try {
			deptDao.deleteItem(dept);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public Department selectDepartmentByNo(Department dept){
		try {
			return  deptDao.selectItemByNo(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Department> selectDepartmentByAll(){
		try {
			return deptDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateDepartment(Department dept){
		try {
			deptDao.updateItem(dept);
			showMessage("갱신 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}	
	}
	
}
