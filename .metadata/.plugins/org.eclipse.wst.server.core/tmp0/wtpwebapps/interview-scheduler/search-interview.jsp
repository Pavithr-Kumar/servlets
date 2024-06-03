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
    form button{
    margin-top:30px;
    }
    </style>
</head>
<body>
    <h1 style=margin-top:30px;><i class="fa-solid fa-magnifying-glass"></i> Search Scheduled Interview Details  </h1>
    <div id="container">
        <form action="/interview-scheduler/interview?action=search" method="post">
            <div class="form">

           
            <div class="col">
                <div id="subcol1">
                    <label for="name">Applicant Name </label>
                    <label for="name">Interviewer Name</label>
                    <label for="name">From Date</label>
                     <label for="name">To Date</label>
                     
                </div>
                <div id="subcol2">
                
                   
                    <input type="text"  name="applName"  placeholder=" applicant name">
                    <input type="text"  name="interName"  placeholder="interviewer name">
                    <input type="date" style=cursor:pointer name="fromDate"  placeholder=" from date">
                    <input type="date" style=cursor:pointer name="toDate"  placeholder=" to date">
                    
                   
                    
                </div>
            </div>
            
        </div>
            <button type="submit"> Search</button>
        </form>
    </div>
</body>
</html>