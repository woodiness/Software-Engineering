package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import model.BasicInformation;
import db.DBUtil;

public class BasicInformationDao {

	public void add(BasicInformation g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into BasicInformation (P_id,P_birth,P_gender,P_address,P_name) values (?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getBirth());
		ptmt.setString(3, g.getGender());
		ptmt.setString(4, g.getAddress());
		ptmt.setString(5, g.getName());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(BasicInformation g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update BasicInformation set P_name=? where P_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getName());
		ptmt.setString(2, g.getId());
		ptmt.execute();
	}

	public java.util.List<BasicInformation> basicInformations() throws Exception {

		Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from BasicInformation");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		List<BasicInformation> gs = new ArrayList<BasicInformation>();
		BasicInformation g = null;
		while (rs.next()) {
			g = new BasicInformation();
			g.setId(rs.getString("P_id"));
			g.setBirth(df.format(rs.getTimestamp("P_birth")));
			g.setGender(rs.getString("P_gender"));
			g.setAddress(rs.getString("P_address"));
			g.setName(rs.getString("P_name"));
			gs.add(g);
		}
		return gs;
	}

	public BasicInformation basicInformation(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		BasicInformation g = null;
		String sql = "select * from BasicInformation where P_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		while (rs.next()) {
			g = new BasicInformation();
			g.setId(rs.getString("P_id"));
			g.setBirth(df.format(rs.getTimestamp("P_birth")));
			g.setGender(rs.getString("P_gender"));
			g.setAddress(rs.getString("P_address"));
			g.setName(rs.getString("P_name"));
		}
		return g;
	}
}
