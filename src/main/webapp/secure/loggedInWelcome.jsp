<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome!</h1>

Welcome, <%= request.getUserPrincipal().getName().toString() %>, to Weasley's Wizarding Wheezes!

<h6>
You are able to view this page because you are authenticated user.
</h6>


</body>
</html>
