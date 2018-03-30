<%@page import="java.sql.ResultSet"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table table-striped">
    <thead>
      <tr>
        <th>Fullname</th>
        <th>Date Of Birth</th>
        <th>Permenant Address</th>
        <th>Current Address</th>
        <th>Mobile Number</th>
         <th>Home Number</th>
           <th>E-Mail</th>
            <th>NIC No</th>
            <th>Options</th>
      </tr>
    </thead>
    <tbody>
<%
	ResultSet rs = (ResultSet)request.getAttribute("users");
	while(rs.next()){
		String name=rs.getString("Fullname");
		String dob=rs.getString("dob");
		String padd=rs.getString("paddress");
		String cadd=rs.getString("caddress");
		String mobile=rs.getString("mobile");
		String home=rs.getString("homeno");
		String password=rs.getString("password");
		String email=rs.getString("email");
		String nic=rs.getString("nic");
		
		
	      out.println("<tr>");
	      
	      out.println("<td>");
	      out.print(name);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(dob);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(padd);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(cadd);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(mobile);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(home);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(email);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(nic);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print("Make As Community Admin");
	      out.print("Update/Remove");
	      out.println("</td>");
	      
	      
	      
	      out.println("</tr>");
	      
		
	}

%>
</tbody>
  </table>
<jsp:include page="footer.jsp"></jsp:include>
