package it.dtsoft.tennismatchtracker.model;

import it.dtsoft.tennismatchtracker.dataaccess.dao.Player;

import org.junit.Assert;
import org.junit.Test;

public class PlayerScoreModelTest {

	@Test
	public void equals() {
		Player p1 = new Player();
		p1.setName("Nadal");
		PlayerScoreModel psm1 = new PlayerScoreModel(p1);
		
		Player p2 = new Player();
		p2.setName("Federer");
		PlayerScoreModel psm2 = new PlayerScoreModel(p2);
		
		Assert.assertTrue("I due giocatori sono uguali", !psm1.equals(psm2));
		
		p2.setName("Nadal");
		
		Assert.assertTrue("I due giocatori sono diversi", psm1.equals(psm2));
		
		psm2.setPlayer(null);
		
		Assert.assertTrue("I due giocatori sono uguali", !psm1.equals(psm2));
		
		psm1.setPlayer(null);
		
		Assert.assertTrue("I due giocatori sono diversi", psm1.equals(psm2));
	}
}
