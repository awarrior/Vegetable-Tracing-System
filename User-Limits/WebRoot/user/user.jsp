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
		用户管理 
		
		<a href="return.action">返回</a>
		<br />
		
		<s:form action="addUser">
			用户ID: <s:textfield name="UserBean.id"></s:textfield>
			密码: <s:textfield name="UserBean.password"></s:textfield>
			角色: <s:select name="UserBean.role" list="roles"></s:select>
			<s:submit value="编辑" method="" />
			<br />
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
					角色
				</th>
			</tr>
			<s:iterator value="users" var="user">
				<tr>
					<td>
						<a
							href="modifyUser.action?selectID=<s:property value="#user.id"/>">编辑</a>
						<s:if test="#user.id!='root'">
							<a
								href="deleteUser.action?selectID=<s:property value="#user.id"/>">删除</a>&nbsp;
						</s:if>
					</td>
					<td>
						<s:property value="#user.id" />
					</td>
					<td>
						<s:property value="#user.role" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
