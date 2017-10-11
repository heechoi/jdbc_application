package kr.or.dgit.jdbc_application;

import java.sql.Connection;

import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance(); 
		//이것을 통해서 DBCon을 생성하는것 하나만 생성하는 방법 싱글텀
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);

		JdbcUtil.close(connection);
	}

}
