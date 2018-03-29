package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;


public class DBCon {
	private ResultSet users;

	public ResultSet getUsers(DataSource dataSource) {
		
		Connection conn;
		Statement stmt;
		
		try {
		conn=dataSource.getConnection();
		stmt = conn.createStatement();
		String query= "Select * from members";
		users =stmt.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
			return users;
		}
		
		return users;
	}
}
 