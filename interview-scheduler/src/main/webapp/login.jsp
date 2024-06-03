<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./jsp/login.css">
        <title>Login Here</title>
        <style type="text/css">
        button{
        margin-top:16px;
        padding:12px;
        }
        @charset "ISO-8859-1";
body{
	margin:0px;
	padding: 0px;
    min-height: 80vh;
    background-image:url("https://plus.unsplash.com/premium_photo-1681487916420-8f50a06eb60e") ;
    background-size: contain;
    background-position: center;
    backdrop-filter: blur(10px);
}
#wrapper{
    width: 40%;
    padding-top: 70px;
    padding-bottom: 225px;
   
    border-radius: 10px;
    margin-inline: auto;
   
    display: flex;
    flex-direction: column;
    gap: 20px;
    align-items: center;
    
}
#wrapper>i{
    font-size: 54px;
    margin-top: 60px;
}
button{
    background-color:lightgreen;
   padding: 16px;
    display: block;
    padding: 16px;
    outline: none;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-weight: 600;
}
button:hover{
    background-color:rgb(89, 190, 89);
}
button:active{
    transform: scale(1.1);
}
label{
    font-size: 22px;
}
input{
    outline: none;
    border: none;
    border: 1px solid black;

    border-radius: 5px;
    padding: 8px 16px;
}
form{
    
    width: 50%;
    display: flex;
    flex-direction: column;
    gap: 10px;
}
        
        </style>
    </head>
    <body>
        <div id="wrapper">
        <h1>ZISA Login</h1>
        
            <i class="fa-solid fa-user"></i>
            <form action="login" method="post">
                <label for="user">Email Address</label>
            
                <input type="text" required name="email" placeholder="email">
                <label for="password">Password</label>
                <input type="password" required name="password" placeholder="password">
                <button type="submit">Login</button>
            </form>
           <%
           String invalid=(String)request.getAttribute("invalid");
           if(invalid!=null)
          out.println( "<p style=color:red;text-align:center;font-size:22px>"+ invalid +"</p>");
           %>
           <div >
           
           </div>
          
        </div>
        </body>
</html>