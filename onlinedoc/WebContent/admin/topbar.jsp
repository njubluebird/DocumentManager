<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="navbar navbar-static">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="#">文献管理系统</a>
            <ul class="nav">
                <li>
                    <a href="#">文献录入</a>
                </li>
                <li>
                    <a href="#">文献搜索</a>
                </li>
                <li>
                    <a href="#">用户统计</a>
                </li>
                <li>
                    <a href="#">个人文献</a>
                </li>
            </ul>
            <ul class="nav pull-right">
            	<% 
            	String path = request.getContextPath();
				String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            		if(session.getAttribute("username") != null){
            			String rs = "<li><a id='login' href='#'>"+session.getAttribute("username")+"</a></li>";
            			rs += "<li><a href='"+ctx+"login?action=out'>退出</a></li>";
            			out.println(rs);
            		}else{
            			out.println("<li><a id='login' href='#'>登录</a></li>");
            		}
            	%>
            </ul>
        </div>
    </div>
</div>
