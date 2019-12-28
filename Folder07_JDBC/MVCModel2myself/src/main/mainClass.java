package main;

import main.singleton.Singleton;
import template.db.DBConnection;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
		

	}

}
