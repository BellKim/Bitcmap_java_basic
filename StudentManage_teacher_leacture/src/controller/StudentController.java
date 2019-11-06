package controller;

import java.util.ArrayList;

import dto.StudentDTO;
//selectAll(), select(id), insert(StudentDTO)
//update(StudentDTO), delete(StudentDTO)
public class StudentController {
	ArrayList<StudentDTO> list;
	public StudentController() {
		list=new ArrayList<StudentDTO>();
		StudentDTO s= new StudentDTO();
		s.setStudentNo(0);
		s.setName("김가나");
		s.setMajor("독이렁");
		s.setKor(40);
		s.setEng(55);
		s.setMath(66);
		
		StudentDTO s1= new StudentDTO();
		s1.setStudentNo(0);
		s1.setName("김가나");
		s1.setMajor("독이렁");
		s1.setKor(40);
		s1.setEng(55);
		s1.setMath(66);
		
		StudentDTO s2= new StudentDTO();
		s2.setStudentNo(0);
		s2.setName("김가나");
		s2.setMajor("독이렁");
		s2.setKor(40);
		s2.setEng(55);
		s2.setMath(66);
		
		list.add(s);
		list.add(s1);
		list.add(s2);
		
		
		
	}//studentcontroller
	public StudentDTO select(int index) {
		return list.get(index);
	}
	public ArrayList<StudentDTO> selectAll(){
		return list;
	}

	
	public void insert(StudentDTO studentDTO) {
		//우선 아이디 가져오기.
		int id = list.get(list.size()-1).getStudentNo();
		studentDTO.setStudentNo(id);
		list.add(studentDTO);
	}
	
	public void update(StudentDTO s) {
		list.set(list.indexOf(s), s);
	}
	
	public void delete(StudentDTO s) {
		list.remove(s);
	}

	
	
	
	

}//end of class
