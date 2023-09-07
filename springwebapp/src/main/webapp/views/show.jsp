<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<title>All Employees</title>
<body>
<div style="text-align:center;width: 400px;margin: 0 auto;border-style:solid;">
<table>

	<c:forEach var="employee" items="${List}"> 
		<tr>	
			<td>${employee.id}</td>
			<td>${employee.fName}</td>
			<td>${employee.lName}</td>
			<td>${employee.email}</td>
		</tr>
	</c:forEach> 
</table>
<form>
 		<p><button type="submit" formaction = "/home">Back</button></p>
</form>
</div>
</body>
</html>