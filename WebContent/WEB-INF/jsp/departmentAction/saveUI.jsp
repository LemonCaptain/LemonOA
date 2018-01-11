<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@	include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
	<s:form action="department_%{ id==null ? 'add' : 'edit'}">
		<s:hidden name="id"></s:hidden>
		<s:select name="parentId" cssClass="SelectStyle" list="#departmentList" 
		listKey="id" listValue="name" headerKey="" headerValue="==请选择部门==" >
			
		</s:select>
		<s:textfield name="name"></s:textfield>
		<s:textarea name="description"></s:textarea>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>