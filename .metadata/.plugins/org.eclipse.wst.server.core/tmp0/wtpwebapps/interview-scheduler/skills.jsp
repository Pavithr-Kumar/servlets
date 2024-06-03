<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" type="text/css" href="./jsp/skills.css"> 
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Skills</title>
</head>
<style>
.buttons input{
margin-left: 16px ;
border-radius: 10px;
outline: none;
border: none;
padding: 12px 16px;
background-color: rgb(192, 192, 192);
}
.buttons>a:hover{
    box-shadow: 0px 0px 10px black;
}
.buttons>a:active{
    transform: scale(1.1);
}

.buttons button{

padding: 8px 16px;
border-radius: 10px;
margin-left: 35px;
box-shadow: 0px 0px 5px;
transition: all 0.5s;
border:none;
cursor:pointer;
}
.buttons button:hover{
    box-shadow: 0px 0px 10px black;
}
.buttons button:active{
    transform: scale(1.1);
}

</style>
<body>
   
    <h1>Skills</h1>
    <div class="buttons">
        <a href="/interview-scheduler/skill?action=showall" style="color: white;background-color: rgb(129, 182, 49);">Show All <i class="fa-solid fa-list-ol"></i></a>
       <form action="/interview-scheduler/skill?action=add" method="post">
        <input type="text" placeholder="enter skill" required name="skill" id="inputVal">
       
        <button style="color: white;background-color: rgb(83, 107, 216);" type="submit" >Add Skill <i class="fa-solid fa-plus"></i></button>
       </form>

    </div>
   
        
        <c:if test="${count!=null }">
            <c:if test="${count==0 }">
            <p style=color:red;margin-left:180px;margin-top:16px;font-weight:600>Skill Already Exists</p>
            </c:if>
        </c:if>
       
   
    <div class="tabdata">
        <table>
            <tr>
                <th>Skill Id</th>
                <th>Skill Description</th>
                
            </tr>
            
            <c:forEach items="${skills}" var="skill" >
            
            <tr>
                <td>${skill.getSkillId() }</td>
                <td>${skill.getSkillDsec() }</td>
                
                
            </tr>
            </c:forEach>
            
        </table>
    </div>
    

    
   

</body>
</html>