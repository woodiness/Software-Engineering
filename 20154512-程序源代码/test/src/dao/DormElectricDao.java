package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.CampusCard;
import model.DormElectric;
import db.DBUtil;

public class DormElectricDao {

	public void add(DormElectric g) throws Exception {

		Connection conn = DBUtil.getConnection();
		String sql = " " + "insert into DormElectric (E_dorm_Id,E_rest_Elec) values (?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getDorm_Id());
		ptmt.setFloat(2, g.getRest_Elec());
		ptmt.execute();
	}

	public void delete() {

	}

	public void update(DormElectric g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "UPDATE DormElectric SET E_Dorm_Id=?,E_rest_Elec=? WHERE  E_dorm_Id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, g.getDorm_Id());
		ptmt.setFloat(2, g.getRest_Elec());
		ptmt.setString(3, g.getDorm_Id());
		ptmt.execute();
	}

	public java.util.List<DormElectric> dormElectrics() throws Exception {

		Connection conn = DBUtil.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from DormElectric");
		List<DormElectric> gs = new ArrayList<DormElectric>();
		DormElectric g = null;
		while (rs.next()) {
			g = new DormElectric();
			g.setDorm_Id(rs.getString("E_dorm_Id"));
			g.setRest_Elec(rs.getFloat("E_rest_Elec"));
			gs.add(g);
		}
		return gs;
	}

	public DormElectric dormElectric(String dorm_Id) throws Exception {

		Connection conn = DBUtil.getConnection();
		DormElectric g = null;
		String sql = "select * from DormElectric where E_dorm_Id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, dorm_Id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new DormElectric();
			g.setDorm_Id(rs.getString("E_dorm_Id"));
			g.setRest_Elec(rs.getFloat("E_rest_Elec"));
		}
		return g;
	}
}
