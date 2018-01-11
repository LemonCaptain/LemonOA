<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
	<table cellspacing="0" cellpadding="0" class="TableStyle">
		
		<thead>
			<tr align="center" valign="middle" id=TableTitle>
				<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
			</tr>
		</thead>
		
		<tbody id="TableData" class="dataContainer">
		<s:iterator value="#departmentList">
			<tr class="TableDatail template">
				<td><s:a action="department_list?parentId=%{id}">${name}</s:a>&nbsp;</td>
				<td>${parent.name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
					<s:a action="department_delete?id=%{id}&parentId=%{parent.id}" onclick="return confirm('这将删除该部门与该部门下的子部门，确定要删除吗?')">删除</s:a>
					<s:a action="department_editUI?id=%{id}">修改</s:a>
				<br/>
				</td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<s:a action="department_addUI?parentId=%{parentId}">添加</s:a>
	<s:a action="department_list?parentId=%{#parent.parent.id}">返回到上一级</s:a>
</body>
</html>