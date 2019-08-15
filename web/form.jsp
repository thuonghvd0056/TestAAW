<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hathu
  Date: 2019-08-03
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>From Customer</title>
</head>
<body>
<s:form action="save">
    <div>Name <s:textfield name="customer.name" /></div>
    <div>Address <s:textfield name="customer.address" /></div>
    <div>Phone <s:textfield name="customer.phone_No" /></div>
    <s:submit value="Save"/>
</s:form>
</body>
</html>
