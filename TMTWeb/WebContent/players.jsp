<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tennis Match Tracker - Registered Players</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <h1>Registered players</h1>
    <ul>
    <s:iterator value="playersModel.players" var="player">
    	<li><s:property value="#player.name"/></li>
    </s:iterator>
    </ul>
    <a href="<s:url action='index'/>">Home</a>
</body>
</html>