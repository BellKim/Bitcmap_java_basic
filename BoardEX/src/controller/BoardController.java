package controller;

import java.util.ArrayList;
import java.util.Calendar;

import dto.BoardDTO;

public class BoardController {
	ArrayList<BoardDTO> list;
	public BoardController() {
		list = new ArrayList<BoardDTO>();
		
		BoardDTO b = new BoardDTO();
		b.setId(0);
		b.setWriterId(1);
		b.setTitle("Title 00");
		b.setContent(" CONTENT00");
		b.setWrittenDate(Calendar.getInstance());
		b.setUpdateDate(Calendar.getInstance());
		
		
		BoardDTO b1 = new BoardDTO();
		b1.setId(1);
		b1.setWriterId(1);
		b1.setTitle("Title 01");
		b1.setContent(" CONTENT01");
		b1.setWrittenDate(Calendar.getInstance());
		b1.setUpdateDate(Calendar.getInstance());
		
		BoardDTO b2 = new BoardDTO();
		b2.setId(2);
		b2.setWriterId(2);
		b2.setTitle("Title 02");
		b2.setContent(" CONTENT02");
		b2.setWrittenDate(Calendar.getInstance());
		b2.setUpdateDate(Calendar.getInstance());
		
		BoardDTO b3 = new BoardDTO();
		b3.setId(3);
		b3.setWriterId(3);
		b3.setTitle("Title 03");
		b3.setContent(" CONTENT03");
		b3.setWrittenDate(Calendar.getInstance());
		b3.setUpdateDate(Calendar.getInstance());
		
		list.add(b);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
	}//BoardController()
	
	public ArrayList<BoardDTO> selectAll(){
		
		return list;
	}
	
	public ArrayList<BoardDTO> selectAll(int id){//오버로딩
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		for(int i=0; i< this.list.size(); i++) {
			if(this.list.get(i).getWriterId() == id) {
				list.add(this.list.get(i));
			}
		}
		return list;
	}
	
	public BoardDTO selectOne(int id) {
		for (BoardDTO b : list){
			if(b.getId() == id ) {
				return b;
			}
		}
		System.out.println("출력할 정보가 없습니다.\n(BOardController.selectOne() 으로부터 출력. )");
		return null;
	}//selectOne
	
	public void update(BoardDTO boardDto) {
		boardDto.setUpdateDate(Calendar.getInstance());
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).getId() == boardDto.getId()) {
				list.set(i, boardDto);
			}
		}
	}
	
	public void delete(BoardDTO boardDTO) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId() == boardDTO.getId()) {
				list.remove(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// end of class
