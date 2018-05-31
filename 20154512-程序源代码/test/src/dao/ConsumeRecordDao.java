package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import model.ConsumeRecord;
import db.DBUtil;

public class ConsumeRecordDao {

	public void add(ConsumeRecord g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into ConsumeRecord (C_Id,C_time,C_cardreader_Id,C_money) values (?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getId());
		ptmt.setString(2, g.getTime());
		ptmt.setString(3, g.getCardreader_Id());
		ptmt.setFloat(4, g.getMoney());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(ConsumeRecord g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update ConsumeRecord set C_money=? where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setFloat(1, g.getMoney());
		ptmt.setString(2, g.getId());
		ptmt.execute();
	}

	public java.util.List<ConsumeRecord> consumeRecords() throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from ConsumeRecord");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		List<ConsumeRecord> gs = new ArrayList<ConsumeRecord>();
		ConsumeRecord g = null;
		while (rs.next()) {
			g = new ConsumeRecord();
			g.setId(rs.getString("C_Id"));
			g.setCardreader_Id(rs.getString("C_cardreader_Id"));
			g.setMoney(rs.getFloat("C_money"));
			g.setTime(df.format(rs.getTimestamp("C_time")));
			gs.add(g);
		}
		return gs;
	}
	public java.util.List<ConsumeRecord> consumeRecord(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		String sql = "select * from ConsumeRecord where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		List<ConsumeRecord> gs = new ArrayList<ConsumeRecord>();
		ConsumeRecord g = null;
		while (rs.next()) {
			g = new ConsumeRecord();
			g.setId(rs.getString("C_Id"));
			g.setCardreader_Id(rs.getString("C_cardreader_Id"));
			g.setMoney(rs.getFloat("C_money"));
			g.setTime(df.format(rs.getTimestamp("C_time")));
			gs.add(g);
		}
		return gs;
	}
	/*public ConsumeRecord consumeRecord(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		ConsumeRecord g = null;
		String sql = "select * from ConsumeRecord where C_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		while (rs.next()) {
			g = new ConsumeRecord();
			g.setId(rs.getString("C_Id"));
			g.setCardreader_Id(rs.getString("C_cardreader_Id"));
			g.setMoney(rs.getFloat("C_money"));
			g.setTime(df.format(rs.getTimestamp("C_time")));
		}
		return g;
	}*/
}
