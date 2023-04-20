<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Edit for team</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Edit for ${currentTeam.name}</h1>

<form class="team-edit-form" action="${pageContext.request.contextPath}/team/update" method="post">
    <fieldset>
        <p><label for="teamName">Enter name:</label>
        <input type="text" name="name" id="teamName" required value="${currentTeam.name}"></p>

        <p><label for="games">Enter games:</label>
        <input type="number" name="games" id="games" min="0" value="${currentTeam.games}"></p>

        <p><label for="wins">Enter wins:</label>
        <input type="number" name="wins" id="wins" min="0" value="${currentTeam.wins}"></p>

        <p><label for="draws">Enter draws:</label>
        <input type="number" name="draws" id="draws" min="0" value="${currentTeam.draws}"></p>

        <p><label for="losses">Enter losses:</label>
        <input type="number" name="losses" id="losses" min="0" value="${currentTeam.losses}"></p>

        <p><label for="scored">Enter scored:</label>
        <input type="number" name="scored" id="scored" min="0" value="${currentTeam.scored}"></p>

        <p><label for="missed">Enter missed:</label>
        <input type="number" name="missed" id="missed" min="0" value="${currentTeam.missed}"></p>

        <label for="points">Enter points:</label>
        <input type="number" name="points" id="points" min="0" value="${currentTeam.points}">


        <input type="hidden" name="champId" value="${currentChampionship.id}" />
        <input type="hidden" name="id" value="${currentTeam.id}"><br/>

        <button type="submit" class="btn">Edit</button>
    </fieldset>
</form>
</body>
</html>