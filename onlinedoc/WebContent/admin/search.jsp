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

    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=ctx%>/admin/css/search.css">
</head>
<body> 
<jsp:include page="topbar.jsp"></jsp:include>
<div class="container">
                                      <!-- class="well" -->
    <form action="" method="post" onsubmit="checkform()">
        <div id="precise" class="span6" style="display: none">
            <div class="preitem">
                  <div id="prebutton" class="btn-small">_</div>
            </div>
            <div class="preitem">
                <span>作者Author:</span><input type="text" class="preinput" name="author"/>
            </div>
            <div class="preitem">
                <span>出版社Publisher:</span><input type="text" class="preinput" name="publisher"/>
            </div>
            <div class="preitem">
                <span>在此期间发表Time:</span>
                    <input type="text" class="span1" id="starttime" name="starttime"/>--<input type="text" class="span1" name="endtime"/>例如1997
            </div>
        </div>

        <div id="search">
            <h1 id="logo">文献<span>manager</span></h1>
            <input type="text" name="keyword" value="" id="keyword"  class="span5">
            <div type="submit" class="btn btn-primary">搜索</div>
            <div type="submit" class="btn btn-primary" id="seabutton">精确搜索</div>
        </div>
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
    $("#prebutton").click(function(){
        $("#precise").hide(400,function(){
            $("#search").show(800);
        });
    });

    $("#seabutton").click(function(){
        $("#search").hide(400,function(){
            $("#precise").show(800);
        });
    });


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
