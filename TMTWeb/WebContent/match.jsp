<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tennis Match Tracker - New Match</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link id="linkFavicon" rel="shortcut icon" type="image/x-icon" href="images/ball.png">
<script type="text/javascript">

function setPlayerOfScore(playerId, pointType) {
	document.forms.match.playerOfScore.value = playerId;
	document.forms.match.scoreType.value = pointType;
	
	return true;
}
</script>
</head>
<body>
	<s:if test="errorMsg != null">
		<div class="errorMsg"><s:property value="errorMsg"/></div>
	</s:if>
	<s:if test="matchModel != null">
    	<form action="match" id="match" name="match" method="post"> 
    		<s:hidden name="playerOfScore"/>
    		<s:hidden name="scoreType"/>
	    	<table border=0 cellpadding=0 cellspacing=5 class="match-table">
	    		<tr>
	    			<td class="player">
	    				<s:property value="matchModel.firstPlayer.player.name" />
	    				<s:if test="matchModel.playerToServe == matchModel.firstPlayer">
	    					<img alt="*" src="images/ball.png" width="16px"/>
	    				</s:if>
	    			</td>
	    			<td class="scoring">
	    				<div class="scoring-points"><s:property value="matchModel.scoreString" /></div>
	    				<div class="scoring-games"><s:property value="matchModel.gamesString" /></div>
	    				<div class="scoring-sets"><s:property value="matchModel.setsString" /></div>
	    			</td>
	    			<td class="player">
	    				<s:property value="matchModel.secondPlayer.player.name" />
	    				<s:if test="matchModel.playerToServe == matchModel.secondPlayer">
	    					<img alt="*" src="images/ball.png" width="16px"/>
	    				</s:if>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td><input type="submit" value="Winner" name="FirstPlayerScore" class="command"
	    				onclick="return setPlayerOfScore('FIRST', 'WINNER')" type="button"/></td>
	    			<td></td>
	    			<td><input type="submit" value="Winner" name="SecondPlayerScore" class="command"
	    				onclick="return setPlayerOfScore('SECOND', 'WINNER')"/></td>
	    		</tr>
	    		<tr>
	    			<td><input type="submit" value="Opponent Error" name="FirstPlayerScore" class="command"
	    				onclick="return setPlayerOfScore('FIRST', 'ERROR')" type="button"/></td>
	    			<td></td>
	    			<td><input type="submit" value="Opponent Error" name="SecondPlayerScore" class="command"
	    				onclick="return setPlayerOfScore('SECOND', 'ERROR')"/></td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<s:if test="matchModel.playerToServe == matchModel.firstPlayer">
	    					<input type="submit" value="Ace" name="FirstPlayerScore" class="command"
	    					onclick="return setPlayerOfScore('FIRST', 'ACE')" type="button"/>
	    				</s:if>
	    			</td>
	    			<td></td>
	    			<td>
	    				<s:if test="matchModel.playerToServe == matchModel.secondPlayer">
	    					<input type="submit" value="Ace" name="SecondPlayerScore" class="command"
	    					onclick="return setPlayerOfScore('SECOND', 'ACE')"/>
	    				</s:if>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>
	    				<s:if test="matchModel.playerToServe == matchModel.firstPlayer">
	    					<input type="submit" value="Double Fault" name="FirstPlayerScore" class="command"
	    					onclick="return setPlayerOfScore('FIRST', 'DOUBLE_FAULT')" type="button"/>
	    				</s:if>
	    			</td>
	    			<td></td>
	    			<td>
	    				<s:if test="matchModel.playerToServe == matchModel.secondPlayer">
	    					<input type="submit" value="Double Fault" name="SecondPlayerScore" class="command"
	    					onclick="return setPlayerOfScore('SECOND', 'DOUBLE_FAULT')"/>
	    				</s:if>
	    			</td>
	    		</tr>
			</table>
			
	    </form>
    </s:if>
    <s:if test="matchModel == null">
	    <s:form action="match">
	    	<s:textfield name="firstPlayer" label="First player" />
			<s:textfield name="secondPlayer" label="Second player" />
			
			<s:submit value="Start Match" />
	    </s:form>
	    <p>Note: first player serving first.</p>
    </s:if>
    <a href="<s:url action='index'/>">Home</a>
</body>
</html>