<%--<%@ page isELIgnored="false" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: 78759
  Date: 2020/1/29
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <% String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        application.setAttribute("basePath", basePath);
    %>
    <%
        //        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <title>Title</title>
<%--    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${APP_PATH}/static/weblib/jquery/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${APP_PATH}/static/weblib/bootstrap/js/bootstrap.min.js"></script>
<%--    <script src="${APP_PATH}/static/js/base.js"></script>--%>
<%--    <script src="${APP_PATH}/static/js/filterurl.js "></script>--%>
</head>
<body>

<div class="table-responsive">
    <table class="table table-hover" id="histories_table">
        <thead>
        <tr>
            <td>文件名</td>
            <td>类型</td>
            <td>文件大小</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>

        </tbody>
<%--        <c:forEach items="${histories }" var="history">--%>
<%--            <tr id="${history.hid }">--%>
<%--                <td><p>${history.filepath}</p></td>--%>
<%--                <td><p class="linkcheck">${history.type}</p></td>--%>
<%--                <td><p><fmt:formatNumber value="${(history.filesize)/1024 }"--%>
<%--                                         maxFractionDigits="2"/>Kb</p></td>--%>
<%--                <td>--%>

<%--                    <button type="button" class="btn btn-danger"--%>
<%--                            onclick="del_button('${history.hid }')">删除--%>
<%--                    </button>--%>
<%--                    <button type="button" class="btn btn-primary"--%>
<%--                            onclick="down_button('${history.hid }')">下载--%>
<%--                    </button>--%>
<%--                    <button type="button" class="btn btn-success"--%>
<%--                            onclick="view_button('${history.hid }')">预览--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
    </table>
</div>
<script type="text/javascript">
    $(function () {
        show()
    })
    function show() {
        $.ajax({
            url:"${APP_PATH}/showHistories",
            type:"GET",
            success:function (result) {
                downList(result)
            }
        })
    }
    function downList(result) {
        $("#histories_table tbody").empty();
        var histories = result.extend.histories;
        var level=${sessionScope.employee.level};
        $.each(histories,function (index,item) {
            var p=renderSize(item.filesize);
            var fp=$("<td></td>").append(item.filepath);
            var ty=$("<td></td>").append(item.type);
            var fs=$("<td></td>").append(p);
            if(level==1){
                var FdelBtn = $("<button></button>")
            }else{
                var FdelBtn = $("<button disabled></button>")
            }
            var downBtn = $("<button></button>").addClass("btn btn-primary down_btn").append("下载");
            FdelBtn.addClass("btn btn-danger del_file_btn").append("删除");
            downBtn.attr("down-id",item.hid);
            FdelBtn.attr("del-file-id",item.hid);
            var btnTd = $("<td></td>").append(downBtn).append(" ").append(FdelBtn);
            $("<tr></tr>").append(fp)
                .append(ty)
                .append(fs)
                .append(btnTd)
                .appendTo("#histories_table tbody");
        })
    }
    function renderSize(value){
        if(null==value||value==''){
            return "0 Bytes";
        }
        var unitArr = new Array("Bytes","KB","MB","GB","TB","PB","EB","ZB","YB");
        var index=0,
            srcsize = parseFloat(value);
        index=Math.floor(Math.log(srcsize)/Math.log(1024));
        var size =srcsize/Math.pow(1024,index);
        //  保留的小数位数
        size=size.toFixed(2);
        return size+unitArr[index];
    }
    <%--function down_button(hid) {--%>
    <%--    window.open("${basePath }downFile?hid=" + hid, "_blank");--%>
    <%--}--%>
    $(document).on("click",".down_btn",function () {
        var hid = $(this).attr("down-id");
        window.open("${basePath }downfile?hid=" + hid, "_blank")
    });
    $(document).on("click",".del_file_btn",function () {
        var filename = $(this).parents("tr").find("td:eq(0)").text();
        var hid = $(this).attr("del-file-id");
        if(confirm("确认删除【"+filename+"】吗")){
            $.ajax({
                url:"${APP_PATH}/deleteFile/"+hid,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    show()
                }
            })
        }
    })
</script>
</body>
</html>
