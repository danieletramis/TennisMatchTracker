package it.dtsoft.tennismatchtracker.action;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Match;
import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;
import it.dtsoft.tennismatchtracker.dataaccess.datasource.DataSourceDao;
import it.dtsoft.tennismatchtracker.dataaccess.exception.AmbiguousSearchException;
import it.dtsoft.tennismatchtracker.dataaccess.util.DataAccessUtils;
import it.dtsoft.tennismatchtracker.model.MatchModel;
import it.dtsoft.tennismatchtracker.model.PlayerScoreModel;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MatchAction extends ActionSupport implements SessionAware, ParameterAware {

	private static final long serialVersionUID = -2500642930666244612L;
	//private static final Logger LOGGER = Logger.getLogger("it.dtsoft.tennismatchtracker.action.MatchAction");
	private static final String param_first = "FIRST";
	private static final String param_second = "SECOND";
	
	private MatchModel matchModel;
	private String firstPlayer;
	private String secondPlayer;
	private String errorMsg;
	private Map<String, Object> session;
	Map<String, String[]> parameters;
	private String playerOfScore;
	private String scoreType;
	
	public String execute() throws Exception {
		DataSourceDao dao = new DataSourceDao();
		
		String[] param_new_match = parameters.get("newMatch");
		
		errorMsg = null;
		matchModel = (MatchModel)session.get("MATCH");
		
		if (param_new_match != null && param_new_match.length > 0) {
			if (param_new_match[0].equals("true"))
				matchModel = null;
		}
		
		if (matchModel == null) {
			if (firstPlayer != null && firstPlayer.length() > 0 &&
				secondPlayer != null && secondPlayer.length() > 0) {
				
				if (LOG.isInfoEnabled()) {
					LOG.info("New match between " + firstPlayer + " and " + secondPlayer);
				}
	
				PlayerScoreModel psc1 = null;
				try {
					psc1 = new PlayerScoreModel( DataAccessUtils.loadOrRegister(dao, firstPlayer) );
				} catch (AmbiguousSearchException e) {
					errorMsg = "Specify a unique player for first player";
					return SUCCESS;
				}
				
				PlayerScoreModel psc2 = null;
				try {
					psc2 = new PlayerScoreModel( DataAccessUtils.loadOrRegister(dao, secondPlayer) );
				} catch (AmbiguousSearchException e) {
					errorMsg = "Specify a unique player for second player";
					return SUCCESS;
				}
				
				matchModel = new MatchModel(psc1, psc2, psc1);
				Match m = saveNewMatch(dao, psc1, psc2);
				matchModel.setMatch(m);
				
				session.put("MATCH", matchModel);
			}
		} else {
			if (playerOfScore != null) {
				if (param_first.equals(playerOfScore)) {
					matchModel.updateScore(matchModel.getFirstPlayer());
					
					saveScore(dao, matchModel.getFirstPlayer(), scoreType);
				} else if (param_second.equals(playerOfScore)) {
					matchModel.updateScore(matchModel.getSecondPlayer());
					
					saveScore(dao, matchModel.getSecondPlayer(), scoreType);
				} else {
					errorMsg = "Error in input parameters";
				}
			}
		}
		
		
		return SUCCESS; 
	}

	private void saveScore(DataSourceDao dao, PlayerScoreModel player1, String pointType)
			throws SQLException {
		Match match = matchModel.getMatch();
		Player player = player1.getPlayer();
		String scoreString = matchModel.getFullScoreString();
		Timestamp timestampIn = new Timestamp(new Date().getTime());
		
		DataAccessUtils.savePoint(dao, pointType, match, player, scoreString, timestampIn);
	}


	private Match saveNewMatch(DataSourceDao dao, PlayerScoreModel psc1, 
			PlayerScoreModel psc2) throws SQLException {
		Player player1 = psc1.getPlayer();
		Player player2 = psc2.getPlayer();
		Timestamp startTime = new Timestamp(new Date().getTime());
		
		return DataAccessUtils.saveNewMatch(dao, player1, player2, startTime);
	}


	public MatchModel getMatchModel() {
		return matchModel;
	}

	public void setMatchModel(MatchModel match) {
		this.matchModel = match;
	}

	public String getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(String secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getPlayerOfScore() {
		return playerOfScore;
	}

	public void setPlayerOfScore(String playerOfScore) {
		this.playerOfScore = playerOfScore;
	}

	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
}
