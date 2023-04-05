<%
	String message = (String) session.getAttribute("message");
	if(message != null){
%>
<div style="text-align:center; width:500px; margin:auto; background-color:green;"><%= message%></div>
<%
		session.removeAttribute("message");
	}
%>