package it.dtsoft.tennismatchtracker.action;

import it.dtsoft.tennismatchtracker.dataaccess.dao.PlayerDao;
import it.dtsoft.tennismatchtracker.dataaccess.datasource.DataSourceDao;
import it.dtsoft.tennismatchtracker.model.PlayersModel;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class PlayersAction extends ActionSupport {

	private PlayersModel playersModel;
	
	@Override
	public String execute() throws Exception {
		DataSourceDao dao = new DataSourceDao();
		PlayerDao pdao = dao.createPlayerDataSource();
		
		List results = pdao.loadAll(dao.getConnection());
		if (LOG.isInfoEnabled()) {
			LOG.info("Players registered: " + results.size());
		}
		
		playersModel = new PlayersModel();
		playersModel.setPlayers(results);
		
		return SUCCESS;
	}

	public void setPlayersModel(PlayersModel playersModel) {
		this.playersModel = playersModel;
	}

	public PlayersModel getPlayersModel() {
		return playersModel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -572047563453432670L;

}
