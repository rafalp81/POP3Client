<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
Bienvenido, haga login<br/>

<form action="Control?ACTION_ID=LOGIN" method="post">
<input type="text" name="USER"><br/>
<input type="text" name="PASS"><br/>
<input type="submit" value="login"><br/>

</form>

<br/>
<%

	String error = (String)request.getAttribute("ERROR_MSG");
	if (error != null){
		out.println(error);
	}
%>

</body>
</html>