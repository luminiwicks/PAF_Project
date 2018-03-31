<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headeruser.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table table-striped">
    <thead>
      <tr class="info">
        <th>Book Name</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
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
    	</tr>
    </c:forEach>
    
</tbody>
  </table>

<jsp:include page="footer.jsp"></jsp:include>
