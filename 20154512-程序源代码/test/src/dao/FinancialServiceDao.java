package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.FinancialService;
import db.DBUtil;

public class FinancialServiceDao {

	public void add(FinancialService g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " "
				+ "insert into FinancialService (F_Id,F_card_Id,F_rest,F_bankcard,F_condition) values (?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getCard_Id());
		ptmt.setFloat(3, g.getRest());
		ptmt.setString(4, g.getBankcard());
		ptmt.setBoolean(5, g.isCondition());// ==getCondition();
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(FinancialService g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql ="UPDATE FinancialService SET F_Id=?,F_card_Id=?,F_rest=?,F_bankcard=?,F_condition=? WHERE F_id=?";
		//String sql = "update FinancialService set F_condition=? where F_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1,g.getId());
		ptmt.setString(2,g.getCard_Id());
		ptmt.setFloat(3,g.getRest());
		ptmt.setString(4,g.getBankcard());
		ptmt.setBoolean(5, g.isCondition());
		ptmt.setString(6, g.getId());
		ptmt.execute();
	}

	public java.util.List<FinancialService> financialServices() throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from FinancialService");
		List<FinancialService> gs = new ArrayList<FinancialService>();
		FinancialService g = null;
		while (rs.next()) {
			g = new FinancialService();
			g.setId(rs.getString("F_Id"));
			g.setCard_Id(rs.getString("F_card_Id"));
			g.setBankcard(rs.getString("F_bankcard"));
			g.setRest(rs.getFloat("F_rest"));
			g.setCondition(rs.getBoolean("F_condition"));
			gs.add(g);
		}
		return gs;
	}

	public FinancialService financialService(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		FinancialService g = null;
		String sql = "select * from FinancialService where F_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new FinancialService();
			g.setId(rs.getString("F_Id"));
			g.setCard_Id(rs.getString("F_card_Id"));
			g.setBankcard(rs.getString("F_bankcard"));
			g.setRest(rs.getFloat("F_rest"));
			g.setCondition(rs.getBoolean("F_condition"));
		}
		return g;
	}
}
