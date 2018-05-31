package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	//private static final String URL = "jdbc:mysql://118.89.248.160:3306/SE_project?serverTimezone=GMT";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/SE_project?serverTimezone=GMT";
	private static final String USER = "root";
	private static final String PASSWORD = "31415926";

	private static Connection conn = null;

	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.获得数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

}
