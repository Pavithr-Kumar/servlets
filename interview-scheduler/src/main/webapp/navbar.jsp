
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<script src="https://kit.fontawesome.com/9dc55b3f56.js" crossorigin="anonymous"></script>
<style>
*{
    padding: 0;
    margin: 0;
    font-family: sans-serif;
}
nav{
    background:linear-gradient(45deg,rgb(70, 70, 248),rgb(130, 186, 238));
    padding:20px 32px;
    display: flex;
    justify-content:space-around;
    align-items: center;
    gap: 70px;
    box-shadow: 0px 0px 10px black;
    position: sticky;
    top: 0;
}
nav>div >a{
    color: white;
    text-decoration: none;
    font-size: 18px;
    font-weight: 600;

}
nav>a:hover{
    color: black;
    
}
nav>img{
    background-color: blue;
    z-index: 1000;
}
a{
    transition: all 0.5s;
}
a:hover{
 transform: scale(1.1);
 text-shadow: 0px 0px 20px black;
}
i:hover{
 transform: scale(1.1);
 text-shadow: 0px 0px 5px gray;
}

</style>
</head>
<body>
<nav>
    <div>

        <a href="/interview-scheduler/index.jsp" style="font-family: cursive;font-size: 36px;">ZISA</a>
    </div>
    <div style="display: flex; gap: 50px;">

        <a href="/interview-scheduler/index.jsp">Home</a>
        <a href="/interview-scheduler/skills.jsp">Skills</a>
        <a href="/interview-scheduler/applicants.jsp">Applicants</a>
        <a href="/interview-scheduler/interviewer.jsp">Interviewers</a>
        <a href="/interview-scheduler/interviews.jsp">Schedule Interviews</a>
    </div>
        <div>

            <a id="logout" href="/interview-scheduler/login?logout=true"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
        </div>
    </nav>

</body>
</html>