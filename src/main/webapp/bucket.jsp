<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bucket</title>
</head>
<body>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="css/header.css">

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="js/header.js"></script>
<!------ Include the above in your HEAD tag ---------->

  <div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
      <span class="navbar-toggler-icon leftmenutrigger"></span>
      <a class="navbar-brand" href="#">DailyShop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav animate side-nav">
          <li class="nav-item">
            <a class="nav-link" href="cabinet.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
          	<a class="nav-link" href="createMagazine.jsp">Add Periodical</a>
           <!-- <a class="nav-link" href="$(pageContext.request.contextPath)/createMagazine.jsp">Add Periodical</a>  -->
          </li>
          <li class="nav-item">
          		<a class="nav-link" href="bucket.jsp">Bucket</a> 
            <!-- <a class="nav-link" href="$(pageContext.request.contextPath)/bucket.jsp">Bucket</a> --> 
          </li>
        </ul>
        <ul class="navbar-nav ml-md-auto d-md-flex">
        
          
          <li class="nav-item">
            <a class="nav-link" href="#">LogOut</a>
          </li>
        </ul>
      </div>
    </nav>
    
    
	<br><br><br>
	<h1>Bucket</h1>
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>