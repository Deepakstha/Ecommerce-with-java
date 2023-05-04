<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Fullname</th>
			<th>Phone Number</th>

		</tr>
		<c:forEach var="st" items="${categoryList}">
			<tr>
				<td><c:out value="${st.categoryId}"></c:out></td>
				<td><c:out value="${st.categoryTitle}"></c:out></td>
				<td><c:out value="${st.categoryDesc}"></c:out></td>
	
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>