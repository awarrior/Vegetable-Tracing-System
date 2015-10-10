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
    <h2>销售记录</h2><p />    
    <table border="1" style="background-color: white">
    	<tr>
    		<th>蔬菜小包编号</th>
    		<th>销售员编号</th>
    		<th>销售日期</th>
    		<th>销售地点</th>
    	</tr>
    	<s:iterator value="#session.midSaleArray" id="mid"> 
    	<tr>
			<td><s:property value="#mid.identifier"/></td>
    		<td><s:property value="#mid.salesman"/></td>
    		<td><s:property value="#mid.date"/></td>
    		<td><s:property value="#mid.salePlace"/></td>
    	</tr>
    	</s:iterator>
    	<s:iterator value="#session.endSaleArray" id="end"> 
    	<tr>
			<td><s:property value="#end.identifier"/></td>
    		<td><s:property value="#end.salesman"/></td>
    		<td><s:property value="#end.date"/></td>
    		<td><s:property value="#end.salePlace"/></td>
    	</tr>
    	</s:iterator>
    </table>
    <p/>
    <s:a href="sale.jsp">返回</s:a>
  </body>
</html>
