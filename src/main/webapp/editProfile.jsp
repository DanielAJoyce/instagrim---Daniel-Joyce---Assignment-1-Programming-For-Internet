<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@page import="uk.ac.dundee.computing.aec.instagrim.models.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <article>
 <% 
 	
 	
    
                        
                       
                            	%>
            <h3>Register as user</h3>
            
            
            
         
                <ul>
                <%
               
                LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                if (lg != null) {
                    String UserName = lg.getUsername();
                    String firstName = lg.getFirstName();
             		String lastName = lg.getLastName();
             		String email = lg.getEmail();
             		String sex = lg.getSex();
                  	
              
             	}%>
             	<form method="POST"  action="Edit">
             	
             		<li> This is the edit profile page, below are your details, submit the changes and it'll change your profile.</li>
                    <li>User name: <%=lg.getUsername()%></li>
                    <li>Current Password: <input type="password" name="currentPass"></li>
                    <li>New Password: <input type="password" name="currentPass"></li>
                	<li>First Name: <input type="text" name ="firstName" value =<%=lg.getFirstName()%>></li>
                	<li>Last Name: <input type = "text" name = "lastName" value=<%=lg.getLastName()%>></li>
                	<li>Email Address: <input type = "email" name = "email" value=<%=lg.getEmail()%>></li>
                	<li>Gender: <input type = "text" name = "email" value=<%=lg.getSex()%>></li>
                    
                    
                 
                </ul>
                <br/>
                <input type="submit" value="Submit Changes"> 
            </form>
            </article>
</body>
</html>

