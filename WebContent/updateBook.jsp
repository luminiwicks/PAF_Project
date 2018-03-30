<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="${pageContext.request.contextPath}/Controller">
  <div class="form-group">
    <label for="book">Book Name:</label>
    <input type="text" name="bookname" value="${Book.name}" class="form-control" >
  </div>
  <div class="form-group">
   <label for="author">Author:</label>
    <input type="text"  name="author" value="${Book.author}" class="form-control" >
  </div>
  <div class="form-group">
  <label for="category">Category:</label>
    <input type="text"  name="category" value="${Book.category}" class="form-control" >
  </div>
  <div class="form-group">
    <label for="price">Price:</label>
    <input type="text" name="price"  value="${Book.price}" class="form-control" >
  </div>
  <div class="form-group">
  <button type="submit" class="btn btn-default">Submit</button>
  <input type="hidden" name="page" value="updateBook"/>
  <input type="hidden" name="action" value="submit"></input>
  <input type="hidden" name="book_id" value="${Book.book_id}">
  </div>
</form>
<% %>
<jsp:include page="footer.jsp"></jsp:include>
