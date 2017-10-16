package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class EmployeeDao implements SqlDao<Employee> {
	private static final EmployeeDao instance = new EmployeeDao();
	
	
	public static EmployeeDao getInstance() {
		return instance;
	}

	private EmployeeDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertItem(Employee item) throws SQLException {
		String sql = "insert into employee values(?,?,?,?,?,?)";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.setString(2, item.getEmpName());
			pstmt.setInt(3, item.getTitle().getTitleNo());
			pstmt.setInt(4, item.getManager().getEmpNo());
			pstmt.setInt(5, item.getSalary());
			pstmt.setInt(6, item.getDno().getDeptNo());
			
			pstmt.executeUpdate();
			
		}
	}

	@Override
	public void deleteItem(Employee item) throws SQLException {
		String sql = "delete from employee where empno=?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(Employee item) throws SQLException {
		String sql = "update employee set empname=?,title=?,manager=?,salary=?,dno=? where empno=?";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setString(1, item.getEmpName());
			pstmt.setInt(2, item.getTitle().getTitleNo());
			pstmt.setInt(3, item.getManager().getEmpNo());
			pstmt.setInt(4, item.getSalary());
			pstmt.setInt(5, item.getDno().getDeptNo());
			pstmt.setInt(6, item.getEmpNo());
			
			pstmt.executeUpdate();
		}
	}

	@Override
	public Employee selectItemByNo(Employee item) throws SQLException {
		String sql = "select empno,empname,title,manager,salary,dno from employee where empno=?";
		Employee emp=null;
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					emp = getEmployee(rs);
				}
			}
		}
		return emp;
	}

	@Override
	public List<Employee> selectItemByAll() throws SQLException {
		List<Employee> lists = new ArrayList<>();
		String sql = "select empno,empname,title,manager,salary,dno from employee";
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getEmployee(rs));
			}
		}
		return lists;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt(1);
		String empName = rs.getString(2);
		int salary = rs.getInt(5);
		int managerNum = rs.getInt(4);
		
		Title title = TitleDao.getInstance().selectItemByNo(new Title(rs.getInt(3)));
		Employee manager = new Employee();
		if(managerNum!=0){
			manager = EmployeeDao.getInstance().selectItemByNo(new Employee(rs.getInt(4)));
		}
		
		Department dno = DepartmentDao.getInstance().selectItemByNo(new Department(rs.getInt(6)));
	
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	public List<Employee> selectItemByDno(Department item) throws SQLException {
		List<Employee> lists = new ArrayList<>();
		String sql = "select empno,empname,title,manager,salary,dno from employee where dno=?";
		Connection con = DBCon.getInstance().getConnection();
		
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getDeptNo());
			try(ResultSet rs= pstmt.executeQuery();){
				while(rs.next()){
					lists.add(getEmployee(rs));
					
				}
			}
		}

		return lists;
	}
}
