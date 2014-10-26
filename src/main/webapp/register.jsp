<%-- 
    Document   : register.jsp
    Created on : Sep 28, 2014, 6:29:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <header>
        <h1>InstaGrim ! </h1>
        
        </header>
        <nav>
            <ul>
                
                <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
            </ul>
        </nav>
       
        <article>
            <h3>Register as user</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>Username <input type="text" name="username"></li>
                    <li>Password <input type="password" name="password"></li>
                	<li>First Name: <input type="text" name ="firstName"></li>
                	<li>Last Name: <input type = "text" name = "lastName"></li>
                	<li>Email Address: <input type = "email" name = "email"></li>
                	<li>Gender: Male <input type ="radio" name ="sex" value="male">
                		Female <input type ="radio" name ="sex" value="female"></li>
                    
                    
                    <li>You must be 12 or over to register to this web site. Please check if you are over 12: <input type = "checkbox" name="age"></li>
                    <li>Please check this box to agree to the Terms and Conditions <input type ="checkbox" name="agreement"></li>
                </ul>
                <br/>
                <input type="submit" value="Register"> 
          
            
            <script>
			function check () {
				
				//This script is to validate all inputs for the Register page.  
				var user = document.getElementByID("username").value;
				var pass = document.getElementByID("password").value;
				var first = document.getElementByID("firstName").value;
				var last = document.getElementByID("lastName").value;
				var email = document.getElementByID("email").value;
				
				var sex = document.getElementByID("sex").checked;
				
				var age = document.getElementById("age").checked;
				var agree = document.getElementById("agreement").checked;
				
				
				if(x != true & y != true )
					{
					if(user == null | pass == null | first == null | last == null | email == null | sex == null)
						{
					
					System.out.println("Failed to properly enter all data.");
					response.sendRedirect("Register.jsp");
					
					}}
				
			}
			</script>
  </form>
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
