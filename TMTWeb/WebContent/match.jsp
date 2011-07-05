<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tennis Match Tracker - New Match</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">

function setPlayerOfScore(playerId) {
	document.forms.match.playerOfScore.value = playerId;
	
	return true;
}
</script>
</head>
<body>
	<s:if test="errorMsg != null">
		<div class="errorMsg"><s:property value="errorMsg"/></div>
	</s:if>
	<s:if test="matchModel != null">
    	<s:form action="match">
    		<s:hidden name="playerOfScore"/>
    		<s:hidden name="scoreType"/>
	    	<table border=0 cellpadding=0 cellspacing=0>
	    		<tr>
	    			<td><s:property value="matchModel.firstPlayer.player.name" /></td>
	    			<td>
	    				<s:property value="matchModel.scoreString" /><br/>
	    				<s:property value="matchModel.gamesString" /><br/>
	    				<s:property value="matchModel.setsString" />
	    			</td>
	    			<td><s:property value="matchModel.secondPlayer.player.name" /></td>
	    		</tr>
	    		<tr>
	    			<td><s:submit value="FirstPlayerScore" name="FirstPlayerScore"
	    				onclick="return setPlayerOfScore('FIRST')"/></td>
	    			<td></td>
	    			<td><s:submit value="SecondPlayerScore" name="SecondPlayerScore"
	    				onclick="return setPlayerOfScore('SECOND')"/></td>
	    		</tr>
			</table>
	    </s:form>
    </s:if>
    <s:if test="matchModel == null">
	    <s:form action="match">
	    	<s:textfield name="firstPlayer" label="First player" />
			<s:textfield name="secondPlayer" label="Second player" />
			
			<s:submit value="Submit" />
	    </s:form>
    </s:if>
    <a href="<s:url action='index'/>">Home</a>
</body>
</html>