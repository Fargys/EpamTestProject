<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Team list</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
    <h1>
        <a href="${pageContext.request.contextPath}/championship/list/"> ${currentChampionship.name} </a>
    </h1>

    <br/><br/>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Games</th>
                <th>Wins</th>
                <th>Draws</th>
                <th>Losses</th>
                <th>Scored</th>
                <th>Missed</th>
                <th>Points</th>
                <th colspan="2">Actions</th>
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

        <form class="play-game-form" action="${pageContext.request.contextPath}/team/play" method="post">
            <fieldset>
                <p>
                <label for="firstTeam">Choose home team:</label>
                <select name ="homeTeamId" id="firstTeam">
                    <c:forEach items="${teams}" var="homeTeam">
                        <option value ="${homeTeam.id}">${homeTeam.name}</option>
                    </c:forEach>
                </select>
                </p>

                <p>
                <label for="secondTeam">Choose guest team:</label>
                <select name="guestTeamId" id="secondTeam">
                    <c:forEach items="${teams}" var="guestTeam">
                        <option value ="${guestTeam.id}">${guestTeam.name}</option>
                    </c:forEach>
                </select>
                </p>


                <label for="homeGoals">Enter home goals:</label>
                <input type="number" name="homeGoals" id="homeGoals" min="0" value="0">

                <label for="guestGoals">Enter guest goals:</label>
                <input type="number" name="guestGoals" id="guestGoals" min="0" value="0">

                <button type="submit" class="btn">Play game</button>

            </fieldset>
        </form>

        <br/>

        <form class="team-create-form" action="${pageContext.request.contextPath}/team/create" method="post">
            <fieldset>
                <label for="teamName">Enter name:</label>
                <input type="text" name="name" id="teamName" required>

                <label for="games">Enter games:</label>
                <input type="number" name="games" id="games" min="0" value="0">

                <label for="wins">Enter wins:</label>
                <input type="number" name="wins" id="wins" min="0" value="0">

                <label for="draws">Enter draws:</label>
                <input type="number" name="draws" id="draws" min="0" value="0">

                <label for="losses">Enter losses:</label>
                <input type="number" name="losses" id="losses" min="0" value="0">

                <label for="scored">Enter scored:</label>
                <input type="number" name="scored" id="scored" min="0" value="0">

                <label for="missed">Enter missed:</label>
                <input type="number" name="missed" id="missed" min="0" value="0">

                <label for="points">Enter points:</label>
                <input type="number" name="points" id="points" min="0" value="0">

                <input type="hidden" name="champId" value="${currentChampionship.id}" />

                <button type="submit" class="btn">Create team</button>
            </fieldset>
        </form>

    </div>

</body>

</html>