<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tennis Match Tracker - Welcome</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link id="linkFavicon" rel="shortcut icon" type="image/x-icon" href="images/ball.png">
</head>
<body>
	<h1>Welcome to Tennis Match Tracker!</h1>
	<p><a href="<s:url action='match'><s:param name="newMatch" value="true" /></s:url>">New match...</a></p>
	<p><a href="<s:url action='players'/>">Players...</a></p>
	<p><a href="<s:url action='statistics'/>">Statistics...</a></p>
</body>
</html>