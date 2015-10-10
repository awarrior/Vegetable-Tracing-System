<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'relation.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"> 
  function myself(){ 
  var right=document.forms[0].rightList; 
  for(i=1; i <right.length; i++) 
    right[i].selected = true; 
  } 
</script>
		<s:head />
	</head>

	<body>
		<s:if test="#session.item=='role'">
		角色
		<s:property value="selectMember" />
		对应关系编辑
		<a href="showRoles.action">返回</a>
			<br />
			<s:form action="saveRole">
				<s:optiontransferselect leftTitle="角色已有权限" rightTitle="角色未选权限"
					name="RelationBean.left" doubleName="RelationBean.right"
					list="leftList" doubleList="rightList" addAllToLeftLabel="添加全部权限"
					addAllToRightLabel="删除全部权限" addToLeftLabel="添加权限"
					addToRightLabel="删除权限" selectAllLabel="全选"
					headerValue="--- 请选择权限 ---" doubleHeaderValue="--- 请选择权限 ---"
					headerKey="headerKey" doubleHeaderKey="doubleHeaderKey"
					allowUpDownOnLeft="false" allowUpDownOnRight="false"
					cssStyle="width:200px;height:300px;"
					doubleCssStyle="width:200px;height:300px;" />
				<s:submit value="保存修改" onclick="myself" />
			</s:form>
		</s:if>
		<s:elseif test="#session.item=='power'">
		权限
		<s:property value="selectMember" />
		对应关系编辑
		<a href="showPowers.action">返回</a>
			<br />
			<s:form action="savePower">
				<s:optiontransferselect leftTitle="权限已在角色" rightTitle="权限未在角色"
					name="RelationBean.left" doubleName="RelationBean.right"
					list="leftList" doubleList="rightList" addAllToLeftLabel="添加全部角色"
					addAllToRightLabel="删除全部角色" addToLeftLabel="添加角色"
					addToRightLabel="删除角色" selectAllLabel="全选"
					headerValue="--- 请选择角色 ---" doubleHeaderValue="--- 请选择角色 ---"
					headerKey="headerKey" doubleHeaderKey="doubleHeaderKey"
					allowUpDownOnLeft="false" allowUpDownOnRight="false"
					cssStyle="width:200px;height:300px;"
					doubleCssStyle="width:200px;height:300px;" />
				<s:submit value="保存修改" onclick="myself" />
			</s:form>
		</s:elseif>
		<s:else>
		用户
		<s:property value="selectMember" />
		对应关系编辑
		<a href="showUsers.action">返回</a>
			<br />
			<s:form action="saveUser">
				修改角色：<s:select name="UserBean.role" list="roles"></s:select>
				修改密码：<s:password name="UserBean.password"></s:password>
				<s:submit value="保存修改" />
			</s:form>
		</s:else>
	</body>
</html>
