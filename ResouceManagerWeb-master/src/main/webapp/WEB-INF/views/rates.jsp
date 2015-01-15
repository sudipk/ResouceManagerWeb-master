<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<!-- Bootstrap CSS -->
<link href="${context}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${context}/resources/includes/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="${context}/resources/includes/css/styles.css"
	rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body{
               background-image: url("${context}/resources/images/CloudServiceBilling.jpg");
                background-color: lightblue;
                //border: 3px dotted black;
                margin: 10px;
                padding-bottom: 20px;
                width:50%;
                margin:auto;
            }
            section {

                background-color: white;
                //border: 2px solid black;
                width: 700px;
                margin: 20px; /* all four sides */
                padding: 10px; /* all four sides */
            }
            h1,p{
                //background-color: white; 
                //border: 1px dashed black;
                padding: 10px;
            }
            h1 ,p{

                margin: .0em 0 0em; /* .5em top, 0 right and left, .25em bottom */
                padding-left: 15px;
            }
            p {

                margin: 0; /* all four sides */
                padding-left: 15px;
            }
</style>
<title>Billing Cost of Clouds</title>
</head>
<body >
<section>
<center>
<h1><font color="darkblue" size="6">Billing Cost of Clouds</font></h1>
 <table  cellpadding="10" class="table table-striped">
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
<a href="${context}/home">Back to Home</a>
</center>
</section>
</body>
</html>