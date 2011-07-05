package it.dtsoft.tennismatchtracker.dataaccess.datasource;

import it.dtsoft.tennismatchtracker.dataaccess.dao.MatchDao;
import it.dtsoft.tennismatchtracker.dataaccess.dao.PlayerDao;
import it.dtsoft.tennismatchtracker.dataaccess.dao.PointDao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceDao {
	private DataSource _ds = null;
	private PlayerDao _pd = null;
	private MatchDao _md = null;
	private PointDao _po = null;
	
	public void init() {
		if (_ds != null)
			return;
		
		InitialContext cxt = null;

		try {
			cxt = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		try { 
			Context envContext = (Context) cxt.lookup("java:/comp/env");
			_ds = (DataSource) envContext.lookup("jdbc/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		if (_ds == null)
			throw new SQLException("data source null");
		return _ds.getConnection();
	}

	public PlayerDao createPlayerDataSource() {
		this.init();
		if (_pd == null)
			_pd = new PlayerDao();
		
		return _pd;
	}

	public MatchDao createMatchDataSource() {
		this.init();
		if (_md == null)
			_md = new MatchDao();
		
		return _md;
	}
	
	public PointDao createPointDataSource() {
		this.init();
		if (_po == null)
			_po = new PointDao();
		
		return _po;
	}
}