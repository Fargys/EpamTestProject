<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Championships List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<h1>Championships List</h1>
<br/>

<div>
    <table>
        <tr>
            <th>Name</th>
            <th colspan="2">Actions</th>
        </tr>

        <c:forEach  items="${championships}" var ="championship">
            <tr>
                <td><a href="${pageContext.request.contextPath}/team/list/${championship.id}"> ${championship.name} </a></td>
                <td><a href="${pageContext.request.contextPath}/championship/edit/${championship.id}"> Edit </a></td>
                <td><a href="${pageContext.request.contextPath}/championship/delete/${championship.id}"> Delete </a></td>
            </tr>
        </c:forEach>

    </table>
</div>

<br/>

<form class="champ-create-form" action="${pageContext.request.contextPath}/championship/create" method="post">
    <fieldset>
        <label for="champName">Enter championship name:</label>
        <input type="text" name="name" id="champName" required>

        <input type="submit" class="btn" value="Create">
    </fieldset>
</form>

</body>

</html>