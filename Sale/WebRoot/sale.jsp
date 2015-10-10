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
  	<h2>销售结算</h2><p />
    
  	当前用户：<s:property value="#session.loginUser.user"/>&nbsp;&nbsp;
  	<s:a href="index.jsp">退出</s:a><br />
  	所在销售网点：<s:property value="#session.loginUser.bidentifier"/>&nbsp;&nbsp;
  	<s:a href="saleR.jsp">销售记录</s:a><p />
  	
  	<s:bean name="sale.commons.Today" var="date"></s:bean>
  	今天是 <s:date format="yyyy-MM-dd" name="#date.today" />
  	
  	<s:form action="sale">
  		<s:radio name="saleBean.type" list="{'批发商','摊位号'}" label="售出点类型" />
    	<s:textfield name="saleBean.num" label="售出点编号" size="30" />
    	<s:textfield id="code" name="saleBean.code" label="蔬菜编号" size="30" value="" 
    		onmouseover="focus('code')"/>
    	<s:submit value="确认" />
    </s:form>
    
   	<s:property value="#session.saleSuccess" />
  </body>
</html>
