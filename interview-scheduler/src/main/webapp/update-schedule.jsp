<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./jsp/app-details.css">
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Update Schedule</title>
    <style>
        .form #subcol1{
   
    gap: 30px;
}
.form #subcol2{
   
    gap: 30px;
}
form button{
    margin-top: 40px;
}
    </style>
</head>
<body>
    <h1 style=margin-top:30px;><i class="fa-solid fa-pen-to-square"></i> Update Schedule details  </h1>
    <div id="container">
        <form action="/interview-scheduler/interview?action=update" method="post">
            <div class="form">

           
            <div class="col">
                <div id="subcol1">
                    <label for="name">Name <span style="color: red;">*</span></label>
                    <label for="name">Email Address<span style="color: red;">*</span></label>
                    <label for="name">Highest Qualification<span style="color: red;">*</span></label>
                    <label for="name">Skill<span style="color: red;">*</span></label>
                     
                </div>
                <div id="subcol2">
                   
                    <input type="hidden" name="applId" value="${applicant.getApplicantId()}">
                    <input type="hidden" name="id" value="${schedule.getScheduleId()}">
                    <input type="text" name="name" value="${applicant.getApplicantName() }" required placeholder="name" readonly>
                    <input type="email" name="email" value="${applicant.getApplicantEmail() }" required placeholder="email" readonly>
                    
                    <input type="text" name="qualification" value="${applicant.getApplicantQualification() }" required placeholder="Qualification" readonly>
                     <input name="skill" type="text" value="${applSkill }"  required placeholder="skill" readonly>
                </div>
            </div>
            <div class="col">
                <div id="subcol1">
                   
                    <label for="name">Select Interviewer<span style="color: red;">*</span></label>
                    <label for="name">Status<span style="color: red;">*</span></label>
                    <label for="name">Select Date<span style="color: red;">*</span></label>
                    <label for="name">Time<span style="color: red;">*</span></label>
                    

                </div>
                <div id="subcol2">
                   
                  <!-- <c:forEach items="${skills }" var="skill">
                  
                    
                    
                  </c:forEach> -->
                  
                    <select name="interviewerId" id="" aria-placeholder="skill" required>
                        <c:forEach items="${interviewers }" var="interviewer">
                        
                          <option value="${interviewer.getInterviewerId() }">${interviewer.getInterviewerName() }</option>
                          
                        </c:forEach>
                        </select>
                    <select name="status" id="" aria-placeholder="skill" required>
                        <option value="scheduled">SCHEDULED</option>
                        <option value="completed">COMPLETED</option>
                        <option value="cancelled">CANCELLED</option>
                        </select>
                    <input type="date" value="${schedule.getScheduleDate() }" required placeholder="date" name="date">
                    <input type="time" value="${schedule.getScheduleTime() }" required placeholder="time" name="time">
                    

                </div>

            </div>
        </div>
            <button type="submit"> Submit</button>
        </form>
    </div>
</body>
</html>