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
	ArrayList<MovieDTO> list;
	
//	private ArrayList<MovieDTO> selectAll() {
//
//		return Array
//	} DB있을때 사용하는틀.
	
	public MovieController() {

		list = new ArrayList<MovieDTO>();
		MovieDTO m = new MovieDTO();
		m.setId(0);
		m.setLength(122);
		m.setTitle("라이온의 킹덤");
		
		
		MovieDTO m2 = new MovieDTO();
		m2.setId(1);
		m2.setLength(110);
		m2.setTitle("가을의 왕국");
		
		MovieDTO m3 = new MovieDTO();
		m3.setId(2);
		m3.setLength(221);
		m3.setTitle("피아노의 왕국");
		
		list.add(m);
		list.add(m2);
		list.add(m3);
		
		
	}
	
	public ArrayList<MovieDTO> selectAll(){
		return list;
	}
	public MovieDTO select(int index){
		return list.get(index);
	}
	public void insert(MovieDTO movieDTO){
		list.add(movieDTO);
	}
	public void update(MovieDTO movieDTO) {
		int index = list.indexOf(movieDTO);
		list.remove(index);
		list.add(index, movieDTO);
	}
	public void delete(MovieDTO movieDTO) {
		list.remove(movieDTO);
	}
	
	
	
	
	
	

}
