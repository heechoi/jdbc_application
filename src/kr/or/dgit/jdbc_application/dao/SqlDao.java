package kr.or.dgit.jdbc_application.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;

public interface SqlDao<T> {
	void insertItem(T item)throws SQLException;
	void deleteItem(T item)throws SQLException;
	void updateItem(T item)throws SQLException;
	T selectItemByNo(T item)throws SQLException;
	List<T> selectItemByAll()throws SQLException;
	List<T> selectItemByDno(Department dept) throws SQLException;
}
