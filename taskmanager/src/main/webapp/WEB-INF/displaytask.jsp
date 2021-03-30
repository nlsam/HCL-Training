<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:darkgrey;">
<h1 style="font-style:italic;color:black; text-align:center">Task Manager:Luxury Edition</h1>
Welcome ${firstname} ${lastname}
<div style="background-color:black; color:yellow; text-align:center">
<a href="create"> Create a new Task</a> 
<a href="display"> Display Tasks</a>
<a href="delete"> Delete Tasks</a>
<a href="update"> Update Tasks</a>
</div>

<table style="float:center">
   <c:forEach items="${tasks}" var="task">
    <tr>
    	<td>Task: ${task}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>