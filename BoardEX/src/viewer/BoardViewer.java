package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controller.BoardController;
import controller.CommentController;
import controller.MemberController;
import dto.BoardDTO;
import dto.CommentDTO;
import dto.MemberDTO;

public class BoardViewer {
	public void showList(BoardController boardController, MemberController memberController,
			CommentController commentController, Scanner scan, MemberDTO logInUser) {
//		게시글 목록을 보여주는 메소드
		ArrayList<BoardDTO> list = boardController.selectAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		System.out.println("=========================");
		System.out.println("글번호 \t 제목\t 작성자\t 날씨\t");
		for (BoardDTO b : list) {
			System.out.printf("%d\t%s\t%s\t%s\n", b.getId(), b.getTitle(),
					memberController.getWriterName(b.getWriterId()), sdf.format(b.getUpdateDate().getTime()));
		}
		System.out.println("1. 새로작성    2. 개별보기 ");
		int choice = scan.nextInt();
		scan.nextLine();
		if (choice == 1) {
			// 글 새로작성 코드
			write(boardController, logInUser, scan);
			showList(boardController, memberController, commentController, scan, logInUser);

		} else if (choice == 2) {
			// 글 번호 선택해서 개별보기 코드
			System.out.println("개별 보기할 글 번호를 입력하세요 : ");
			int boardId = scan.nextInt();
			showOne(boardController, memberController, commentController, logInUser, scan, boardId);
		}
	}// end showList

	public void write(BoardController boardController, MemberDTO logInUser, Scanner scan) {
		BoardDTO b = new BoardDTO();
		b.setWriterId(logInUser.getId());
		b.setWrittenDate(Calendar.getInstance());
		b.setUpdateDate(Calendar.getInstance());
		System.out.print("======================");
		System.out.println("제목");
		System.out.print("> ");
		b.setTitle(scan.nextLine());
		System.out.print("======================");
		System.out.println("내용");
		System.out.print("> ");
		b.setContent(scan.nextLine());
		boardController.insert(b);
	}

	private void showOne(BoardController boardController, MemberController memberController,
			CommentController commentController, MemberDTO logInUser, Scanner scan, int boardId) {
		ArrayList<CommentDTO> commentList = commentController.selectByBoardId(boardId);
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분 ss초");

		BoardDTO selectedBoard = boardController.selectOne(boardId);

		if (selectedBoard == null) {
			System.out.println("게시글이 없습니다.");
		} else {
			System.out.println("==========");
			System.out.println("제목: " + selectedBoard.getTitle());
			System.out.println("==========");
			System.out.println("작성자: " + memberController.getWriterName(selectedBoard.getWriterId()));
			System.out.println("==========");
			System.out.println("작성일: " + sdf.format(selectedBoard.getWrittenDate().getTime()));
			System.out.println("수정일: " + sdf.format(selectedBoard.getUpdateDate().getTime()));
			System.out.println("==========");
			System.out.println("내용");
			System.out.println("==========");
			System.out.println(selectedBoard.getContent());
			System.out.println("==========");
			System.out.println("댓글");
			System.out.println("==========");
			for (CommentDTO c : commentList) {
				System.out.println(
						"댓글" + c.getId() + " " + c.getContent() + " " + memberController.getWriterName(c.getMemberId())
								+ " " + sdf.format(c.getUpdatedDate().getTime()));
			}

			if (selectedBoard.getWriterId() == logInUser.getId()) {
				System.out.println("1. 댓글달기 2. 수정, 3. 삭제, 4. 리스트로 돌아가기");
				System.out.print("> ");
				int choice = scan.nextInt();
				if (choice == 1) {
					// 댓글달기 시작

					CommentViewer commentViewer = new CommentViewer();
					commentViewer.insert(boardId, logInUser.getId(), scan, commentController);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);

				} else if (choice == 2) {
					// 수정 메소드 호출
					update(boardController, selectedBoard, scan);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);
				} else if (choice == 3) {
					// 삭제 메소드 호출
					delete(boardController, selectedBoard);
					showList(boardController, memberController, commentController, scan, logInUser);
				} else if (choice == 4) {
					showList(boardController, memberController, commentController, scan, logInUser);
				}
			} else {
				System.out.println("1. 댓글달기  2. 리스트로 돌아가기");
				int choice = scan.nextInt();
				if (choice == 1) {

					CommentViewer commentViewer = new CommentViewer();
					commentViewer.insert(boardId, logInUser.getId(), scan, commentController);
					showOne(boardController, memberController, commentController, logInUser, scan, boardId);

				} else if (choice == 2) {
					showList(boardController, memberController, commentController, scan, logInUser);

				}
			}
		}
	}

	private void delete(BoardController boardController, BoardDTO selectedBoard) {
		boardController.delete(selectedBoard);
	}

	private void update(BoardController boardController, BoardDTO selectedBoard, Scanner scan) {
		scan.nextLine();
		System.out.println("제목: ");
		selectedBoard.setTitle(scan.nextLine());
		System.out.println("내용: ");
		selectedBoard.setContent(scan.nextLine());
		boardController.update(selectedBoard);
	}// update
}// end class
