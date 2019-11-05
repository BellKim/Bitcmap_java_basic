package day02;
//클래스 설계해보기
//클래스를 설계할때 중요한것은 어떤 필드를 구상하고 
//또 그 클래스가 어떤메소드를 실행할지를 고민해야한다.

//필드를 구상할때는 제일먼져 int id 를 선언하여 <<<<<<<< private int id;
//관리번호를 가질 수 있게 한다.
//
//메소드의경우 toString()과 기본 생성자는 만들어주는것이 좋다.

//spring식으로 표현하면
//테이블하나당3개의 클래스가 나오게된다
//데이터를담는클래스하나(Data Transfer Object/Value Object)-> model
//DB와토인을 담당하는클래스하나 (Controller)	model,view를 상호연결
//화면으로쏴주는클래스하나(Viewer)			->view
//이렇게 model - view - controller로 분리해서 개발하는 패턴을 
//MVC패턴이라고한다.

public class Movie {
	private int id;
	private String title;
	private int length;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", length=" + length + "]";
	}
	
//	메소드의경우
//	toString()을 만ㄷ르어 주는것이 좋다.
	public Movie() {
		id = 0;
		title = "";
		length = 0;
	}


	public Movie(int id, String title, int length) {
		super();
		this.id = id;
		this.title = title;
		this.length = length;
	}
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setId(0);
		movie.setLength(95);
		movie.setTitle("타이타닉");
		System.out.println(movie);
		
		Movie movie2 = new Movie(10, "부산행", 290);
		System.out.println(movie2);
		
		
		
		
	}
	
	
	
	
}//end of class
