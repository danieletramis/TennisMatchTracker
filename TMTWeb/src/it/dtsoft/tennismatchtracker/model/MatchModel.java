package it.dtsoft.tennismatchtracker.model;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;

import java.util.Date;

public class MatchModel {

	private PlayerScoreModel firstPlayer;
	private PlayerScoreModel secondPlayer;
	private Date startTime;
	private PlayerScoreModel playerToServe;
	private Player winner;
	
	public MatchModel() {
		startTime = new Date();
	}
	
	public MatchModel(PlayerScoreModel firstPlayer, 
			PlayerScoreModel secondPlayer, PlayerScoreModel startingPlayer) {
		this();
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.playerToServe = startingPlayer;
	}
	
	public PlayerScoreModel getFirstPlayer() {
		if (firstPlayer == null) {
			Player p = new Player();
			p.setName("Nadal");
			firstPlayer = new PlayerScoreModel(p);
		}
		return firstPlayer;
	}
	public void setFirstPlayer(PlayerScoreModel firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public PlayerScoreModel getSecondPlayer() {
		if (secondPlayer == null) {
			Player p = new Player();
			p.setName("Federer");
			secondPlayer = new PlayerScoreModel(p);;
		}
		return secondPlayer;
	}
	public void setSecondPlayer(PlayerScoreModel secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public PlayerScoreModel getPlayerToServe() {
		return playerToServe;
	}
	public void setPlayerToServe(PlayerScoreModel playerToServe) {
		this.playerToServe = playerToServe;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public String getSetsString() {
		return firstPlayer.getSet() + " - " + secondPlayer.getSet();
	}
	public String getGamesString() {
		return firstPlayer.getGame() + " - " + secondPlayer.getGame();
	}
	public String getScoreString() {
		if (firstPlayer.getScore() > 3 || secondPlayer.getScore() > 3) {
			if (firstPlayer.getScore() > secondPlayer.getScore())
				return "A - 40";
			else if (firstPlayer.getScore() < secondPlayer.getScore())
				return "40 - A";
			else 
				return "40 - 40";
		}
		return firstPlayer.getScoreLiteral() + " - " + secondPlayer.getScoreLiteral();
	}
	public void updateScore(PlayerScoreModel player) {
		if (player.equals(firstPlayer)) {
			incrementScore(firstPlayer, secondPlayer);
		} else {
			incrementScore(secondPlayer, firstPlayer);
		}
	}

	private void incrementScore(PlayerScoreModel player1, PlayerScoreModel player2) {
		player1.incrementScore();
		if (player1.getScore() > 3) {
			if (player1.getScore() - player2.getScore() >= 2) {
				player1.incrementGame();
				player1.setScore(0);
				player2.setScore(0);
				invertServingPlayer();
				if (player1.getGame() >= 6) {
					if (player1.getGame() - player2.getGame() >= 2) {
						player1.incrementSet();
						player1.setGame(0);
						player1.setScore(0);
						player2.setGame(0);
						player2.setScore(0);
						if (player1.getSet() == 2)
							winner = player1.getPlayer();
					}
				}
			}
		}
	}

	private void invertServingPlayer() {
		if (playerToServe.equals(firstPlayer))
			playerToServe = secondPlayer;
		else
			playerToServe = firstPlayer;
	}
}
