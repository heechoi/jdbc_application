package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class EmployeeService {
	
	private SqlDao<Employee> empDao;
	private SqlDao<Department> deptDao;
	private SqlDao<Title> titleDao;
	

	public EmployeeService() {
		empDao = EmployeeDao.getInstance();
		this.deptDao = DepartmentDao.getInstance();
		this.titleDao = TitleDao.getInstance();
	}
	
	public void insertEmployee(Employee emp){
		try {
			empDao.insertItem(emp);
			showMessage("추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(Employee emp){
		try {
			empDao.deleteItem(emp);
			showMessage("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(Employee emp){
		try {
			empDao.updateItem(emp);
			showMessage("갱신 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	public Employee selectEmployeeByNo(Employee emp){
		try {
			return empDao.selectItemByNo(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectEmployeeByAll(){
		try {
			return empDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Title> selectTitleByAll() {
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Title selectTitleByNo(Title item){
		try {
			return titleDao.selectItemByNo(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Department> selectDepartmentByAll() {
		try {
			return deptDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Department selectDepartmentByNo(Department item){
		try {
			return deptDao.selectItemByNo(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectEmployeeByDno(Department dept){
		try {
			return empDao.selectItemByDno(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
