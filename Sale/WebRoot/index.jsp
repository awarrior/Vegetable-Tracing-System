<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>销售</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="scripts.js"></script>
  </head>
  
  <body class="body" onload="focus('user')">
  	<h2>登录窗口</h2>
  	
    <s:form action="login" method="post">
    	<s:textfield id="user" name="loginBean.user" label="用户" />
    	<s:password name="loginBean.pwd" label="密码" />
		<s:radio name="loginBean.type" list="{'采购员','售货员','管理员'}" />
		<s:submit value="登录" />
    </s:form>
    
    <%
    session.putValue("saleSuccess", "");
    session.putValue("purchaseSuccess", "");
     %>
  </body>
</html>
