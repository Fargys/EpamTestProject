<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Edit for championship</title></head>
<body>
<h1>Edit for ${currentTeam.name}</h1>

<form action="${pageContext.request.contextPath}/team/update" method="post">
    <input type="hidden" name="id" value="${currentTeam.id}"><br/>
    Enter name:   <input type="text" name="name" value="${currentTeam.name}"><br/>
    Enter games:  <input type="number" name="games" value="${currentTeam.games}"><br/>
    Enter wins:   <input type="number" name="wins" value="${currentTeam.wins}"><br/>
    Enter draws:  <input type="number" name="draws" value="${currentTeam.draws}"><br/>
    Enter losses: <input type="number" name="losses" value="${currentTeam.losses}"><br/>
    Enter scored: <input type="number" name="scored" value="${currentTeam.scored}"><br/>
    Enter missed: <input type="number" name="missed" value="${currentTeam.missed}"><br/>
    Enter points: <input type="number" name="points" value="${currentTeam.points}"><br/>

    <button type="submit">Edit</button>
</form>
</body>
</html>