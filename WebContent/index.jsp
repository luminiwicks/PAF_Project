<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>4C Knowledge Book Club</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="row">	
    <div class="col-lg-4">
      </div> 
  	<div class="col-lg-4">
  			<img alt="4c Knowledge" src="img/Logo.png">
	</div>
  <div class="col-lg-4">
    </div>
</div>

<div class="row">
      <div class="col-lg-4">
      </div>
    
       	
	  	<div class="col-lg-4">
                      
            <div class="form">
              <img src="img/8.png"/>
              <form class="register-form" action="${pageContext.request.contextPath}/Controller">
                  <input type="text" placeholder="Full Name"  name="name" />
                  <input type="text" placeholder="Date Of Birth" name="DOB" />
                  <input type="textarea" placeholder="Permnent Address" name="paddress" />
                   <input type="textarea" placeholder="Current Address" name="caddress" />
                   <input type="text" placeholder="Mobile Phone Number" name="mobile" />
                   <input type="text" placeholder="Home Telephone Number" name="home" />
                   <input type="text" placeholder="email Address" name="email"/>
                   <input type="text" placeholder="NIC" name="nic"/>
                  <input type="password" placeholder="Password" name="password"/>
                  
                    <input type="hidden" name="page" value="submitMember"/>
                  <button>create</button>
                  <p class="message">Already registered? <a href="#">Sign In</a></p>
              </form>
              <form class="login-form" method="post" action="LoginServlet">
                  <input type="text" placeholder="NIC Number" name="username" value="<%=request.getAttribute("username") %>"/>
                  <input type="password" placeholder="Password" name="password" value="<%=request.getAttribute("password") %>"/>
                  <button>login</button>
                  <p class="message">Not registered? <a href="#">Create an account</a></p>
              </form>
		        </div>
		  
			
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
            <script  src="js/index.js"></script>
        </div>
        <div class="col-lg-4">
      </div>
 </div>



</body>
</html>