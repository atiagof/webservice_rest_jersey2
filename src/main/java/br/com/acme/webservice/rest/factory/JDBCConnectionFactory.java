package br.com.acme.webservice.rest.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class JDBCConnectionFactory {

	protected static final Logger LOG = Logger.getLogger(JDBCConnectionFactory.class.getName());

	public JDBCConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Connection openConnectionPostgreSQL() {
		try {

			Connection connection = null;

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/api", "postgres","postgres");
			LOG.info("Open connection successfuly");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
