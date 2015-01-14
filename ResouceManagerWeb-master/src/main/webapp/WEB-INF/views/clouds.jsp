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
	
	<th> Cloud ID </th>
	<th> Cloud Name </th>
	<th> Public IP </th>
	<th> Private IP </th>
	<th> Geo Location </th>

</tr>
	<c:forEach var="cloud_list" items="${cloud_list}"  >
		<tr>
		   <td>${cloud_list.getCloudid()}</td>
		   <td>${cloud_list.getName()}</td>
		   <td>${cloud_list.getPublicip()}</td>
		   <td>${cloud_list.getPrivateip()}</td>
		   <td>${cloud_list.getGeolocation()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>