package com.tc23.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetter {
	void handleResultSet(ResultSet rs) throws SQLException;
}
