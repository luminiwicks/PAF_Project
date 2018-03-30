

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/4CKBC") 
	private DataSource dataSource;
   
   
    @Override
public void init() throws ServletException {
	try {
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	super.init();
}

	public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("111111111111111");
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String uname =request.getParameter("username");

		String pwd =request.getParameter("password");
		System.out.println(uname);
		System.out.println(pwd);
		try {
			conn=dataSource.getConnection();
			stmt = conn.createStatement();
			String query= "select * from login where username='"+uname+"' and password='"+pwd+"' ";
		    rs=stmt.executeQuery(query);
		    if(rs.next()) {
		    	
		    	if("owner".equals(rs.getString("type"))) {
		    		System.out.println("test");
		    		response.sendRedirect("home.jsp?name="+rs.getString("username"));
		    		HttpSession httpSession = request.getSession();
		    		httpSession.setAttribute("uname",uname);
		    		
		    	}
		    	if("admin".equals(rs.getString("type"))) {
		    		response.sendRedirect("admin.jsp?name="+rs.getString("username"));
		    		HttpSession httpSession = request.getSession();
		    		httpSession.setAttribute("uname",uname);
		    		
		    	}
		    	if("user".equals(rs.getString("type"))) {
		    		response.sendRedirect("user.jsp?name="+rs.getString("username"));
		    		HttpSession httpSession = request.getSession();
		    		httpSession.setAttribute("uname",uname);
		    		
		    	}	
		    	}
		    else {
		    	request.getRequestDispatcher("/index.jsp").forward(request, response);
		    	
		    }
		    
		    System.out.println("sssssssssssssssssssssss");
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
		
	}

}
