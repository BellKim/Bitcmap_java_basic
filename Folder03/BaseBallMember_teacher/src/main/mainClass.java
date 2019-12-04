package main;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
		
		dao.allprint();
		
		System.out.println();
		
		dao.memberSort();
		
		dao.insert();
		
		dao.allprint();
		
		System.out.println();
		
		dao.memberSort();
		
		
	}

}


