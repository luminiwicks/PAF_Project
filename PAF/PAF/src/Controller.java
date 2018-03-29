

import java.io.IOException;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import User.Book;
import model.DBCon;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Resource(name="jdbc/4CKBC") 
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page; 
		if(request.getParameterMap().containsKey("page")) {
			
			page=request.getParameter("page");
		}else {
			page="home.jsp";
		}
			
		
		
		if(page.equals("members")) {
			ResultSet rs= new DBCon().getUsers(dataSource);
			request.setAttribute("users",rs);
			request.getRequestDispatcher("members.jsp").forward(request, response);
		}else if(page.equals("books")) {
			ResultSet rs= new DBCon().getBooks(dataSource);
			request.setAttribute("books",rs);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		}else if(page.equals("home")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		}else if(page.equals("submitBook")) {
			String name=request.getParameter("bookname");
			String author=request.getParameter("author");
			String category=request.getParameter("category");
			String price=request.getParameter("price");
			System.out.println(name+author);
			Book book=new Book(name,author,category,price);
			System.out.println(book.getName());
			SubmitBook(book,request,response);
		}
		else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
		
	}

	private void SubmitBook(Book book, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		new DBCon().addBook(book,dataSource);
		request.getRequestDispatcher("SubmitDone.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
