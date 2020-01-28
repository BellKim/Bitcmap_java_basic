package dao;

import dto.BbsDto;

public class BbsDao {
	
	private static BbsDao dao = new BbsDao();
	
	private BbsDao() {
		
	}
	
	public static BbsDao getInstance() {
		
		return dao;
		
	}//end class
	
	
	public boolean writeBbs(BbsDto bbs) {
		String sql = " ";
		
		
		
		
		
		return true;
	}
	

}//end class
