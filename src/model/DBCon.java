package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import User.Book;
import User.member;


public class DBCon {
	private ResultSet users;
	private ResultSet rs;
	
	private DataSource datasource;
	
	public DBCon(DataSource thedatasource) {
		datasource=thedatasource;
	}
	
	public List<Book> getBooks() throws Exception {
		
		
		List<Book> book=new ArrayList<>();
		
		
		Connection conn;
		Statement stmt;
		
		try {
		conn=datasource.getConnection();
		stmt = conn.createStatement();
		String query= "Select * from book";
		rs =stmt.executeQuery(query);
		
		while(rs.next()) {
			int book_id=rs.getInt("bookid");
			String bname=rs.getString("bookname");
			String author=rs.getString("author");
			String category=rs.getString("category");
			String price=rs.getString("price");
			
			Book thebook=new Book(book_id,bname, author, category, price);
					
			
			book.add(thebook);
		}
		
		
		  
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return book;
		
		
	}
	
      public List<member> getmember() throws Exception {
		
		
		List<member> member1=new ArrayList<>();
		
		
		Connection conn;
		Statement stmt;
		
		try {
		conn=datasource.getConnection();
		stmt = conn.createStatement();
		String query= "Select * from members";
		rs =stmt.executeQuery(query);
		
		while(rs.next()) {
			int member_id=rs.getInt(1);
			String fullname=rs.getString(2);
			String dob=rs.getString(3);
			String paddress=rs.getString(4);
			String caddress=rs.getString(5);
			String mobile=rs.getString(6);
			String homeno=rs.getString(7);
			String password=rs.getString(8);
			String email=rs.getString(9);
			String nic=rs.getString(10);
			
			member themember=new member(fullname, dob, paddress, caddress, mobile, homeno, password, email, member_id,nic);
					
			member1.add(themember);
		}
		
		
		  
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return member1;
		
		
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

	public Book getBooks(int book_id, DataSource dataSource) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		Book book=null;
		try {
			System.out.println("3"+book_id);
			conn=datasource.getConnection();
			stmt = conn.createStatement();
			String query= "Select * from book where bookid='"+book_id+"'";
			String name = null,author = null,category = null,price = null;
			rs =stmt.executeQuery(query);
			if(rs.next()) {
				name=rs.getString("bookname");
				author=rs.getString("author");
				category=rs.getString("category");
				price=rs.getString("price");
				
			}
			System.out.println(name+author+category+price);
			book= new Book(book_id, name, author, category, price);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
			stmt.close();
			rs.close();
		}
		
		
		return book;
	}

	public void updateBook(Book book1, DataSource dataSource2) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=datasource.getConnection();
			stmt = conn.createStatement();
			String query= "update book set bookname='"+book1.getName()+"',author='"+book1.getAuthor()+"',category='"+book1.getCategory()+"',price='"+book1.getPrice()+"' where bookid='"+book1.getBook_id()+"'";
			stmt.executeUpdate(query);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			conn.close();
			stmt.close();
	
		}
	}
	
	public void deletebook(int book_id,DataSource datasourse) throws SQLException {
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=datasource.getConnection();
			stmt = conn.createStatement();
			String query= "delete from book where bookid='"+book_id+"' ";
			stmt.executeUpdate(query);
		} finally {
			conn.close();
			stmt.close(); 
		}
		

	}
    public void deletemember(int member_id,DataSource datasourse) throws SQLException {
		
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=datasource.getConnection();
			stmt = conn.createStatement();
			String query= "delete from members where memberiID='"+member_id+"' ";
			stmt.executeUpdate(query);
		} finally {
			conn.close();
			stmt.close(); 
		}
		

	}
    
    public void login(String username,String password,DataSource datasourse) throws SQLException {
    	
    
		
	}

	public void addMember(member mem, DataSource dataSource2) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=dataSource2.getConnection();
			stmt=conn.createStatement();
			String name=mem.getFullname();
			String DOB=mem.getDob();
			String paddress=mem.getPaddress();
			String caddress=mem.getCaddress();
			String mobile=mem.getMobile();
			String home=mem.getHomenumber();
			String email=mem.getEmail();
			String nic=mem.getNic();
			String password=mem.getPassword();

			String query="insert into members(Fullname,dob,paddress,caddress,mobile,homeno,password,email,nic) "
					+ "values('"+name+"','"+DOB+"','"+paddress+"','"+caddress+"','"+mobile+"','"+home+"','"+password+"','"+email+"','"+nic+"')";
			String query2="insert into login(username,password,type) values('"+nic+"','"+password+"','User')";
			stmt.execute(query);
			stmt.execute(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
	}

	public void makeAdmin(int nic, DataSource dataSource2) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		try {
			conn=datasource.getConnection();
			stmt = conn.createStatement();
			String query=  "Update login set type='Admin' where username='"+nic+"'";
			stmt.executeUpdate(query);
		} finally {
			conn.close();
			stmt.close(); 
		}
	}
	
}



















 