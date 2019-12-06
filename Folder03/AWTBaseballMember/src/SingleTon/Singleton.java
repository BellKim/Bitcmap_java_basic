package SingleTon;

import DAO.Insert;
import DAO.MainMenu;
import DAO.ShowAll;
import DAO.delete;
import DAO.sort;

public class Singleton {

	private static Singleton single = null;

	public MainMenu main;
	public Insert insert;
	public ShowAll showAll;
	public delete delete;
	public sort sort;

	

	private Singleton() {
		main = new MainMenu();
		insert = new Insert();
		showAll = new ShowAll();
		delete = new delete();
		sort = new sort();
		

	}

	public static Singleton getInstance() {
		if (single == null) {
			single = new Singleton();
		}
		return single;

	}// end mehthod

}// end class
