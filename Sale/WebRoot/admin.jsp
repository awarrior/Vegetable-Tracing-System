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
  
  <body class="body" onload="focus('code')">
  	<h2>人员管理</h2><p />
    
  	当前用户：<s:property value="#session.loginUser.user"/>&nbsp;&nbsp;
  	<s:a href="index.jsp">退出</s:a><br />
  	所在销售网点：<s:property value="#session.loginUser.bidentifier"/>&nbsp;&nbsp;
  	<s:a href="adminR.jsp">人员列表</s:a><p />
  	
  	<s:form action="admin">
  		<s:radio name="adminBean.type" list="{'采购员','售货员','管理员'}" label="用户类型" />
  		<s:radio name="adminBean.operate" list="{'新增','修改','删除'}" label="操作" />
    	<s:textfield name="adminBean.user" label="用户" size="30" />
    	<s:textfield name="adminBean.pwd" label="密码" size="30" />
    	<s:textfield name="adminBean.rpwd" label="密码确认" size="30" />
    	<s:submit value="确认" />
    </s:form>
    
   	<s:property value="#session.adminSuccess" />
  </body>
</html>
