<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'user.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		权限管理 <a href="return.action">返回</a>
		<br />
		<s:form action="addPower">
			资源路径: /<s:textfield name="PowerBean.resource" />
			<s:submit value="增加" />
		</s:form>
		<table border="1">
			<tr>
				<th>
					操作
				</th>
				<th>
					ID
				</th>
				<th>
					资源路径
				</th>
			</tr>
			<s:iterator value="powers" var="power">
				<tr>
					<td>
						<a
							href="modifyPower.action?selectID=<s:property value="#power.id"/>">编辑</a>
						<a
							href="deletePower.action?selectID=<s:property value="#power.id"/>">删除</a>&nbsp;
					</td>
					<td>
						<s:property value="#power.id" />
					</td>
					<td>
						<s:property value="#power.resource" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
