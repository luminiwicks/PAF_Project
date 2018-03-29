package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import User.Book;


public class DBCon {
	private ResultSet users;
	private ResultSet books;
	
	public ResultSet getBooks(DataSource dataSource) {
		Connection conn;
		Statement stmt;
		
		try {
		conn=dataSource.getConnection();
		stmt = conn.createStatement();
		String query= "Select * from book";
		books =stmt.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
			return books;
		}
		return books;
		
	}

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

	public void addBook(Book book, DataSource dataSource) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			String name=book.getName();
			String author=book.getAuthor();
			String category=book.getCategory();
			String price=book.getPrice();
			System.out.println(price);
			String query="insert into book(bookname,author,category,price) values('"+name+"','"+author+"','"+category+"','"+price+"')";
			System.out.println(query);
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}	}
}
 
 
