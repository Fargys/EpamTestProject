<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit for team</title>
</head>
<body>
<h1>Edit for ${currentTeam.name}</h1>

<form action="${pageContext.request.contextPath}/team/update" method="post">
    <input type="hidden" name="id" value="${currentTeam.id}"><br/>
    Enter name:   <input type="text" name="name" required value="${currentTeam.name}"><br/>
    Enter games:  <input type="number" name="games" min="0" value="${currentTeam.games}"><br/>
    Enter wins:   <input type="number" name="wins" min="0" value="${currentTeam.wins}"><br/>
    Enter draws:  <input type="number" name="draws" min="0" value="${currentTeam.draws}"><br/>
    Enter losses: <input type="number" name="losses" min="0" value="${currentTeam.losses}"><br/>
    Enter scored: <input type="number" name="scored" min="0" value="${currentTeam.scored}"><br/>
    Enter missed: <input type="number" name="missed" min="0" value="${currentTeam.missed}"><br/>
    Enter points: <input type="number" name="points" min="0" value="${currentTeam.points}"><br/>
    <input type="hidden" name="champId" value="${currentChampionship.id}"><br/>
    <button type="submit">Edit</button>
</form>
</body>
</html>