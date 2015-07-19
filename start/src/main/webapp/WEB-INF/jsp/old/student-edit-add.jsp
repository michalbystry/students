<html lang="en">
<head>


  <title>Student - edit view</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>Add student</h2>
  <form class="form-inline" role="form" method="POST">
    <div class="form-group">
      <label class="sr-only" for="name">First Name:</label>
      <input type="text" class="form-control" id="first_name" name="first_name" placeholder="Enter first name">
    </div>
    <div class="form-group">
      <label class="sr-only" for="surname">Last Name:</label>
      <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Enter last name">
    </div>
    <div class="form-group">
      <label class="sr-only" for="email">PESEL:</label>
      <input type="text" class="form-control" id="PESEL" name="PESEL" placeholder="Enter PESEL">
    </div>
    <button type="submit" class="btn btn-default">Save</button>
  </form>
</div>
 
</body>
</html>


