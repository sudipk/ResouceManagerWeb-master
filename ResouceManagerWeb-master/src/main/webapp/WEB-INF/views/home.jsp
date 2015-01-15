<%@ include file="./include.jsp"%>
<%@ page session="false" %>
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
<style>
body{
               //background-image: url("${context}/resources/images/MobileCloudComputing.png");
                background-color: lightblue;
                //border: 3px dotted black;
                margin: 10px;
                padding-bottom: 20px;
                width:50%;
                margin:auto;
            }
            section {
            	//background-image: url("${context}/resources/images/MobileCloudComputing.png");
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
            a {
    				font-size:200%;
			}
</style>
	<title>Mobile Cloud Resource Mangement System</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
	
</head>
<body background="${context}/resources/images/MobileCloudComputing.png">
<section>

<center >
<h1><font color="darkblue" size="10">Mobile Cloud Resource Mangement System</font> </h1>
	
<br>
<br>
<br>
<table class="table table-hover">
<tr>
<td ><a href="${context}/clouds">Clouds</a>&nbsp&nbsp&nbsp&nbsp</td>
<td><a href="${context}/instances">Instances</a>&nbsp&nbsp&nbsp&nbsp</td>
<td><a href="${context}/users">Users & Billing</a>&nbsp&nbsp&nbsp&nbsp</td>
<td><a href="${context}/rates">Cost</a>&nbsp&nbsp&nbsp&nbsp</td>
</tr>
</font>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
</center>
<h4 style="background-color:White; text-align:center;color:#3B5998; font-family: Times New Roman;font-size:10;">Cloud Technologies Course CMPE 281 at SJSU</h4>
</section>


</center>
</div>
</body>
</html>
