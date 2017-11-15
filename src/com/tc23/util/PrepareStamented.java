package com.tc23.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PrepareStamented {
	void handle(PreparedStatement pst) throws SQLException;
}
