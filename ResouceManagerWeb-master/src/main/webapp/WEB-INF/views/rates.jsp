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
	
	<th> Rate ID </th>
	<th> Type </th>
	<th> Component </th>
	<th> Cost/Min </th>

</tr>
	<c:forEach var="rate_list" items="${rate_list}"  >
		<tr>
		   <td>${rate_list.getRateid()}</td>
		   <td>${rate_list.getType()}</td>
		   <td>${rate_list.getComponent()}</td>
		   <td>${rate_list.getCostpermin()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>