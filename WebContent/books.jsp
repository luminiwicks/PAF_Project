<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="${pageContext.request.contextPath}/Controller">
  <div class="form-group">
    <label for="book">Book Name:</label>
    <input type="text" name="bookname" class="form-control" >
  </div>
  <div class="form-group">
   <label for="author">Author:</label>
    <input type="text"  name="author" class="form-control" >
  </div>
  <div class="form-group">
  <label for="category">Category:</label>
    <input type="text"  name="category" class="form-control" >
  </div>
  <div class="form-group">
    <label for="price">Price:</label>
    <input type="text" name="price" class="form-control" >
  </div>
  <div class="form-group">
  <button type="submit" class="btn btn-default">Submit</button>
  <input type="hidden" name="page" value="submitBook"/>
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
    <c:forEach var="thebook" items="${Book_list}">
    <c:url var="tempURL" value="Controller">
    <c:param name="page" value="updateBook"/>
    <c:param name="book_id" value="${thebook.book_id}"></c:param>
    </c:url>
    
    <c:url var="tempURL2" value="Controller">
    <c:param name="page" value="deleteBook"/>
    <c:param name="book_id" value="${thebook.book_id}"></c:param>
    </c:url>
    
    
    
    	<tr>
    		<td>${thebook.name}</td>
    		<td>${thebook.author}</td>
    		<td>${thebook.category}</td>
    		<td>${thebook.price}</td>
    		<td><a href="${tempURL}">Update</a> |
    		<a href="${tempURL2}" onclick="if(!(confirm('Do You Want To Delete This BooK ?')))  return false">Delete</a>
    		
    		</td>
    	
    	</tr>
    </c:forEach>
    
</tbody>
  </table>

<jsp:include page="footer.jsp"></jsp:include>
