<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clouds</title>
</head>
<body>
 <table  cellpadding="10">
<tr>
	
	<th> User ID </th>
	<th> User Name </th>
	<th> Credit Card </th>
	<th> Email Id </th>
	<th> Phone </th>
	<th> Total Bill </th>
	<th> Paid Bill </th>
	<th> Bill Due </th>

</tr>
	<c:forEach var="user_list" items="${user_list}"  >
		<tr>
		   <td>${user_list.getUserid()}</td>
		   <td>${user_list.getName()}</td>
		   <td>${user_list.getCreditcard()}</td>
		   <td>${user_list.getEmailid()}</td>
		   <td>${user_list.getPhone()}</td>
		   <td>${user_list.getTotalbill()}</td>
		   <td>${user_list.getPaidbill()}</td>
		   <td>${user_list.getTotalbill()-user_list.getPaidbill()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>