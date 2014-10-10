package org.tarena.dang.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBUtil2 {
	private static DataSource ds;
	private static ThreadLocal<Connection> connLocal=new ThreadLocal<Connection>();
	static {
		Properties props = new Properties();
		InputStream in = DBUtil2.class.getClassLoader().getResourceAsStream(
				"dbcp.properties");
		try {
			props.load(in);
			ds=BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){
			conn=ds.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	public static void closeConnection() throws Exception{
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null){
			conn.close();//放回连接池
		}
	}
	public static void beginTransaction() throws Exception{
		Connection conn = getConnection();
		conn.setAutoCommit(false);
	}
	public static void commit() {
		try{
			Connection conn = getConnection();
			conn.commit();
		}catch(Exception ex){
		}
	}
	
	public static void rollback(){
		try{
			Connection conn = getConnection();
			conn.rollback();
		}catch(Exception ex){
		}
	}

}
