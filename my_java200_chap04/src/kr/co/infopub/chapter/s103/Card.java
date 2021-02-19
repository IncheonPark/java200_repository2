// 객체와 은닉화(Encapsulation) 이해하기

package kr.co.infopub.chapter.s103;

public class Card {
	
	// 데이터 보호 - 은닉화 - 접근 제한자 private
	private String cardVal;
	
	// 멤버 접근 메서드
	public String getCardVal() {
		return cardVal;
	}
	
	// 기본 생성자 - 멤버 초기화
	public Card() {
		this("H2"); //22행의 Card("H2")를 호출한다. 
		// this.cardVal = "H2"; 동일
		
	}
	
	public Card(String s) {
		this.cardVal = s;
	}
	
	// 복사 생성자
	public Card(Card c) {
		this(c.getCardVal()); // this.cardVal = c.getCardVal(); 동일
	}
	
	@Override
	public String toString() {
		return "[" + cardVal + "]";
	}

}
