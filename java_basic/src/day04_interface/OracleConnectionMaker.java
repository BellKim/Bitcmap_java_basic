package day04_interface;

import java.sql.Connection;

public class OracleConnectionMaker implements ConnectionMaker{
	private final String URL = "오라클 연결주소";
	private final String ID = "Oracle 연결 ID";
	private final String PW = "Oracle 연결 PW";
	public Connection makeConnection() {
		Connection conn = null;
		System.out.println("ORACLE에 연결됨! ");
		return conn;
	}
}//end of class

