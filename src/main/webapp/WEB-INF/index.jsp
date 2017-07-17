<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 15.07.17
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>home</title>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>

    <%--JavaScript refer --%>
    <script><%@include file="/WEB-INF/js/add_task.js" %></script>
    <script><%@include file="/WEB-INF/js/get_all_task.js" %></script>

</head>
<body>
    <form id="result_from_server">
        <input name="data" type="text">
        <input type="submit" value="send">
    </form>

    <div id="resp"></div>

    <div>
        <input id="get_all_task_but" type="button" value="Get all task" />
        <ul id="all_tasks">

        </ul>
    </div>
</body>
</html>
