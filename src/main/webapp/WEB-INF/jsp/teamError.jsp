<html>
<head>
    <title>Error</title>
</head>

<body>
<h1>${message}</h1>

<form action="${pageContext.request.contextPath}/team/list/${currentChampionship.id}" method="GET">
    <button type="submit">OK</button>
</form>
</body>
</html>