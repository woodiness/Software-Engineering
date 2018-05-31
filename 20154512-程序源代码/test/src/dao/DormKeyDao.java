package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.DormKey;
import db.DBUtil;

public class DormKeyDao {

	public void add(DormKey g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into DormKey (D_dorm,D_key) values (?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getDorm());
		ptmt.setInt(2, g.getKey());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(DormKey g) throws SQLException {

		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE DormKey SET D_dorm=?,D_key=? WHERE  D_dorm=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1,g.getDorm());
		ptmt.setInt(2, g.getKey());
		ptmt.setString(3, g.getDorm());
		ptmt.execute();
	}

	public java.util.List<DormKey> dormKeys() throws Exception {

		Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from DormKey");
		List<DormKey> gs = new ArrayList<DormKey>();
		DormKey g = null;
		while (rs.next()) {
			g = new DormKey();
			g.setDorm(rs.getString("D_dorm"));
			g.setKey(rs.getInt("D_key"));
			gs.add(g);
		}
		return gs;
	}

	public DormKey dormKey(String dorm) throws Exception {

		Connection conn = DBUtil.getConnection();
		DormKey g = null;
		String sql = "select * from DormKey where D_dorm=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, dorm);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new DormKey();
			g.setDorm(rs.getString("D_dorm"));
			g.setKey(rs.getInt("D_key"));
		}
		return g;
	}
}
