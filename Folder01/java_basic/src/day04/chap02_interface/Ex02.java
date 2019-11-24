package day04.chap02_interface;

public class Ex02 {
//	Ex02-> DB연결시 연결하는 일련의 과정을 각각의 클래스파일로 쪼개둔다.
//	ConnectionMaker m = new MysqlConnectionMaker(); 일시,
//	Ex02-> connectionMaker-> MysqlConnectionMaker 로 연결되고
//	
//	ConnectionMaker m = new OracleConnectionMaker();
//	일경우 Ex02-> connectionMaker-> MysqlConnectionMaker 로 연결되고 로 
//	객체의 자동연결이됨. 
//	
//	인터페이스인 ConnectionMaker 의경우 각각을 사용하려면 OracleConnectionMaker와 MysqlConnectionMaker 에 
//	"implements ConnectionMaker" 로 의존성주입(인터페이스에 연결) 해줘야한다.
	
	public static void main(String[] args) {
		
		ConnectionMaker m = new MysqlConnectionMaker();
//		ConnectionMaker m = new OracleConnectionMaker();

		
		StudentController controller = new StudentController(m);
	}

}
