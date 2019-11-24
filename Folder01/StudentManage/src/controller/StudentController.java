package controller;

import java.util.ArrayList;

import dto.StudentDTO;

public class StudentController {
	ArrayList<StudentDTO> list;
	
	public StudentController() {
		list = new ArrayList<StudentDTO>();
		StudentDTO st0 = new StudentDTO();
		StudentDTO st1 = new StudentDTO();
		StudentDTO st2 = new StudentDTO();
		
		st0.setStudentNo(0);
		st0.setName("신이나");
		st0.setMajor("중국어");
		st0.setKor(90);
		st0.setEng(80);
		st0.setMath(50);
		
		st1.setStudentNo(1);
		st1.setName("신삼나");
		st1.setMajor("중국어");
		st1.setKor(90);
		st1.setEng(80);
		st1.setMath(50);
		
		st2.setStudentNo(2);
		st2.setName("신사나");
		st2.setMajor("중국어");
		st2.setKor(90);
		st2.setEng(80);
		st2.setMath(50);
		
		list.add(st0);
		list.add(st1);
		list.add(st2);
	}//end of studentController
	
	
	
	public ArrayList<StudentDTO> selectAll(){
		return list;
	}

	public StudentDTO select(int index){
		return list.get(index);
	}
	

	public void insert(StudentDTO studentDTO){
		int lastId = list.get(list.size()-1).getStudentNo() +1;
		studentDTO.setStudentNo(lastId);
		list.add(studentDTO);
		
	}
	
	public void update(StudentDTO studentDTO) {
		list.set(list.indexOf(studentDTO), studentDTO);
	}
	

	public void delete(StudentDTO studentDTO) {
		list.remove(studentDTO);
	}
	
	
	

}//end of class
