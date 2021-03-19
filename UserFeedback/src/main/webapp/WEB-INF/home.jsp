<html>
<body>
<h2>User Feedback</h2>
<form action="/home" method="post">
  <label for="name">Enter Your Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="comment">Comment:</label><br>
  <input type="text" id="comment" name="comment"><br>
  <label for="rating">Rating:</label>
  <select id="rating" name="rating">
  <option value=1>1 Star</option>
  <option value=2>2 Stars</option>
  <option value=3>3 Stars</option>
  <option value=4>4 Stars</option>
  <option value=5>5 Stars</option>
  </select>
  <input type="submit" value="Submit">
</form>
</body>
</html>