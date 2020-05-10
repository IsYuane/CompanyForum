<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta name="Content-Type"  content="text/html;charset=utf-8">
    <meta name="keywords" content="mhj,论坛,公司,程序员">
    <title>mhj - 基于SSM的公司交流平台  </title>
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
    <script src="${APP_PATH}/static/js/filterurl.js "></script>
    <style>
        li {list-style-type:none;}
        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
            background: #f0f2f5;
        }
        .footer {
            background-color: #fff;
            margin-top: 22px;
            margin-bottom: 22px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 200px;
            border: 1px ;
            clear:both
        }

        .container {
            margin-right: 5%;
            margin-left: 5%;
            padding-left: 15px;
            padding-right: 15px;
            width: 40%;
            float: left;
        }
        .info {
            margin-right: 5%;
            width: 10%;
            float: left;
        }
        a{
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp"%>

<div class="panel panel-default" id="main" style="width: 70%;margin:1% 2% 5% 5%;float: left;">
    <div class="panel-heading" style="background-color: white">
        <p>mhj</p>
    </div>

<ul class="list-group" style="width: 100%">
    <c:forEach items="${topics}" var="topic">
        <li class="list-group-item">
            <div style="height: 50px">
                <div style="float: left;width: 6%;margin-bottom: 5px">
                    <img width="50px" height="50px" src="${APP_PATH}/static/images/avatar/cat.png" class="img-rounded">
                </div>
                <div style="width: 89%;float: left">
                    <a href="${APP_PATH}/t/${topic.id}">${topic.title}</a><br/>
                    <div>
                        <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                        <a><span ><strong>${topic.employee.empName}</strong></span></a>
                        <small class="text-muted">${topic.localCreateTime}</small>
                    </div>
                </div>
                <div style="width: 5%;float: right;text-align: center">
                    <span class="badge">${topic.countReplies}</span>
                </div>
            </div>
        </li>
    </c:forEach>

</ul>

</div>


<div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        <blockquote>
            Mhj
            <small>基于SSM的公司交流平台</small>
        </blockquote>
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item"><a href="${APP_PATH}/new">创作新主题</a></li>
        <li class="list-group-item">
            <div>

                <button type="button" id="upfilebutton_id" class="btn btn-primary btn-block"
                        data-toggle="modal" data-remote="${APP_PATH}/jsp/upfileui.jsp" data-target=".bs-modal-lg" style="position:relative; bottom: 3px !important;">上传文件
                </button>
                <button type="button" id="upfilebutton_id2" class="btn btn-default btn-block"
                        data-toggle="modal" data-remote="${APP_PATH }/jsp/down.jsp" data-target=".bs-modal-lg" style="position:relative; bottom: 3px !important;">查看资源
                </button>
            </div>
            <div>
                <div class="alert alert-danger alert-dismissible fade in hidden" role="alert" id="alert_id">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>与服务器交互数据失败！</strong> 请检查网络连接并重新选择文件归类！
                </div>
                <div class="modal fade bs-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content"></div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</div>
</body>
</html>