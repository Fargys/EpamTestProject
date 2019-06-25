<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Edit for championship</title></head>
<body>
<h1>Edit for ${currentTeam.name}</h1>

<form action="${pageContext.request.contextPath}/team/update/${currentTeam.id}" method="post">
    Enter name: <input type="text" name="newName" value="">
    <button type="submit">Edit</button>
</form>
</body>
</html>