package kr.co.infopub.chapter.s104;

public class Card {
	
	private String cardVal;
	
	public String getCardVal() {
		return cardVal;
	}
	
	public Card() {
		int suit = (int)(Math.random()*CardUtil.SUIT.length); // 0~1 사이의 임의의 정수 반환
		int value = (int)(Math.random()*CardUtil.VALUE.length); // 0~9사이의 임의의 정수 반환
		cardVal = CardUtil.SUIT[suit] + CardUtil.VALUE[value]; //문자열 + 문자열
		
	}
	
	public Card(String s) {
		this.cardVal = s;
	}
	
	public Card(Card c) {
		this(c.getCardVal());
		//this.cardVal = c.getCardVal();
	}
	
	@Override
	public String toString() {
		return "[" + cardVal + "]";
	}

}
