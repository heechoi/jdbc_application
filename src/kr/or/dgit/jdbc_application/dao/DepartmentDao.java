package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class DepartmentDao implements SqlDao<Department> {
	private static final DepartmentDao instance = new DepartmentDao();

	public static DepartmentDao getInstance() {
		return instance;
	}

	private DepartmentDao() {
	}

	@Override
	public void insertItem(Department item) throws SQLException { // 예외를 나를 호출한
																	// 곳에서 예외처리를
																	// 하겠다.
		String sql = "INSERT INTO department VALUES(?,?,?)";
		Connection con = DBCon.getInstance().getConnection();

		// int res =0;

		try (PreparedStatement pstmt = con.prepareStatement(sql);) { // autoclose
			pstmt.setInt(1, item.getDeptNo());
			pstmt.setString(2, item.getDeptName());
			pstmt.setInt(3, item.getFloor());
			// res = pstmt.executeUpdate(); //제대로 sql문을 받게 되면 1이된다.

			pstmt.executeUpdate();
			// System.out.println(pstmt);
		} /*
			 * catch (SQLException e) { System.err.printf("%s - %s%n"
			 * ,e.getErrorCode(),e.getMessage()); e.printStackTrace(); }
			 */ // 호출하는 메인에서 예외처리를 해준다.
		// return res;
	}

	@Override
	public void deleteItem(Department item) throws SQLException {
		String sql = "delete from department where deptno = ?"; // sql변수를 필드로
																// 지정할 경우 함수가
																// 끝나도 메모리에 남아있게
																// 된다. 하지만, 함수에
																// 변수로 선언되면 함수가
																// 끝난 후 사라진다.
																// 함부로 필드로 빼는 것은
																// 좋지 못함
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) { // autoclose를
																		// 구현하고
																		// 있으므로
																		// jdbcclose를
																		// 하지
																		// 않아도
																		// 된다.
			pstmt.setInt(1, item.getDeptNo());

			pstmt.executeUpdate(); // sql문장을 실행한다.
			// System.out.println(pstmt);
		} /*
			 * catch (SQLException e) { System.err.printf("%s - %s%n"
			 * ,e.getErrorCode(),e.getMessage()); e.printStackTrace(); }
			 *//*
			 * finally{ JdbcUtil.close(); }
			 */

	}

	@Override
	public void updateItem(Department item) throws SQLException {
		String sql = "update department set deptname=?, floor=? where deptno=?";  //deptno는 바꿀 수 없다.
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getDeptName());
			pstmt.setInt(2, item.getFloor());
			pstmt.setInt(3, item.getDeptNo());
			pstmt.executeUpdate();
		}

	}

	@Override
	public Department selectItemByNo(Department item) throws SQLException {

		String sql = "select deptno, deptname, floor from department where deptno=?";
		Department dept = null;

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);) {
			pstmt.setInt(1, item.getDeptNo());
			try (ResultSet rs = pstmt.executeQuery();) { // rs를 그냥 하나의 try를 사용하게
															// 되면 아무것도 담지 않은
															// 상태에서 sql문을 날리게
															// 되므로 오류가 뜬다. sql문에
															// 넣어주고 다른 try로
															// 묶어줘야한다.
				if (rs.next()) {
					dept = getDepartment(rs);
				}
			}
		}
		return dept;
	}

	@Override
	public List<Department> selectItemByAll() throws SQLException {
		List<Department> lists = new ArrayList<>();
		String sql = "select deptno, deptname, floor from department";

		try (PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getDepartment(rs));
			}

		}

		return lists;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt(1);
		String deptName = rs.getString(2);
		int floor = rs.getInt(3);
		return new Department(deptNo, deptName, floor);
	}

}
