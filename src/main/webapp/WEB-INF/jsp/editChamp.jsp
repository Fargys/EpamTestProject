<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Edit for championship</title></head>
<body>
<h1>Edit for ${currentChampionship.name}</h1>

<form action="${pageContext.request.contextPath}/championship/update" method="post">
    <input type="hidden" name="id" value="${currentChampionship.id}">
    Enter name: <input type="text" name="name" value="${currentChampionship.name}">
    <button type="submit">Edit</button>
</form>
</body>
</html>