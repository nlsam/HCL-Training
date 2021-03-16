<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Users</h2>
<br>
<table style="float:left">
   <tr><th>ID</th><th>Name</th><th>Email</th><th>Favorite Color</th></tr>
   <c:forEach items="${users}" var="user" varStatus="count">
    <tr id="${count.index}">
    	<td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.favColor}</td>
    </tr>
  </c:forEach>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<form action ="/users" method="get">
  <label for="id">Id:</label><br>
  <input type="text" id="id" name="id"><br>
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email"><br>
  <label for="color">Favorite color:</label><br>
  <input type="text" id="color" name="color"><br>
  <input type="submit" value="Update">
</form>

</body>
</html>