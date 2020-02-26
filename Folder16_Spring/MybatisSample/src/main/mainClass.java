package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.memberDto;

public class mainClass {
	
	//1. xml 파일 작성
	//2. DB테이블작성
	//3. DTO 작성
	//4. main문 작성 
	//5. 

	public static void main(String[] args) throws IOException {
			//mybatis 설정 파일을 읽어 들인다. 
			//임폴트 : org.apache.ibatis.io.Resources;
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");//작성후 Throws 해주기. 그러나 try chatch 해줘도 가능.
		
		//sqlsessionfactory 객체를 취득
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//톰켓 혹은 서버의 session 과 mybatis의 session 은 전혀 다른것이다. import 할떄 주의해서 추가할것.

		//sqlsession 객체를 취득 <== 실질적으로 데이터를 write, read 하기 위한 객체.
		SqlSession session = factory.openSession();
		
		
		//membermepper이동 gn <insert id="add" parameterType="dto.membeDto"> 작성해준다. 
		
/*	
		//insert 
//		memberDto dto = new memberDto("ddd", "333", "Ccc@abc.de");
//		memberDto dto = new memberDto("bbb", "111", "bbb@abc.de");
//		memberDto dto = new memberDto("ccc", "333", "Ccc@abc.de");
		int n = session.insert("add", dto);
		
		
		if(n>0) {
			session.commit();
			System.out.println("추가 성공 ");
		}else {
			session.rollback();
			System.out.println("추가 실패 ");
		}//실행시에는 java application 을 사욯해야한다. 
*/	
	
		
		
		
		
		
/*		
		String id = "bbb";
		int n = session.delete("remove", id);
		
		
		if(n>0) {
			session.commit();
			System.out.println("삭제 성공 ");
		}else {
			session.rollback();
			System.out.println("삭제 실패 ");
		}//실행시에는 java application 을 사욯해야한다. 
	*/
		
	/*	
		memberDto dto = new memberDto("ccc", null, "");
		int n = session.delete("removeObj", dto);

		if(n>0) {
			session.commit();
			System.out.println("삭제 성공 ");
		}else {
			session.rollback();
			System.out.println("삭제 실패 ");
		}//실행시에는 java application 을 사욯해야한다. 
	*/
		
		
		//update 
		
	//	select		find
//		String id="ccc";
//		memberDto dto = session.selectOne("find", id);
//		System.out.println(dto.toString());
		
		
		//select list 
//		List<memberDto> list = session.selectList("alllist"); //리스트가 생성이 되어서 넘어오게된다.
//		for(memberDto mem : list) {
//			System.out.println(mem.toString());
//		}
		
		//bbs
		
		//insert, delete, select, selectlist, update  전부 해오는것. 
		//search 는 수업해준다. 


	}//end of main

}//end of class
