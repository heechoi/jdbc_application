package kr.or.dgit.jdbc_application.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection  connection;
	
	public static DBCon getInstance() {
		return instance;
	}

	private DBCon(){
		Properties properties = getProperties("conf.properties");
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pwd"));
		} catch (SQLException e) {
			System.out.printf("%s %s-%n",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
		/*System.out.println(properties.get("user"));
		System.out.println(properties.get("pwd"));
		System.out.println(properties.get("url"));*/
	} //생성자를 private으로 해서 아무나 생성하지 못하게 한다. properties를 불러오는 방법 // db경로를 바로 연결해준다

	private Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath); //읽기모드로 파일을 열었다.
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public Connection getConnection() {
		return connection;
	}

	
	
}
