<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%
        //        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
<%--    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${APP_PATH}/static/weblib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${APP_PATH}/static/weblib/jquery/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${APP_PATH}/static/weblib/bootstrap/js/bootstrap.min.js"></script>
    <title>${topic.title} - mhj </title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp"%>
<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <div>
            <div class="panel-heading" style="background-color: white">
                mhj › 主题
            </div>
            <h3>${topic.title}</h3><br/>
            <div>
                <a href="#"><span ><strong>${topic.employee.empName}</strong></span></a>&nbsp;&nbsp;
                <small class="text-muted">${topic.localCreateTime}</small>&nbsp;&nbsp;
            </div>
        </div>

        <div style="float: right;margin-top: -100px" >
            <img width="50px" height="50px" src="${APP_PATH}/static/images/avatar/cat.png" class="img-rounded">
        </div>
    </div>

    <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                ${topic.content}
            </li>
    </ul>
</div>


<c:if test="${!empty replies}">
<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        <span>
                ${fn:length(replies)} 回复  |  直到 <c:forEach items="${replies}" var="reply" varStatus="status">

<c:if test="${status.last}">
    ${reply.createTime}
    </c:if>
    </c:forEach>
        </span>
    </div>

    <ul class="list-group" style="width: 100%">
        <!-- 遍历评论 -->
        <c:forEach items="${replies}" var="reply">
        <li class="list-group-item">
            <div style="height: 50px">
                <div style="float: left;width: 6%;margin-bottom: 5px">
                    <img width="50px" height="50px" src="${APP_PATH}/static/images/avatar/cat.png" class="img-rounded">
                </div>
                <div style="width: 89%;float: left">
                    <a href="#"><strong>${reply.employee.empName}</strong></a>&nbsp;&nbsp;
                    <small class="text-muted">${reply.createTime}</small>
                    <br/>
                    <div>
                        <p>${reply.content}</p>
                    </div>
                </div>
            </div>
        </li>
        </c:forEach>

    </ul>
</div>
</c:if>

<c:if test="${!empty employee}">

<div class="panel panel-default" id="main" style="">
    <div class="panel-heading" style="background-color: white">
        添加一条新回复
    </div>
    <div class="panel-body">
        <div class="form-group">
            <form action="${APP_PATH}/reply" method="post">
                <input type="hidden" name="topicId" value="${topic.id}">
                <input type="hidden" name="replyEmpId" value="${employee.empId}">
                <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/>
            <input type="submit" class="btn btn-default btn-sm" value="回复">
            </form>
        </div>

    </div>
</div>
</c:if>

</div>
<div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        回复提示
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item">
            <p>
               请文明回帖，不要争吵，严禁在技术贴下面水贴^_^，如有发现，严惩不贷
            </p>
        </li>

    </ul>
</div>
<div class="panel panel-default" id="sidebar1" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <img src="${APP_PATH}/static/images/3.jpg" class="img-rounded"  width="305px" height="250px">
</div>

</body>
</html>