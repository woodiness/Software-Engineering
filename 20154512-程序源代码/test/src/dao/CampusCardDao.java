package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.CampusCard;
import db.DBUtil;

public class CampusCardDao {

	public void add(CampusCard g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into CampusCard (C_id,C_card_Id,C_password,C_waterFee) values (?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getCard_Id());
		ptmt.setString(3, g.getPassword());
		ptmt.setFloat(4, g.getWaterFee());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(CampusCard g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE CampusCard SET C_Id=?,C_card_Id=?,C_password=?,C_waterFee=? WHERE  C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getCard_Id());
		ptmt.setString(3, g.getPassword());
		ptmt.setFloat(4, g.getWaterFee());
		ptmt.setString(5, g.getId());
		ptmt.execute();
	}

	public java.util.List<CampusCard> campusCards() throws Exception {

		Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from CampusCard");
		List<CampusCard> gs = new ArrayList<CampusCard>();
		CampusCard g = null;
		while (rs.next()) {
			g = new CampusCard();
			g.setId(rs.getString("C_id"));
			g.setCard_Id(rs.getString("C_card_Id"));
			g.setPassword(rs.getString("C_password"));
			g.setWaterFee(rs.getFloat("C_waterFee"));
			gs.add(g);
		}
		return gs;
	}

	public CampusCard campusCard(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		CampusCard g = null;
		String sql = "select * from CampusCard where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new CampusCard();
			g.setId(rs.getString("C_id"));
			g.setCard_Id(rs.getString("C_card_Id"));
			g.setPassword(rs.getString("C_password"));
			g.setWaterFee(rs.getFloat("C_waterFee"));
		}
		return g;
	}
}
