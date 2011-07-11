package it.dtsoft.tennismatchtracker.model;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;

import org.junit.Assert;
import org.junit.Test;

public class MatchModelTest {

	@Test
	public void updateScore() {
		Player p1 = new Player();
		p1.setName("Nadal");
		PlayerScoreModel psm1 = new PlayerScoreModel(p1);
		
		Player p2 = new Player();
		p2.setName("Federer");
		PlayerScoreModel psm2 = new PlayerScoreModel(p2);
		
		MatchModel model = new MatchModel(psm1, psm2, psm1);
		
		/* Set #1 - Game #1 */
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p1] Punteggio errato!", model.getScoreString().equals("15 - 0"));
		Assert.assertTrue("[p1] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p1] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p2] Punteggio errato!", model.getScoreString().equals("30 - 0"));
		Assert.assertTrue("[p2] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p2] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p3] Punteggio errato!", model.getScoreString().equals("30 - 15"));
		Assert.assertTrue("[p3] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p3] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p4] Punteggio errato!", model.getScoreString().equals("40 - 15"));
		Assert.assertTrue("[p4] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p4] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p5] Punteggio errato!", model.getScoreString().equals("40 - 30"));
		Assert.assertTrue("[p5] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p5] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p6] Punteggio errato!", model.getScoreString().equals("0 - 0"));
		Assert.assertTrue("[p6] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p6] Set errati!", model.getSetsString().equals("0 - 0"));
		
		/* Set #1 - Game #2 */
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p7] Punteggio errato!", model.getScoreString().equals("15 - 0"));
		Assert.assertTrue("[p7] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p7] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p8] Punteggio errato!", model.getScoreString().equals("30 - 0"));
		Assert.assertTrue("[p8] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p8] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p9] Punteggio errato!", model.getScoreString().equals("30 - 15"));
		Assert.assertTrue("[p9] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p9] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p10] Punteggio errato!", model.getScoreString().equals("40 - 15"));
		Assert.assertTrue("[p10] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p10] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p11] Punteggio errato!", model.getScoreString().equals("40 - 30"));
		Assert.assertTrue("[p11] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p11] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p12] Punteggio errato!", model.getScoreString().equals("40 - 40"));
		Assert.assertTrue("[p12] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p12] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p13] Punteggio errato!", model.getScoreString().equals("40 - A"));
		Assert.assertTrue("[p13] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p13] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p14] Punteggio errato!", model.getScoreString().equals("40 - 40"));
		Assert.assertTrue("[p14] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p14] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p15] Punteggio errato!", model.getScoreString().equals("A - 40"));
		Assert.assertTrue("[p15] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p15] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p16] Punteggio errato!", model.getScoreString().equals("40 - 40"));
		Assert.assertTrue("[p16] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p16] Set errati!", model.getSetsString().equals("0 - 0"));

		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p17] Punteggio errato!", model.getScoreString().equals("40 - A"));
		Assert.assertTrue("[p17] Game errati!", model.getGamesString().equals("1 - 0"));
		Assert.assertTrue("[p17] Set errati!", model.getSetsString().equals("0 - 0"));

		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		Assert.assertTrue("[p17] Punteggio errato!", model.getScoreString().equals("0 - 0"));
		Assert.assertTrue("[p17] Game errati!", model.getGamesString().equals("1 - 1"));
		Assert.assertTrue("[p17] Set errati!", model.getSetsString().equals("0 - 0"));
	}
	
	@Test
	public void tieBreak() {
		Player p1 = new Player();
		p1.setName("Nadal");
		PlayerScoreModel psm1 = new PlayerScoreModel(p1);
		
		Player p2 = new Player();
		p2.setName("Federer");
		PlayerScoreModel psm2 = new PlayerScoreModel(p2);
		
		MatchModel model = new MatchModel(psm1, psm2, psm1);
		psm1.setGame(6);
		psm2.setGame(6);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		/* Set #1 - Game #13 (tieBreak) */
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p1] Punteggio errato!", model.getScoreString().equals("1 - 0"));
		Assert.assertTrue("[p1] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p1] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p2] Punteggio errato!", model.getScoreString().equals("2 - 0"));
		Assert.assertTrue("[p2] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p2] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p3] Punteggio errato!", model.getScoreString().equals("3 - 0"));
		Assert.assertTrue("[p3] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p3] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p4] Punteggio errato!", model.getScoreString().equals("3 - 1"));
		Assert.assertTrue("[p4] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p4] Set errati!", model.getSetsString().equals("0 - 0"));

		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
		
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p4] Punteggio errato!", model.getScoreString().equals("3 - 2"));
		Assert.assertTrue("[p4] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p4] Set errati!", model.getSetsString().equals("0 - 0"));

		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p5] Punteggio errato!", model.getScoreString().equals("4 - 2"));
		Assert.assertTrue("[p5] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p5] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p6] Punteggio errato!", model.getScoreString().equals("4 - 3"));
		Assert.assertTrue("[p6] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p6] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p7] Punteggio errato!", model.getScoreString().equals("5 - 3"));
		Assert.assertTrue("[p7] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p7] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p8] Punteggio errato!", model.getScoreString().equals("5 - 4"));
		Assert.assertTrue("[p8] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p8] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p9] Punteggio errato!", model.getScoreString().equals("6 - 4"));
		Assert.assertTrue("[p9] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p9] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p10] Punteggio errato!", model.getScoreString().equals("6 - 5"));
		Assert.assertTrue("[p10] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p10] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm2);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p11] Punteggio errato!", model.getScoreString().equals("6 - 6"));
		Assert.assertTrue("[p11] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p11] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p12] Punteggio errato!", model.getScoreString().equals("7 - 6"));
		Assert.assertTrue("[p12] Game errati!", model.getGamesString().equals("6 - 6"));
		Assert.assertTrue("[p12] Set errati!", model.getSetsString().equals("0 - 0"));
		
		model.updateScore(psm1);
		System.out.println(model.getScoreString() + " : " + model.getGamesString() + " : " + model.getSetsString());
	
		System.out.println("Now serving: " + model.getPlayerToServe().getPlayer().getName());
		
		Assert.assertTrue("[p13] Punteggio errato!", model.getScoreString().equals("0 - 0"));
		Assert.assertTrue("[p13] Game errati!", model.getGamesString().equals("0 - 0"));
		Assert.assertTrue("[p13] Set errati!", model.getSetsString().equals("1 - 0"));
	}
}
