<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <%
        //        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <c:if test="${sessionScope.employee.level == 1}">
                <a class="navbar-brand" href="${APP_PATH}/emps">员工管理</a>
                </c:if>
                <c:if test="${sessionScope.employee.level == 0}">
                    <a class="navbar-brand" href="${APP_PATH}/emps">论坛</a>
                </c:if>
            </div>
            <div>

                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left">
                    <li <c:if test="${tab.tabNameEn == 'tech'}">
                            class="active" </c:if>> <a href="${APP_PATH}/topic/tech">技术</a>
                    </li>
                    <li <c:if test="${tab.tabNameEn == 'play'}">class="active"
                        </c:if>><a href="${APP_PATH}/topic/play">娱乐</a></li>
                    <li <c:if test="${tab.tabNameEn == 'a'}">class="active"
                        </c:if>><a href="${APP_PATH}/topic/a">项目A组</a></li>
                    <li <c:if test="${tab.tabNameEn == 'b'}">class="active"
                         </c:if>><a href="${APP_PATH}/topic/b">项目B组</a></li>
                    <li <c:if test="${tab.tabNameEn == 'c'}">class="active"
                        </c:if>><a href="${APP_PATH}/topic/c">项目C组</a></li>

                </ul>
                   <!--已登陆-->
                <ul class="nav navbar-nav navbar-right">

                    <li>
                        <p class="navbar-text"><a href="#">${sessionScope.employee.empName}</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="javascript:signout_confirm();">登出</a></p>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


</header>
<script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="${APP_PATH}/logOut";
        }
        else
        {

        }
    }
</script>