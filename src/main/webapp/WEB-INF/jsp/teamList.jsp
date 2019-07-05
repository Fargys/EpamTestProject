<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Team list</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
    <h1>
        <a href="${pageContext.request.contextPath}/championship/list/"> ${currentChampionship.name} </a>
    </h1>

    <br/><br/>
    <div>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Games</th>
                <th>Wins</th>
                <th>Draws</th>
                <th>Losses</th>
                <th>Scored</th>
                <th>Missed</th>
                <th>Points</th>
            </tr>
            <c:forEach  items="${teams}" var ="team">
                <tr>
                    <td>${team.name}</td>
                    <td>${team.games}</td>
                    <td>${team.wins}</td>
                    <td>${team.draws}</td>
                    <td>${team.losses}</td>
                    <td>${team.scored}</td>
                    <td>${team.missed}</td>
                    <td>${team.points}</td>
                    <td><a href="${pageContext.request.contextPath}/team/edit/${team.id}"> Edit </a></td>
                    <td><a href="${pageContext.request.contextPath}/team/delete/${team.id}"> Delete </a></td>
                </tr>
            </c:forEach>
        </table>

        <br/><br/>

        <form action="${pageContext.request.contextPath}/team/play" method="post">

            <select name ="homeTeamId">
                <c:forEach items="${teams}" var="homeTeam">
                    <option value ="${homeTeam.id}">${homeTeam.name}</option>
                </c:forEach>
            </select>
            -
            <select name="guestTeamId">
                <c:forEach items="${teams}" var="guestTeam">
                    <option value ="${guestTeam.id}">${guestTeam.name}</option>
                </c:forEach>
            </select>
            <br/>

            Enter score - <input type="number" name="homeGoals" min="0" value="0">
            :<input type="number" name="guestGoals" min="0" value="0">
            <br/>

            <button type="submit">Play game</button>
        </form>
        <br/>

        <form action="${pageContext.request.contextPath}/team/create" method="post">
            Enter name:   <input type="text" name="name" required value="teamName"><br/>
            Enter games:  <input type="number" name="games" min="0" value="0"><br/>
            Enter wins:   <input type="number" name="wins" min="0" value="0"><br/>
            Enter draws:  <input type="number" name="draws" min="0" value="0"><br/>
            Enter losses: <input type="number" name="losses" min="0" value="0"><br/>
            Enter scored: <input type="number" name="scored" min="0" value="0"><br/>
            Enter missed: <input type="number" name="missed" min="0" value="0"><br/>
            Enter points: <input type="number" name="points" min="0" value="0"><br/>
            <input type="hidden" name="champId" value="${currentChampionship.id}" />

            <button type="submit">Create team</button>
        </form>

    </div>

</body>

</html>