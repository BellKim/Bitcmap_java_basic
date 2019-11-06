package controller;
//실제론 DATABASE와 통신을 해서
//database에 데이터를
//입력(create)
//가져오기(Retrive)
//수정(update)
//삭제(drop)
//하지만 우리는 Database(DB)가 없으므로 그런기능까지는 생략한다.

import java.util.ArrayList;

import dto.MovieDTO;

public class MovieController {
	ArrayList<MovieDTO> list; //리스트를 movieDTO로 명명.
	
//	private ArrayList<MovieDTO> selectAll() {
//
//		return Array
//	} DB있을때 사용하는틀.
	
	public MovieController() {
		list = new ArrayList<MovieDTO>();//list는 ArrayList<movieDTO> 로 껍대기 선언
		MovieDTO s1 = new MovieDTO();
		MovieDTO s2 = new MovieDTO();
		MovieDTO s3 = new MovieDTO();
		
		s1.setId(0);
		s1.setTitle("어둠의 천사");
		
		s2.setId(0);
		s2.setTitle("어둠의 천사");
		
		s3.setId(0);
		s3.setTitle("어둠의 천사");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
	
	}//end of MovieController class


	//select, insert, update, delete
	
	
	
	
	

}
