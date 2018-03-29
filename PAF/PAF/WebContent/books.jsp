<%@page import="java.sql.ResultSet"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="/action_page.php">
  <div class="form-group">
    <label for="book">Book Name:</label>
    <input type="text" class="form-control" >
  </div>
  <div class="form-group">
   <label for="author">Author:</label>
    <input type="text" class="form-control" >
  </div>
  <div class="form-group">
  <label for="category">Category:</label>
    <input type="text" class="form-control" >
  </div>
  <div class="form-group">
    <label for="price">Price:</label>
    <input type="text" class="form-control" >
  </div>
  <div class="form-group">
  <button type="submit" class="btn btn-default">Submit</button>
  </div>
</form>

<table class="table table-striped">
    <thead>
      <tr>
        <th>Book Name</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Options</th>
      </tr>
    </thead>
    <tbody>
<%
	ResultSet rs = (ResultSet)request.getAttribute("books");
	while(rs.next()){
		String name=rs.getString("bookname");
		String author=rs.getString("author");
		String cat=rs.getString("category");
		String price=rs.getString("price");
	
	      out.println("<tr>");
	      
	      out.println("<td>");
	      out.print(name);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(author);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(cat);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print(price);
	      out.println("</td>");
	      
	      out.println("<td>");
	      out.print("Update/Remove");
	      out.println("</td>");
	      
	      
	      
	      out.println("</tr>");
	      
		
	}

%>
</tbody>
  </table>

<jsp:include page="footer.jsp"></jsp:include>

