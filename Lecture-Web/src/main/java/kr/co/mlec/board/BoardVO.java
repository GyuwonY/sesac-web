package kr.co.mlec.board;

/*
 *  자바빈즈 클래스
 *  1. 패키지 존재
 *  2. public class
 *  3. 멤버변수 private
 *  4. getter, setter 구현
 *  5. default 생성자
 */

public class BoardVO {
	private int no;
	private String title;
	
	public BoardVO() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
