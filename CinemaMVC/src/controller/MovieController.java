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
	
//	selectAll메소드는
//	DB에서 받아온 것들을 리스트에 담아서
//	viewer로 보내준다.
//	우리는DB가 따로 없으므로
//	컨트롤러가 생성되면서 3개의 영화를 리스트에 추가하고
//	그리스트를 프로그램종료 전까지 계속 사용하면서
//	유사DB처럼 사용하게 만든다.
	
	public ArrayList<MovieDTO> selectAll(){
//		우리가 만든DB리스트를 메소드가 호출할때 리턴해준다.
		return list;
	}
//	select method는 사용자가 입력한
//	번호르 받아서 ArrayList.get method를 사용해서
//	MovieDTO객체를 보내줍니다.
	public MovieDTO select(int index){
		return list.get(index);
	}
	
//	사용자가 새로 입력하면 만들어지는 movieDTO객체를
//	파라미터로 받아서 우리의 리스트에 추가해주는 메소드
	public void insert(MovieDTO movieDTO){
//		database에는 auto_increment라는
//		int를 1씩 증가시키면서 입력시켜주는 기능이 있지만
//		우리는 databawe가 없으므로 직접 만들어준다.
		int lastId = list.get(list.size()-1).getId() + 1;
		movieDTO.setId(lastId);
		list.add(movieDTO);
	}
	
//	사용자가 수정요청을 보낼때 같이 보내지는 movieDTO 객체를
//	기존에 있던 객체를삭제하고 해당 위치에  보내진 객체를 삽입하는 메소드
	public void update(MovieDTO movieDTO) {
		int index = list.indexOf(movieDTO);
		list.remove(index);
		list.add(index, movieDTO);
	}
	
//	사용자가 선택한 movieDOT 객체를 리스트에서 삭제하는 메소드
	public void delete(MovieDTO movieDTO) {
		list.remove(movieDTO);
	}
	
	
	
	
	
	

}
