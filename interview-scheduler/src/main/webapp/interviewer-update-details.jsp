<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./jsp/interviewer-details.css">
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Interviewer Details</title>
    <style>
    .col{
    margin-inline:auto;
    }
    </style>
</head>
<body>
    <h1 style=margin-top:30px;><i class="fa-solid fa-user-tie"></i> Add Interviewer  </h1>
    <div id="container">
        <form action="/interview-scheduler/interviewer?action=edit-add" method="post">
            <div class="form">

           
            <div class="col">
                <div id="subcol1">
                    <label for="name">Name <span style="color: red;">*</span></label>
                    <label for="name">Email Address<span style="color: red;">*</span></label>
                    <label for="name">Skill<span style="color: red;">*</span></label>
                     <label for="name">Remarks<span style="color: red;">*</span></label>
                     
                </div>
                <div id="subcol2">
                
                    <input type="hidden" name="id" value="${interviewer.getInterviewerId() }">
                    <input type="text" value="${interviewer.getInterviewerName() }" name="name" required placeholder="name">
                    <input type="email" name="email" value="${interviewer.getInterviewerEmail() }" required placeholder="email">
                    
                   
                     <select value="${interviewer.getInterviewerSkill() }" name="skill" id="" aria-placeholder="skill" required>
                  <c:forEach items="${skills }" var="skill">
                  
                    <option value="${skill.getSkillId() }">${skill.getSkillDsec() }</option>
                    
                  </c:forEach>
                  </select>
                  <textarea value="${interviewer.getRemarks() }"  name="remarks" id="" cols="30" rows="10" required></textarea>
                </div>
            </div>
            
        </div>
            <button type="submit"> Submit</button>
        </form>
    </div>
</body>
</html>