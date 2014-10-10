package org.tarena.dang.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil {
	private static DataSource ds;
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();
	static {
		Properties props = new Properties();
		InputStream in = DBUtil2.class.getClassLoader().getResourceAsStream(
				"dbcp.properties");
		try {
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = connLocal.get();
		if (conn == null || conn.isClosed()) {
			conn = ds.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}

	public static void close() throws Exception {
		Connection conn = connLocal.get();
		connLocal.set(null);
		if (conn != null) {
			conn.close();
		}
	}

}
