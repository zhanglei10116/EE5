package com.tc23.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCTemplate {
	// 通用查询
	public void query(String sql, PrepareStamented ps, ResultSetter rs) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		if (ps != null) {
			ps.handle(pst);
		}
		ResultSet rSet = pst.executeQuery();
		if(rs!=null) {
			rs.handleResultSet(rSet);
		}
		DBUtil.close(conn, pst, rSet);
	}
	//增删改
	public int update(String sql, PrepareStamented ps, ResultSetter rs) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pst = conn.prepareStatement(sql);
		if (ps != null) {
			ps.handle(pst);
		}
		int i = pst.executeUpdate();		
		DBUtil.close(conn, pst, null);
		return i;
	}

	
}
