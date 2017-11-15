package com.tc23.dao;

import java.util.List;

import com.tc23.bean.Goods;

public interface UserDao {
	List<Goods> queryGood();
	int buyGoods(String id);
}
