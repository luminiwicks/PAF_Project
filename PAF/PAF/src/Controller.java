

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

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
	
	private DBCon dbcon;
	
	@Resource(name="jdbc/4CKBC") 
	private DataSource dataSource;
	

	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		try {
			dbcon=new DBCon(dataSource);
		} catch (Exception e) {
			throw new ServletException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String page; 
		
		
		
		
		if(request.getParameterMap().containsKey("page")) {
			
			page=request.getParameter("page");
		}else {
			page="home.jsp";
		}
			
		
		
		if(page.equals("members")) {
			request.getRequestDispatcher("members.jsp").forward(request, response);
		}else if(page.equals("books")) {
			try {
				listtbooks(request,response);
				request.getRequestDispatcher("books.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}

			
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
	
	
	private void listtbooks(HttpServletRequest request, Object res) throws Exception {

            List<Book> book=dbcon.getBooks();
            request.setAttribute("Book_list", book);
		
	}



	private void SubmitBook(Book book, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		dbcon.addBook(book,dataSource);
		request.getRequestDispatcher("SubmitDone.jsp").forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
