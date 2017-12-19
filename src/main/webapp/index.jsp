<%@page import="java.util.*"%>
<html>
<body>
<h2>Hello World!</h2>
(From JSP)

<br/>
<a href="UserForm.html">User Form</a>
<br/>
<a href="CustomerRegistrationForm.html">Customer Registration Form</a>


<table>
<%
 int numCusts = 10;
 for (int i = 0; i < numCusts; i++) {
	%>
	<tr><td><%=(i + 1)%> </td><td> Customer Number: <%=i%> </td></tr>
	<%
 }
%>
</table>

rendered @: <%=new Date()%>

</body>
</html>
