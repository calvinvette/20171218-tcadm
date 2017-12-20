<%@page import="com.triveratech.jee.*,java.util.*"%>

<% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>

<table>
<% for (Customer c: customers) { %>
	<tr>
		<td><%=c.getCustomerId()%></td>
		<td><%=c.getFirstName()%></td>
		<td><%=c.getLastName()%></td>
		<td><%=c.getPhoneNumber()%></td>
		<td><%=c.getEmail()%></td>
	</tr>
<% } %>
</table>
