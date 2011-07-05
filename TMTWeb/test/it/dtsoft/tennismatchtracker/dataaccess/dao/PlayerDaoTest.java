package it.dtsoft.tennismatchtracker.dataaccess.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class PlayerDaoTest {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/tmt";
    private static final String USERNAME = "tmtadmin";
    private static final String PASSWORD = "tmtadmin";
	
	@Test
	public void create() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PlayerDao pdao = new PlayerDao();
		Player p = new Player();
		p.setName("Federer");
		try {
			
			pdao.create(conn, p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
