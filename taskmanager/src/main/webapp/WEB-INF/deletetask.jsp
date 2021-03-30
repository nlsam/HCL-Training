<html>
<body style="background-color:darkgrey;">
<h1 style="font-style:italic;color:black; text-align:center">Task Manager:Luxury Edition</h1>
Welcome
<a style="float:right" href="logout"> Logout</a>
<div style="background-color:black; color:yellow; text-align:center">
<a href="create"> Create a new Task</a> 
<a href="display"> Display Tasks</a>
<a href="delete"> Delete Tasks</a>
<a href="update"> Update Tasks</a>
</div>
<form style="float:center" action="deletetasks" method="post">
<label for="id">Task ID</label><br>
  <input type="text" id="id" name="id"> <br>
  <input type="submit" value="Delete"><br>
</form>
${message}
</body>
</html>