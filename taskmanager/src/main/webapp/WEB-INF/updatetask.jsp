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
<form style="float:center" action="updatetasks" method="post">
  <label for="id">Task ID</label><br>
  <input type="number" id="id" name="id"> <br>
  <label for="name">Task Name</label><br>
  <input type="text" id="name" name="name"> <br>
  <label for="startdate"> Start Date </label><br>
  <input type="date" id="startdate" name="startdate"> <br>
  <label for="enddate"> End Date</label><br>
  <input type="date" id="enddate" name="enddate"> <br>
  <label for="description"> Description</label><br>
   <textarea name="description" rows="10" cols="30">
   </textarea><br>
   <label for="severity"> Severity</label><br>
  <select id="severity" name="severity">
  <option value="low">Low</option>
  <option value="medium">Medium</option>
  <option value="high">High</option>
  </select> <br>
<input type="submit" value="Update"><br>
</form>
${message}
</body>
</html>