<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019/8/19
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>公司交流平台</title>
    <%
//        pageContext.setAttribute("APP_PATH",request.getContextPath());
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%--    web路径：--%>
    <%--    不以/开始的相对路径找资源，以当前的路径为基准，容易出错--%>
    <%--    以/开始的对路径找资源，以服务器的路径为进准(http://localhost:3306/项目名)=APP_PATH?--%>
    <%--    引入jquery--%>
<%--    <script type="text/javascript" src="${APP_PATH}/static/jquery-1.11.3.min.js" charset="utf-8"></script>--%>
    <%--    引入样式--%>
<%--    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>--%>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${APP_PATH}/weblib/jquery/jquery-3.2.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${APP_PATH}/weblib/bootstrap/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/js/base.js"></script>
    <script src="${APP_PATH}/js/filterurl.js "></script>

</head>
<body>
<header>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <a class="navbar-brand" href="${APP_PATH}/topic">论坛</a>
            </div>
            <div>
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

<%--员工更新模态框--%>
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工更新</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="empName_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@mhj.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">userName</label>
                        <div class="col-sm-10">
                            <input type="text" name="userName" class="form-control" id="userName_update_input" placeholder="修改用户名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">password</label>
                        <div class="col-sm-10">
                            <input type="text" name="password" class="form-control" id="password_update_input" placeholder="修改密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender"  value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">department</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId" id="emp_dept_update_select">
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%--员工增加模态框--%>
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@mhj.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">userName</label>
                        <div class="col-sm-10">
                            <input type="text" name="userName" class="form-control" id="userName_add_input" placeholder="用于进行登录的账户">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">password</label>
                        <div class="col-sm-10">
                            <input type="text" name="password" class="form-control" id="password_add_input" placeholder="用于进行登录的密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">department</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId" id="emp_dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<div class="container">
    <%--    标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>公司交流平台——员工管理</h1>
        </div>
    </div>
    <%--    按钮--%>
    <div class="row">
        <div class="col-md-8 col-md-offset-8">
            <div>
                <button class="btn btn-primary" id="emp_add_modal_btn" style="position:relative; bottom: 3px !important;">新增</button>
                <button class="btn btn-danger" id="emp_delete_all_btn" style="position:relative; bottom: 3px !important;">删除</button>
                <button type="button" id="upfilebutton_id" class="btn btn-primary"
                        data-toggle="modal" data-remote="${APP_PATH}/jsp/upfileui.jsp" data-target=".bs-modal-lg" style="position:relative; bottom: 3px !important;">上传文件
                </button>
                <button type="button" id="upfilebutton_id2" class="btn btn-primary"
                        data-toggle="modal" data-remote="${basePath }jsp/down.jsp" data-target=".bs-modal-lg" style="position:relative; bottom: 3px !important;">查看资源
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
        </div>
    </div>
    <%--    显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th><input type="checkbox" id="check_all"/></th>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>departName</th>
                    <th>操作</th>
                </tr>
                </thead>
               <tbody>

               </tbody>
            </table>
        </div>

    </div>
    <%--    分页信息--%>
    <div class="row">
        <div class="col-md-6" id="page_info_area">
        </div>
        <div class="col-md-6" id="page_nav_area">
        </div>
    </div>
</div>

<script type="text/javascript">
    var totalRecord,currentPage;
    $(function () {
        to_page(1);
    });
    function to_page(pn){
        $.ajax({
            url:"${APP_PATH}/emps.do",
            data:"pn="+pn,
            type:"GET",
            dataType:"json",
            success:function (result) {
                // console.log(result);
                // 1、解析并显示员工数据
                bulid_emps_table(result);
                // 2、解析并显示分页信息
                bulid_page_info(result);
                bulid_page_nav(result);
            }
        });
    }
    function bulid_emps_table(result){
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            var genderTd = $("<td></td>").append(item.gender=="M"?"男":"女");
            var emailTd = $("<td></td>").append(item.email);
            var departmentTd = $("<td></td>").append(item.department.deptName);
            //     <button class="btn btn-primary btn-sm">
            //     <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            // 编辑</button>
            // <button class="btn btn-danger btn-sm">
            //     <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
            // 删除</button>
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editBtn.attr("edit-id",item.empId);
            if(item.level==0){
                var delBtn = $("<button></button>")
            }else{
                var delBtn = $("<button disabled></button>")
            }
            delBtn.addClass("btn btn-danger btn-sm del_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");

            delBtn.attr("del-id",item.empId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(checkBoxTd)
                .append(empIdTd)
                .append(empNameTd)
                .append(genderTd)
                .append(emailTd)
                .append(departmentTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");
        })
    }
    // 解析显示分页信息
    function bulid_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前页数："+result.extend.pageInfo.pageNum+"页,总页数："+
            result.extend.pageInfo.pages+"页，总记录："+result.extend.pageInfo.total+"条");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    // 解析显示分页条
    function  bulid_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if(result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            firstPageLi.click(function(){
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        if(result.extend.pageInfo.hasNextPage==false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function(){
                to_page(result.extend.pageInfo.pageNum+1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if(result.extend.pageInfo.pageNum==item){
                numLi.addClass("active");
            }
            numLi.click(function(){
                to_page(item);
            });
            ul.append(numLi);
        });
        ul.append(nextPageLi).append(lastPageLi);
        var nav = $("<nav></nav>");
        nav.append(ul);
        nav.appendTo("#page_nav_area");
    }
    //表单重置
    function reset_form(ele){
        $(ele)[0].reset();
        $(ele).find("*").removeClass("has-success has-error");
        $(ele).find(".help-block").text("");
    }
    $("#emp_add_modal_btn").click(function () {
        // 表单数据 样式重置
        reset_form("#empAddModal form");
        // $("#empAddModal form")[0].reset();
        getDepts("#empAddModal select");
        //掉出模态框
        $('#empAddModal').modal({
            backdrop:"static"
        });
    });
    // 获取部门名
    function getDepts(ele) {
        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function(result){
                $(ele).empty();
                //{"code":100,"msg":"处理成功",
                // "extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
                // console.log(result);
                // 将信息显示在模态框下拉列表中
            //   #emp_dept_add_select
                $.each(result.extend.depts,function (index,item) {
                    $("<option></option>").append(item.deptName).attr("value",item.deptId).appendTo(ele);
                });
            }
        });
    }
    // 员工新增校验
    function validate_add_form(){
        // 获取用户名
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16})|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(empName)){
            show_validate_msg("#empName_add_input","error","用户名必须是2到5位中文或6到16位英文");
            return false;
        }else{
            show_validate_msg("#empName_add_input","success","");
        }
        checkUser();
        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            show_validate_msg("#email_add_input","error","邮箱格式错误");
            return false;
        }else{
            show_validate_msg("#email_add_input","success","");
        }
        return true;
    }
    function show_validate_msg(ele,status,msg){
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error"==status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }
    $("#empName_add_input").change(function () {
        checkUser();
    });
    function checkUser(){
        $.ajax({
            url:"${APP_PATH}/checkUser",
            data:"empName="+$("#empName_add_input").val(),
            type:"POST",
            success:function (result) {
                if(result.code==100){
                    show_validate_msg("#empName_add_input","success","用户合法");
                    $("#emp_save_btn").attr("ajax-va","success");
                }else{
                    show_validate_msg("#empName_add_input","error",result.extend.va_msg);
                    $("#emp_save_btn").attr("ajax-va","error");
                }
            }
        });
    }
    // 员工增加
    $("#emp_save_btn").click(function () {
        // 新增之前进行用户名和邮箱校验
        if(!validate_add_form()){
            return false;
        }
        if($(this).attr("ajax-va")=="error"){
            return false;
        }
        $.ajax({
           url:"${APP_PATH}/emp",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function (result) {
               if(result.code==200){
                   // console.log(result);显示失败信息
                   // alert(result.extend.FieldErrors.email);
                   // alert(result.extend.FieldErrors.empName);
                   if(undefined != result.extend.FieldErrors.email){
                       show_validate_msg("#email_add_input","error",result.extend.FieldErrors.email);
                   }
                   if(undefined != result.extend.FieldErrors.empName){
                       show_validate_msg("#empName_add_input","error",result.extend.FieldErrors.empName);
                   }
               }else{
                   // 隐藏模态框 跳到最后一页增加的员工上
                   $("#empAddModal").modal('hide');
                   to_page(totalRecord);
               }

            }
        });
    });

//    员工编辑按钮添加事件
    $(document).on("click",".edit_btn",function () {
        reset_form("#empUpdateModal form");
        //1、获取部门信息
        getDepts("#empUpdateModal select");
        // 2、获取员工信息
        getEmp($(this).attr("edit-id"));
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal({
            backdrop:"static"
        });
    });
    // 获取员工信息
    function getEmp(id) {
        $.ajax({
            url:"${APP_PATH}/emp/"+id,
            type:"GET",
            success:function (result) {
                // console.log(result);
                $("#empName_update_static").text(result.extend.emp.empName);
                $("#email_update_input").val(result.extend.emp.email);
                $("#empUpdateModal input[name=gender]").val([result.extend.emp.gender]);
                $("#empUpdateModal select").val([result.extend.emp.dId]);
            }
        });
    }
    $("#emp_update_btn").click(function () {

        var email = $("#email_update_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            show_validate_msg("#email_update_input","error","邮箱格式错误");
            return false;
        }else{
            show_validate_msg("#email_update_input","success","");
        }
        $.ajax({
            url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
            type:"PUT",
            data:$("#empUpdateModal form").serialize(),
            // type:"POST",
            // data:$("#empUpdateModal form").serialize()+"&_method=PUT",
            success:function (result) {
                // alert(result.msg);
                $("#empUpdateModal").modal("hide");
                to_page(currentPage);
            }
        });
    });
    // 单个员工删除
    $(document).on("click",".del_btn",function () {
        var empName = $(this).parents("tr").find("td:eq(2)").text();
        var empId = $(this).attr("del-id");
        if(confirm("确认删除【"+empName+"】吗")){
            $.ajax({
                url:"${APP_PATH}/emp/"+empId,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    to_page(currentPage);
                }
            });
        }
    });
    // 完成全选全不选功能
    $("#check_all").click(function () {
        // 使用attr获取checked会出现undefined
        // alert($(this).attr("checked"));
        // 我们dom原生的属性：attr获取自定义属性的值
        // prop修改和读取原生属性的值
        // alert($(this).prop("checked"));
        $(".check_item").prop("checked",$(this).prop("checked"));
    });
    $(document).on("click",".check_item",function () {
        var flag = $(".check_item:checked").length ==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });
    $("#emp_delete_all_btn").click(function () {
        // $(".check_item:checked").parents("tr").find("td:eq(2)")
        var empNames = "";
        var ids = "";
        $.each($(".check_item:checked"),function () {
            empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
            ids += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        empNames = empNames.substring(0,empNames.length-1);
        ids = ids.substring(0,ids.length-1);
        if(confirm("确认删除【"+empNames+"】吗")){
            $.ajax({
                url:"${APP_PATH}/emp/"+ids,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    to_page(currentPage);
                    $("#check_all").prop("checked",false);
                }
            })
        }
    });
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
</body>
</html>
