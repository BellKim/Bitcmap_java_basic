package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.bbsParam;
import dto.bbsDto;

public class mainClass {
	
	public static void main(String[] args) throws IOException {
		//mybatis 설정 파일을 읽어 들인다. 
		//임폴트 : org.apache.ibatis.io.Resources;
	InputStream is = Resources.getResourceAsStream("mybatis/config.xml");//작성후 Throws 해주기. 그러나 try chatch 해줘도 가능.
	
	//sqlsessionfactory 객체를 취득
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	SqlSession session = factory.openSession();
	
//	List<bbsDto> list = session.selectList("allList");
//	for(bbsDto dto : list ) {
//		System.out.println(dto);
//	}
	
	
	
	
	/*
	 search 
	 	카테고리선택 : 아이디 컨텐츠 타이틀 중에 고른후 검색설정을 한다.  
	 */
	bbsParam bbp = new bbsParam("title", "글쓰지마" );
	
	List<bbsDto> searchlist = session.selectList("search", bbp);
	
	for(bbsDto bbs : searchlist) {
		System.out.println(bbs);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}//end of main

}//end of class
