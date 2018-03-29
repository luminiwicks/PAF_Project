

import java.io.IOException;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.DBCon;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Resource(name="jdbc/PAF") 
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
			request.getRequestDispatcher("books.jsp").forward(request, response);
		}else if(page.equals("home")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
		
	}

}
