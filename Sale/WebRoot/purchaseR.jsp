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
  </head>
  
  <body class="body">
    <h2>采购记录</h2><p />    
    <table border="1" style="background-color: white">
    	<tr>
    		<th>蔬菜小包编号</th>
    		<th>采购员编号</th>
    		<th>采购日期</th>
    		<th>销售价格</th>
    	</tr>
    	<s:iterator value="#session.purchaseArray" id="pur"> 
    	<tr>
			<td><s:property value="#pur.identifier"/></td>
    		<td><s:property value="#pur.registrar"/></td>
    		<td><s:property value="#pur.date"/></td>
    		<td><s:property value="#pur.price"/></td>
    	</tr>
    	</s:iterator>
    </table>
    <p/>
    <s:a href="purchase.jsp">返回</s:a>
  </body>
</html>
