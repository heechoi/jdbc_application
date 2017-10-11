package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		// testDBCon();
		Department dept = new Department(4, "마케팅", 10);
		
		//추가
		testInsert(dept);
		testListAll();
		
		//수정
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testDeptNo(dept);
		
		//삭제
		testDelete(dept);
		testListAll();

		
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDeptNo(Department dept) {
		try {
			Department searchDept = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(searchDept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for (Department dept : lists) {
				System.out.println(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
			e.printStackTrace();
		}
	}

	private static void testInsert(Department dept) {
		// int res;
		try {
			// res = DepartmentDao.getInstance().insertItem(new Department(4,
			// "마케팅", 10));
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가되었습니다.");
			// System.out.println(res);
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
			}
			e.printStackTrace();
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();
		// 이것을 통해서 DBCon을 생성하는것 하나만 생성하는 방법 싱글텀

		Connection connection = dbCon.getConnection();
		System.out.println(connection);

		JdbcUtil.close(connection);
	}

}
