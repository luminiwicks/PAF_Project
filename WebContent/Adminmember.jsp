<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="headeradmin.jsp"></jsp:include>
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table class="table table-striped">
    <thead>
      <tr class="info">
        <th>Fullname</th>
        <th>Date Of Birth</th>
        <th>Permenant Address</th>
        <th>Current Address</th>
        <th>Mobile Number</th>
         <th>Home Number</th>
           <th>E-Mail</th>
            <th>NIC No</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="themember" items="${member_list}">
 
    <c:url var="tempURL2" value="Controller">
    <c:param name="page" value="deletemember"/>
    <c:param name="member_id" value="${themember.member_id}"></c:param>
    </c:url>
     <c:url var="tempURL3" value="Controller">
    <c:param name="page" value="makeAdmin"/>
    <c:param name="nic" value="${themember.nic}"></c:param>
    </c:url>
    <tr>
    		<td>${themember.fullname}</td>
    		<td>${themember.dob}</td>
    		<td>${themember.paddress}</td>
    		<td>${themember.caddress}</td>
    		<td>${themember.mobile}</td>
    		<td>${themember.homenumber}</td>
    		<td>${themember.email}</td>
    		<td>${themember.nic}</td>
    </tr>
    </c:forEach>

</tbody>
  </table>
<jsp:include page="footer.jsp"></jsp:include>
