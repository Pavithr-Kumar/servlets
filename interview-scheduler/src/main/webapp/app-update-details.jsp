<%@ include file="navbar.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./jsp/app-details.css">
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <title>Update Details</title>
</head>
<body>
    <h1 style=margin-top:30px;><i class="fa-solid fa-pen"></i> Update Applicant Details  </h1>
    <div id="container">
        <form action="/interview-scheduler/applicant?action=edit-add" method="post">
            <div class="form">

           
            <div class="col">
                <div id="subcol1">
                    <label for="name">Name <span style="color: red;">*</span></label>
                    <label for="name">Email Address<span style="color: red;">*</span></label>
                    <label for="name">Highest Qualification<span style="color: red;">*</span></label>
                    <label for="name">Stream<span style="color: red;">*</span></label>
                     
                </div>
                <div id="subcol2">
                    <input type="hidden" name="id" value="${applicant.getApplicantId()}">
                    <input type="text" value="${applicant.getApplicantName()}" name="name" required placeholder="name">
                    <input type="email" value="${applicant.getApplicantEmail()}"  name="email" required placeholder="email">
                    
                    <input type="text" value="${applicant.getApplicantQualification()}" name="qualification" required placeholder="Qualification">
                    <input type="text" value="${applicant.getAppEducatStream()}" name="stream" required placeholder="stream">

                </div>
            </div>
            <div class="col">
                <div id="subcol1">
                    <label for="name">Skill<span style="color: red;">*</span></label>
                    <label for="name">Aggregate Percentage<span style="color: red;">*</span></label>
                    <label for="name">Phone Number<span style="color: red;">*</span></label>
                    <label for="name">Remarks</label>
                    

                </div>
                <div id="subcol2">
                  <select name="skill" id="" aria-placeholder="skill" required>
                  <c:forEach items="${skills }" var="skill">
                  
                    <option value="${skill.getSkillId() }">${skill.getSkillDsec() }</option>
                    
                  </c:forEach>
                  </select>
                    <input name="percentage" value="${applicant.getApplicantAggrePercentage()}" type="text"  required placeholder="percentage">
                    <input name="phone" value="${applicant.getApplicantPhNo()}" type="tele" required placeholder="phone">
                    <textarea  name="remarks" value="${applicant.getApplicantRemarks()}" id="" cols="30" rows="10" required></textarea>
                    

                </div>

            </div>
        </div>
            <button type="submit"> Update</button>
        </form>
    </div>
</body>
</html>