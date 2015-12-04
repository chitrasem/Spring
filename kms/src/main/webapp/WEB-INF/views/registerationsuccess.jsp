<%@ include file="/WEB-INF/views/base.jspf" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
    <div class="success">
        Confirmation message : ${success}
        <br>
        Would you like to <a href="<c:url value='/newUser' />">Add More Users</a>?
        <br/>
        Go to <a href="<c:url value='/admin' />">Admin Page</a> OR <a href="<c:url value="/logout" />">Logout</a>   
    </div>
     
</body>
</html>