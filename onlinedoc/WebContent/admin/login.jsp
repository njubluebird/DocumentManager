<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文献管理系统</title>
	<script type="text/javascript">
		<% if(session.getAttribute("username")!=null){%>
				window.location.href="./admin/search.jsp"
		<%}%>
	</script>

    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/login.css">
</head>
<body>

<jsp:include page="topbar.jsp"></jsp:include>
<div class="container">
    <div id="rstext">
    <%
		String message=null;
		if((message=(String)request.getAttribute("message"))!=null)
			out.println(message);
	%>
    </div>
    <form action="login" method="post" class="well"  onsubmit="return checkform();">
        <h3>系统登录</h3>
        <label>用户名:</label>
        <input type="text" name="username" value="" id="username"class="span3"/>
        <label>密码：</label>
        <input type="password" name="password" value="" id="password"  class="span3" /> <br/>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</div>

<div class="row" id="footer">
    <div class="span6 offset5" >
        文献管理系统<br />
        <div>
            <a>关于</a>     <a>问题反馈</a>   <a>版本变更记录</a> 
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=ctx%>/admin/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=ctx%>/admin/js/bootstrap.min.js"></script>
<script>
    function checkform(){  //Check if the form is blank
        var rstext = "";
        var username = $("#username").val();
        var password = $("#password").val();
        if(username=="")
            rstext = "请输入用户名";
        else if(password=="")
            rstext = "请输入密码";
        
        if(rstext=="")	return true;
        else{
            $("#rstext").html(rstext);
            return false;
        }
    }
</script>
</html>
