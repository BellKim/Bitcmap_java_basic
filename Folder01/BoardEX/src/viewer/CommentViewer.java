package viewer;

import java.util.Scanner;

import controller.CommentController;
import dto.CommentDTO;

public class CommentViewer {
	public void insert(int boardId, int memberId, Scanner scan, CommentController commentController) {
		CommentDTO c = new CommentDTO();

		c.setBoardId(boardId);
		c.setMemberId(memberId);
		System.out.println("댓글 내용! : ");
		scan.nextLine();
		
		c.setContent(scan.nextLine());
		commentController.insert(c);

	}

}// end of class
