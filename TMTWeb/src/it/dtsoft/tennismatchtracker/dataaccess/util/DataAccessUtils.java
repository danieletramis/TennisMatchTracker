package it.dtsoft.tennismatchtracker.dataaccess.util;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Match;
import it.dtsoft.tennismatchtracker.dataaccess.dao.MatchDao;
import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;
import it.dtsoft.tennismatchtracker.dataaccess.dao.PlayerDao;
import it.dtsoft.tennismatchtracker.dataaccess.dao.Point;
import it.dtsoft.tennismatchtracker.dataaccess.dao.PointDao;
import it.dtsoft.tennismatchtracker.dataaccess.datasource.DataSourceDao;
import it.dtsoft.tennismatchtracker.dataaccess.exception.AmbiguousSearchException;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class DataAccessUtils {

	public static Player loadOrRegister(DataSourceDao dao, String firstPlayer)
		throws SQLException, AmbiguousSearchException 
	{
		PlayerDao p_dao = dao.createPlayerDataSource();
		Player p = p_dao.createValueObject();
		p.setName(firstPlayer);
		
		List matching = p_dao.searchMatching(dao.getConnection(), p);
		if (matching.size() == 0)
			p_dao.create(dao.getConnection(), p);
		else if (matching.size() == 1)
			return (Player)matching.get(0);
		else
			throw new AmbiguousSearchException("Found " + matching.size() + " match");
		
		return p;
	}

	public static Match saveNewMatch(DataSourceDao dao, Player player1, Player player2)
			throws SQLException {
		MatchDao m_dao = dao.createMatchDataSource();
		Match m = m_dao.createValueObject();
		
		m.setFirstPlayerId(player1.getPlayerId());
		m.setSecondPlayerId(player2.getPlayerId());
		
		m_dao.create(dao.getConnection(), m);
		
		return m;
	}
	

	public static Point savePoint(DataSourceDao dao, String pointType, Match match,
			Player player, String scoreString, Timestamp timestampIn)
			throws SQLException {
		PointDao p_dao = dao.createPointDataSource();
		Point p = p_dao.createValueObject();
		
		p.setMatchId(match.getMatchId());
		p.setPlayerId(player.getPlayerId());
		p.setPointLiteral(scoreString);
		p.setTimestamp(timestampIn);
		p.setPointType(pointType);
		
		p_dao.create(dao.getConnection(), p);
		
		return p;
	}
}
