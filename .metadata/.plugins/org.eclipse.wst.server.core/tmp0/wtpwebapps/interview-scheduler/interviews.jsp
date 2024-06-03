<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" type="text/css" href="./jsp/skills.css"> 
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Interviews</title>
</head>
<style>
table{
margin-bottom:60px;
}
th,td{
    padding: 15px 25px;
    
}
.buttons select{
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

.buttons a{

padding: 8px 16px;
border-radius: 10px;
margin-left: 35px;
box-shadow: 0px 0px 5px;
transition: all 0.5s;
border:none;
cursor:pointer;
}
.buttons a:hover{
    box-shadow: 0px 0px 10px black;
}
.buttons a:active{
    transform: scale(1.1);
}
.buttons button{

padding: 8px 16px;
border-radius: 10px;
margin-left: 35px;
box-shadow: 0px 0px 5px;
transition: all 0.5s;
background-color: rgb(182, 100, 100);
color: white;
border:none;
cursor:pointer;
}
.buttons button:hover{
    box-shadow: 0px 0px 10px black;
}
.buttons button:active{
    transform: scale(1.1);
}
.tabdata{
  margin-right:30px;

}

</style>
<body>
   
    <h1>Scheduled Interviews</h1>
    <div class="buttons">
        <a href="/interview-scheduler/interview?action=showall" style="color: white;background-color: rgb(129, 182, 49);">Show All <i class="fa-solid fa-list-ol"></i></a>
        <a href="search-interview.jsp" style="color: white;background-color: rgb(182, 100, 100);"><i class="fa-solid fa-magnifying-glass"></i> search</a>
         

       

    </div>
   
       
       
       
   
    <div class="tabdata">
        <table>
            <tr>
                <th>Schedule Id</th>
                <th>Applicant Name</th>
                <th>Interviewer Name</th>
                <th>Scheduled Date</th>
                <th>Scheduled Time</th>
                <th>Status</th>
                <th>Recruiter</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <c:forEach items="${interviews}" var="interview" >
            
            <tr>
                <td>${interview.getScheduleId() }</td>
                <td>${interview.getApplicantName() }</td>
                <td>${interview.getInterviewName() }</td>
                <td>${interview.getScheduleDate() }</td>
                <td>${interview.getScheduleTime() }</td>
                <td>${interview.getStatus() }</td>
               
                <td>${interview.getRecruiterName() }</td>
                
                <td><a href="/interview-scheduler/interview?action=edit&id=${interview.getScheduleId() }"><i style=color:blue class="fa-solid fa-pen-to-square"></i></a></td>
                <td><a href="/interview-scheduler/interview?action=delete&id=${interview.getScheduleId() }"><i  class="fa-solid fa-trash" onclick="return confirm('Do you want to delete this scheduled interview ?')"></i></a></td>
                
            </tr>
            </c:forEach>
            
        </table>
    </div>
    

    
   

</body>
</html>