<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instances</title>
</head>
<body>
 <table  cellpadding="10">
<tr>
	
	<th> Instance ID </th>
	<th> Instance Name </th>
	<th> Cloud ID </th>
	<th> Status </th>
	<th> Type   </th>
	<th> OS </th>
	<th> CPU </th>
	<th> Memory </th>
	<th> Storage </th>
	<th> Public IP </th>
	<th> Private IP </th>
	<th> Up Time </th>
	<th> User ID </th>

</tr>
	<c:forEach var="instance_list" items="${instance_list}"  >
		<tr>
		   <td>${instance_list.getInstanceid() }</td>
		   <td>${instance_list.getName()}</td>
		   <td>${instance_list.getCloudid()}</td>
		   <td>${instance_list.getStatus()}</td>
		   <td>${instance_list.getType()}</td>
		   <td>${instance_list.getOs()}</td>
		   <td>${instance_list.getCpu()}</td>
		   <td>${instance_list.getMemory()}</td>
		   <td>${instance_list.getStorage()}</td>
		   <td>${instance_list.getPublicip()}</td>
		   <td>${instance_list.getPrivateip()}</td>
		   <td>${instance_list.getUptime()}</td>
		   <td>${instance_list.getUserid()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>