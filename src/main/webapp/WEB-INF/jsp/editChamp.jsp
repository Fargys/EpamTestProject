<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Edit for championship</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<h1>Edit for ${currentChampionship.name}</h1>

<form class="champ-edit-form" action="${pageContext.request.contextPath}/championship/update" method="post">

    <input type="hidden" name="id" value="${currentChampionship.id}">

    <fieldset>
        <label for="newName">Enter name:</label>
        <input type="text" name="name" id="newName" required value="${currentChampionship.name}">

        <input type="submit" class="btn" value="Edit">
    </fieldset>
</form>

</body>
</html>