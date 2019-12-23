package jdbc;

public class JdbcTest {

	
	public JdbcTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DirverLoading Success! ");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
