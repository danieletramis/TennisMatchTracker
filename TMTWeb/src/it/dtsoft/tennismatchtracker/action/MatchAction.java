package it.dtsoft.tennismatchtracker.action;

import it.dtsoft.tennismatchtracker.model.MatchModel;

import com.opensymphony.xwork2.ActionSupport;

public class MatchAction extends ActionSupport {

	private static final long serialVersionUID = -2500642930666244612L;

	private MatchModel matchModel;
	
	public String execute() throws Exception {
		
		matchModel = new MatchModel() ;
		return SUCCESS;
	}

	public MatchModel getMatchModel() {
		return matchModel;
	}

	public void setMatchModel(MatchModel messageStore) {
		this.matchModel = messageStore;
	}
}
