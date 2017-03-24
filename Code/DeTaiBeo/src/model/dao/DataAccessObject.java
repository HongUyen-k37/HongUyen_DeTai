package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Define;

public class DataAccessObject {

	public Connection getConnection() {
		Connection cnn=null;
		String url = String.format("jdbc:sqlserver://%s;databaseName=%s", Define.SEVER_NAME, Define.DB_NAME);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cnn = DriverManager.getConnection(url, Define.DB_USERNAME, Define.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnn;
	}

	public void getMessenger(SQLException ex){
		System.out.println(ex.getMessage());
	}
	public void getMessenger(Exception ex){
		System.out.println(ex.getMessage());
	}
	
	public void tryToClose(Connection cnn){
		try {
			cnn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void tryToClose(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void tryToClose(PreparedStatement pstm){
		try {
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
