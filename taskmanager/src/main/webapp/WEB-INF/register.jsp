 
<html>
<body style="background-color:darkgrey;">
<h1 style="font-style:italic;color:black; text-align:center">Task Manager:Luxury Edition</h1>
<h2 style="font-style:italic;color:black; text-align:center">Developed by Nehemiah Sam</h2>
<p> Please fill out the form below to register</p>
<form style="float:center" action="/register" method="post">
    <label for="firstname"> First Name:</label><br>
  <input type="text" id="name" name="firstname"><br>
  <label for="lastname"> Last Name:</label><br>
  <input type="text" id="lastname" name="lastname"><br>
  <label for="email"> Email:</label><br>
  <input type="text" id="email" name="email"><br>
    <label for="username"> Username:</label><br>
  <input type="text" id="username" name="username"><br>
    <label for="password">Password:</label><br>
  <input type="text" id="password" name="password"><br>
  <input type="submit" value="Register">
</form>
${message}
</body>
</html>