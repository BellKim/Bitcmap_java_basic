package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCLOSE {
	
	public DBCLOSE() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static void close(PreparedStatement psmt, Connection conn, ResultSet rs) {
			try {
				if(psmt !=null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				if(rs != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
