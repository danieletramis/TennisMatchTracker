package it.dtsoft.tennismatchtracker.model;

public class MatchModel {

	private String firstPlayer;
	private String secondPlayer;
	
	public String getFirstPlayer() {
		if (firstPlayer == null)
			firstPlayer = "Nadal";
		return firstPlayer;
	}
	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public String getSecondPlayer() {
		if (secondPlayer == null)
			secondPlayer = "Federer";
		return secondPlayer;
	}
	public void setSecondPlayer(String secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
}
