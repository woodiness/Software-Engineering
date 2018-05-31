package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.NetworkFlow;
import db.DBUtil;

public class NetworkFlowDao {

	public void add(NetworkFlow g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into NetworkFlow (N_Id,N_restMoney,N_monthlyRent,N_currentFlow) values (?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, g.getId());
		ptmt.setFloat(2, g.getRestMoney());
		ptmt.setInt(3, g.getMonthlyRent());
		ptmt.setFloat(4, g.getCurrentFlow());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(NetworkFlow g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE NetworkFlow SET N_Id=?,N_restMoney=?,N_monthlyRent=?,N_currentFlow=? WHERE  N_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getId());
		ptmt.setFloat(2, g.getRestMoney());
		ptmt.setInt(3, g.getMonthlyRent());
		ptmt.setFloat(4, g.getCurrentFlow());
		ptmt.setString(5, g.getId());
		ptmt.execute();
	}

	public java.util.List<NetworkFlow> networkFlows() throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from NetworkFlow");
		List<NetworkFlow> gs = new ArrayList<NetworkFlow>();
		NetworkFlow g = null;
		while (rs.next()) {
			g = new NetworkFlow();
			g.setId(rs.getString("N_Id"));
			g.setRestMoney(rs.getFloat("N_restMoney"));
			g.setMonthlyRent(rs.getInt("N_monthlyRent"));
			g.setCurrentFlow(rs.getFloat("N_currentFlow"));
			gs.add(g);
		}
		return gs;
	}

	public NetworkFlow networkFlow(String id) throws Exception {

		Connection conn = DBUtil.getConnection();
		// 3.通过数据库的连接操作数据库
		NetworkFlow g = null;
		String sql = "select * from NetworkFlow where N_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new NetworkFlow();
			g.setId(rs.getString("N_Id"));
			g.setMonthlyRent(rs.getInt("N_monthlyRent"));
			g.setRestMoney(rs.getFloat("N_restMoney"));
			g.setCurrentFlow(rs.getFloat("N_currentFlow"));
		}
		return g;
	}
}
