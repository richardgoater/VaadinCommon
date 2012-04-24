package uk.co.richardgoater.common.hibernate;

import org.hibernate.dialect.MySQLDialect;
import java.sql.Types;

public class MySQLDialectWithBooleanFix extends MySQLDialect {

	public MySQLDialectWithBooleanFix() {
		super();
		registerColumnType(Types.BIT, "tinyint(1)");
	}

}
