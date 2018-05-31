package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.CardReader;
import db.DBUtil;

public class CardReaderDao {

	public void add(CardReader g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into CardReader (C_id,C_category,C_bankcard,C_bill) values (?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getCategory());
		ptmt.setString(3, g.getBankcard());
		ptmt.setFloat(4, g.getBill());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(CardReader g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update CardReader set C_bankcard=? where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getBankcard());
		ptmt.setString(2, g.getId());
		ptmt.execute();
	}

	public java.util.List<CardReader> cardReaders() throws Exception {

		Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from CardReader");
		List<CardReader> gs = new ArrayList<CardReader>();
		CardReader g = null;
		while (rs.next()) {
			g = new CardReader();
			g.setId(rs.getString("C_id"));
			g.setCategory(rs.getString("C_category"));
			g.setBankcard(rs.getString("C_bankcard"));
			g.setBill(rs.getFloat("C_bill"));
			gs.add(g);
		}
		return gs;
	}

	public CardReader cardReader(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		CardReader g = null;
		String sql = "select * from CardReader where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new CardReader();
			g.setId(rs.getString("C_Id"));
			g.setCategory(rs.getString("C_category"));
			g.setBankcard(rs.getString("C_bankcard"));
			g.setBill(rs.getFloat("C_bill"));
		}
		return g;
	}
}
