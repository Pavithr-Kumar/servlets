<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./jsp/index.css">
    <title>Home</title>
</head>
<body>
   <h1 style=margin:80px>Welcome to <span style=color:orange>Zettamine</span> Interview Scheduler</h1>
    
    <main>
        <a href="skills.jsp" style="color:red">
        
                <i class="fa-brands fa-slack"></i>
                Add Skills
            
        </a>
        <a href="/interview-scheduler/applicant?action=load" style="color:green">
        
            <i class="fa-solid fa-user"></i>
               Applicants
            
        </a>
        <a href="/interview-scheduler/interviewer?action=load" style="color:blue">
        
                <i class="fa-solid fa-user-tie"></i>
                Interviewers
            
        </a>
        <a href="interviews.jsp" style="color:orange">
        
                <i class="fa-solid fa-calendar-days"></i>
            <span style="margin-left:20px">Interviews Scheduled</span>    
            
        </a>
        
    </main>
</body>
</html>