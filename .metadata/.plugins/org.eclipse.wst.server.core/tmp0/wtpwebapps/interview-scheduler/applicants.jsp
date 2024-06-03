<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" type="text/css" href="./jsp/skills.css"> 
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Applicants</title>
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
   
    <h1>Applicants</h1>
    <div class="buttons">
        <a href="/interview-scheduler/applicant?action=showall" style="color: white;background-color: rgb(129, 182, 49);">Show All <i class="fa-solid fa-list-ol"></i></a>
       
       
        <a style="color: white;background-color: rgb(83, 107, 216);" href="/interview-scheduler/applicant?action=add-new" >Add Applicant <i class="fa-solid fa-plus"></i></a>
       <form action="/interview-scheduler/applicant?action=search" method="post">
         <select name="skillId" id="" aria-placeholder="eg: java" required>
                
                  <c:forEach items="${skills }" var="skill">
                  
                    <option value="${skill.getSkillId() }">${skill.getSkillDsec() }</option>
                    
                  </c:forEach>
                  </select>
          <button type="submit"><i class="fa-solid fa-magnifying-glass"></i> Search</button>
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
                <th>Applicant Id</th>
                <th>Name</th>
                <th>Primary Skill</th>
                <th>Qualification</th>
                <th>Stream</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Schedule Interview</th>
            </tr>
            
            <c:forEach items="${applicants}" var="applicant" >
            
            <tr>
                <td>${applicant.getApplicantId() }</td>
                <td>${applicant.getApplicantName() }</td>
                <td>${applicant.getApplicantSkill() }</td>
                <td>${applicant.getApplicantQualification() }</td>
                <td>${applicant.getAppEducatStream() }</td>
               
                
                <td><a href="/interview-scheduler/applicant?action=edit&id=${applicant.getApplicantId() }"><i style=color:blue class="fa-solid fa-pen-to-square"></i></a></td>
                <td><a href="/interview-scheduler/applicant?action=delete&id=${applicant.getApplicantId() }"><i  class="fa-solid fa-trash" onclick="return confirm('Do you want to delete this applicant ?')"></i></a></td>
                <td><a href="/interview-scheduler/applicant?action=schedule&id=${applicant.getApplicantId() }"><i style=color:green;margin-left:22px class="fa-solid fa-calendar-days"></i></a></td> 
            </tr>
            </c:forEach>
            
        </table>
    </div>
    

    
   

</body>
</html>