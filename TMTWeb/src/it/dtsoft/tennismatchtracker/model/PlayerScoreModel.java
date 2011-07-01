package it.dtsoft.tennismatchtracker.model;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;


public class PlayerScoreModel {

	private Player player;
	private int set;
	private int game;
	private int score;
	private boolean advantage;
	
	public PlayerScoreModel(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isAdvantage() {
		return advantage;
	}
	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
	}
	@Override
	public int hashCode() {
		assert(player != null);
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player.getName() == null) ? 0 : player.getName().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerScoreModel other = (PlayerScoreModel) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else {
			if (other.player == null)
				return false;
			else {
				if (player.getName() == null) {
					if (other.player.getName() != null)
						return false;
				} else if (!player.getName().equals(other.player.getName()))
					return false;
			}
		}
		return true;
	}
	public void incrementScore() {
		score++;
	}
	public String getScoreLiteral() {
		if (score == 0)
			return "0";
		if (score == 1)
			return "15";
		if (score == 2)
			return "30";
		if (score == 3)
			return "40";
		if (score % 2 == 0)
			return "A";
		return "40";
	}
	public void incrementGame() {
		game++;
	}
	public void incrementSet() {
		set++;
	}
	
}
