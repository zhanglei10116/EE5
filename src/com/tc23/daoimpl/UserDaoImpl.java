package com.tc23.daoimpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tc23.bean.Goods;
import com.tc23.dao.UserDao;
import com.tc23.util.JDBCTemplate;

public class UserDaoImpl extends JDBCTemplate implements UserDao{
	List<Goods> goodList  = new ArrayList<>();	
	int count=0;
	int stock=0;
	@Override
	public List<Goods> queryGood() {	
		String sql = "select * from goods";
		try {
			query(sql, null, rs -> {
                while(rs.next()) {
                    Goods g = new Goods();
                    g.setId(rs.getInt(1));
                    g.setName(rs.getString(2));
                    g.setPrice(rs.getInt(3));
                    g.setStock(rs.getInt(4));
                    goodList.add(g);
                }

            });
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodList;
	}

	@Override
	public int buyGoods(String id) {
		String sql = "select stock from goods where id = ?";
		try {
			query(sql, pst -> pst.setString(1, id), rs -> {
                    if (rs.next()) {
                        stock = rs.getInt(1);
                    }
            });
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		if (stock>0) {
			String sql1 = "update goods set stock = stock-1 where id = ?" ;
			try {
				count = update(sql1, pst -> pst.setString(1, id ), null);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}else {
			count = 0;
		}
		
		return count;
	}

}
