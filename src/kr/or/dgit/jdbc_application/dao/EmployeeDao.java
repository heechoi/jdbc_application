package kr.or.dgit.jdbc_application.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Employee;

public class EmployeeDao implements SqlDao<Employee> {

	@Override
	public void insertItem(Employee item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Employee item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Employee item) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee selectItemByNo(Employee item) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectItemByAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
