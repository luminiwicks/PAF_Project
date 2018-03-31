

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import User.logindata;
import javafx.scene.control.Alert;
import model.DBCon;

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
			
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			session.invalidate();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			System.out.println("log out");
		}
		
		
		Cookie[] cookies=request.getCookies();
		String user="";
		String pass="";
		if(cookies!=null) {
			try {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if(cookie.getValue().equalsIgnoreCase("username")) {
						user=cookie.getValue();
					}
					if(cookie.getValue().equalsIgnoreCase("password")) {
						 pass=cookie.getValue();
					}
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		request.setAttribute("username", user);
		request.setAttribute("password", pass);
		getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
	}

	
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
				
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			
			
			Cookie cookie=null;
			Cookie cookie1=null;
			
			Cookie[] cookies=request.getCookies();
			
			if(cookies!=null) {
				try {
					for (int i = 0; i < cookies.length; i++) {
						Cookie cookiess = cookies[i];
						if(cookiess.getValue().equalsIgnoreCase("username")) {
							user=cookiess.getValue();
						}
						if(cookiess.getValue().equalsIgnoreCase("password")) {
							 pass=cookiess.getValue();
						}
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(cookie == null) {
				cookie=new Cookie("username", String.valueOf(user));
				cookie.setHttpOnly(true);
				cookie.setComment("this cookie save the value of the username");
			}
			if(cookie1 == null) {
				cookie1=new Cookie("password", String.valueOf(pass));
				cookie.setHttpOnly(true);
				cookie.setComment("this cookie save the value of the username");
			}
			cookie.setMaxAge(1*60*60);
			response.addCookie(cookie);
			cookie1.setMaxAge(1*60*60);
			response.addCookie(cookie1);
			
			request.setAttribute("username", user);
			request.setAttribute("password", pass);
			getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				 
			 logindata logindata = new logindata();
			 
			 logindata.setUserName(uname);
			 logindata.setPassword(pwd);
			 
			 DBCon dbcon = new DBCon(dataSource);
			 
			 try
			 {
			 String userValidate = dbcon.authentication(logindata);
			 
			 if(userValidate.equals("Admin_Role"))
			 {
			 System.out.println("Admin's Home");
			 
			 HttpSession session = request.getSession(); //Creating a session
			 session.setAttribute("Admin", uname); //setting session attribute
			 request.setAttribute("userName", uname);
			 
			 request.getRequestDispatcher("/Adminhome.jsp").forward(request, response);
			 }
			 else if(userValidate.equals("owner_Role"))
			 {
			 System.out.println("owner's Home");
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("Editor", uname);
			 request.setAttribute("userName", uname);
			 
			 request.getRequestDispatcher("/home.jsp").forward(request, response);
			 }
			 else if(userValidate.equals("User_Role"))
			 {
			 System.out.println("User's Home");
			 
			 HttpSession session = request.getSession();
			 session.setMaxInactiveInterval(10*60);
			 session.setAttribute("Student", uname);
			 request.setAttribute("userName", uname);
			 
			 request.getRequestDispatcher("/Userhome.jsp").forward(request, response);
			 }
			 else
			 {
			 System.out.println("Error message = "+userValidate);
			 request.setAttribute("errMessage", userValidate);
			 
			 request.getRequestDispatcher("/index.jsp").forward(request, response);
			 }
			 }
			 catch (IOException e1)
			 {
			 e1.printStackTrace();
			 }
			 catch (Exception e2)
			 {
			 e2.printStackTrace();
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
		
	}

}
