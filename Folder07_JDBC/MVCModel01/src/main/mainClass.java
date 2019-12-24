package main;

import DB.DBCONNECTON;
import view.accountView;
import view.loginView;

public class mainClass {

	public static void main(String[] args) {
//		new accountView();
		DBCONNECTON.initConnection();
		new loginView();

	}

}
