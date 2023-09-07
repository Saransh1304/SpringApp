<html>
<head>
    <title>Page Title</title>
</head>
 
<body>
<div style="text-align:center;width: 400px;margin: 0 auto;border-style:solid;">
    <h2>Update Record</h2>
    <form modelAttribute="employee" method="post">
  		<p><label>ID : <input type="text" name="id"/></label></p>
 		<p><label>First Name : <input type="text" name="fName"/></label></p>
 		<p><label>Last Name: <input type="text" name="lName"/></label></p>
 		<p><label>Email : <input type="text" name="email"/></label></p>
 		<p><button type="submit" formaction = "/update/emp">Submit</button></p>
 		<p><button type="submit" formaction = "/home">Back</button></p>
 
    </form>
</div>
</body>
</html>