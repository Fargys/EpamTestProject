<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Championships List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<h1>Championships List</h1>

<br/><br/>
<div>
    <table border="1">

        <tr>
            <th>Championship name</th>
        </tr>
        <jsp:useBean id="championships" scope="request" type="java.util.List"/>
        <c:forEach  items="${championships}" var ="championship">
            <tr>
                <td><a href="${pageContext.request.contextPath}/team/list/${championship.id}"> ${championship.name} </a></td>
                <td><a href="${pageContext.request.contextPath}/championship/edit/${championship.id}"> Edit </a></td>
                <td><a href="${pageContext.request.contextPath}/championship/delete/${championship.id}"> Delete </a></td>
            </tr>
        </c:forEach>

    </table>

    <br/><br/>

    <form action="${pageContext.request.contextPath}/championship/create" method="post">
        Enter name: <input type="text" name="name" value="Name">
        <button type="submit">Create</button>
    </form>

</div>
</body>

</html>