package day04.chap02_interface;

import java.sql.Connection;

public class MysqlConnectionMaker implements ConnectionMaker{
	private String URL = "mySQL 연결주소";
	private String ID = "SQL 연결  i d ";
	private String PW = "mySQL 연결비밀번호";

	public Connection makeConnection() {
		Connection conn = null;
		System.out.println("myslq 연결!!! 됨!");
		//여기에 mysql 연결하는 코드 구현
		return conn;
	}
}//end of class
