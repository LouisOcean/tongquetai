package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JBUtil {
	public static Connection getConnection(){
		Connection con = null;
		try {
			String sql = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tqt";
			String userName = "root";
			String pasw = "11";
			Class.forName(sql);
			con = DriverManager.getConnection(url, userName, pasw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * ��ݿ�ر�
	 * @param rs
	 * @param ps
	 * @param con
	 */
	public static void close(ResultSet rs,PreparedStatement ps,Connection con){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
