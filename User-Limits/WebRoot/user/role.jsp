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

		<title>My JSP 'role.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
			function warn(selectID) {
				if(confirm("删除角色会删除对应的用户！")) {
					location.href="deleteRole.action?selectID=" + selectID;
				}
			}
		</script>
	</head>

	<body>
		角色管理
		<a href="return.action">返回</a>
		<br />
		<s:form action="addRole">
			角色别名: <s:textfield name="RoleBean.name"></s:textfield>
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
					别名
				</th>
			</tr>
			<s:iterator value="roles" var="role">
				<tr>
					<td>
						<a
							href="modifyRole.action?selectID=<s:property value="#role.id"/>">编辑</a>
						<a onclick="warn(<s:property value="#role.id"/>)">删除</a>&nbsp;
					</td>
					<td>
						<s:property value="#role.id" />
					</td>
					<td>
						<s:property value="#role.name" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
