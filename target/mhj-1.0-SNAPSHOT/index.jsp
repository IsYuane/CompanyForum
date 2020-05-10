<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工列表</title>
    <%
        //        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%--    web路径：--%>
    <%--    不以/开始的相对路径找资源，以当前的路径为基准，容易出错--%>
    <%--    以/开始的对路径找资源，以服务器的路径为进准(http://localhost:3306/项目名)=APP_PATH?--%>
    <%--    引入jquery--%>
    <script type="text/javascript" src="${APP_PATH}/static/jquery-1.11.3.min.js" charset="utf-8"></script>
    <%--    引入样式--%>
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${APP_PATH}/static/bootstrap/css/login.css" rel="stylesheet">
    <script charset="UTF-8" src="static/bootstrap/js/login.js"></script>
    <script src="${APP_PATH}/static/bootstrap/js/md5.min.js"></script>
</head>
<body style="background: #d9edf7">

<%--<nav class="navbar navbar-default">--%>

<%--    <div>--%>


<%--        <ul>--%>
<%--            <a></a>--%>
<%--        </ul>--%>

<%--    </div>--%>



<%--</nav>--%>



<div class="Chineseword">
    <br><br>
    <h1  style="color: #555555">
      <span>
            <i>公司交流平台</i><br>
          <hr>
      </span>
    </h1>
</div>

<div class="wrap">
    <div class="head-banner report-wrap-module report-scroll-module">
        <p>
            <img src="static/images/11.jpg" alt="Smiley face" width="400" height="200" ></p>
    </div>

    <div class="container">
        <div class="main_body">
            <br><br><br>
<%--            <h1><i>公司管理平台</i><br><h1>--%>
            <h2><img src="static/images/2.png" alt="Smiley face" width="50" height="50"> 登录</h2>
            <!--登录框-->

            <form  id="form_login" class="sign_in">
                <div class="form-group">
                    <!--<label for="exampleInputEmail1">用户名</label>-->
                    <input type="text" class="form-control" required name="userName" id="inputName" placeholder="用户名">
                    <span class="error"></span>
                </div>
                <div class="form-group">
                    <!-- <label for="exampleInputPassword1">密码</label>-->
                    <input type="password" class="form-control" required name="password" id="inputPassword" placeholder="密码">
                    <span class="error"></span>
                </div>
                <div class="checkbox">
                    <!--<label>-->
                    <!--<input type="checkbox" id="check">记住密码-->
                    <!--</label>-->
                </div>
<%--                <div class="fail_sign">--%>
<%--                    <!--<a class="forget_pas">忘记密码？</a>-->--%>
<%--                    <span class="line">|</span>--%>
<%--                    <a href="register.html" class="swi_sign">注册</a>--%>
<%--                </div>--%>
                <button type="button" class="btn btn-lg btn-primary btn-block" id="login_btn">登录</button>
            </form>
        </div>
    </div>
    <!--页脚 begin-->
</div>
<!--页脚 end-->
</body>
</html>
<%--<jsp:forward page="/emps"/>--%>