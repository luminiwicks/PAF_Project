

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import User.Book;
import User.member;
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
			try {
				listtmember(request, response);
				request.getRequestDispatcher("members.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			Book book=new Book(name,author,category,price);
			SubmitBook(book,request,response);
		}
		else if(page.equals("submitMember")) {
		String name=request.getParameter("name");
		String DOB=request.getParameter("DOB");
		String paddress=request.getParameter("paddress");
		String caddress=request.getParameter("caddress");
		String mobile=request.getParameter("mobile");
		String home=request.getParameter("home");
		String email=request.getParameter("email");
		String nic=request.getParameter("nic");
		String password=request.getParameter("password");
		member mem=new member(name, DOB, paddress, caddress, mobile, home, password, email, nic);
		SubmitMember(mem,request,response);
	}
		else if(page.equals("updateBook")) {
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			try {
				updateBook(book_id,request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1"+book_id);
			
	}else if(page.equals("makeAdmin")) {
		int nic=Integer.parseInt(request.getParameter("nic"));
		makeAdmin(nic,request,response);	
	}
		else if(page.equals("deleteBook")) {
			int book_id=Integer.parseInt(request.getParameter("book_id"));
			try {
				deleteBook(book_id, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1"+book_id);
			
		}
		else if(page.equals("deletemember")) {
			int member_id=Integer.parseInt(request.getParameter("member_id"));
			try {
				deletemember(member_id, request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1"+member_id);
			
		}
		
		else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
		
	}
	
	
	private void makeAdmin(int nic, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			dbcon.makeAdmin(nic,dataSource);
			request.getRequestDispatcher("SubmitDone.jsp").forward(request, response);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	private void SubmitMember(member mem, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			dbcon.addMember(mem,dataSource);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	private void updateBook(int book_id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		if(request.getParameterMap().containsKey("action")) {
			if(request.getParameter("action").equals("submit")) {
				
				String name=request.getParameter("bookname");
				String author=request.getParameter("author");
				String category=request.getParameter("category");
				String price=request.getParameter("price");

				Book book1=new Book(book_id,name,author,category,price);
				dbcon.updateBook(book1,dataSource);
				
				request.getRequestDispatcher("SubmitDone.jsp").forward(request, response);
			}
		}
		else {
		Book book=null;
	
		//Read book from DBCon
		try {
			book=dbcon.getBooks(book_id,dataSource);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//setAttribute
		request.setAttribute("Book",book);
		request.getRequestDispatcher("updateBook.jsp").forward(request, response);

		
	}
	}
	
	private void deleteBook(int book_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		  try {
			System.out.println("Deelete Method in controller");  
			dbcon.deletebook(book_id, dataSource);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		  listtbooks(request,response);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		  
	}
	private void deletemember(int member_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		  try {
			System.out.println("Deelete Method in controller");  
			dbcon.deletemember(member_id, dataSource);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		  listtmember(request, response);
		request.getRequestDispatcher("members.jsp").forward(request, response);
		  
	}

	private void listtbooks(HttpServletRequest request, Object res) throws Exception {

            List<Book> book=dbcon.getBooks();
            request.setAttribute("Book_list", book);
		
	}
	
	private void listtmember(HttpServletRequest request, Object res) throws Exception {

        List<member> member=dbcon.getmember();
        request.setAttribute("member_list", member);
	
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
