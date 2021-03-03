// equals overriding을 이용하여 카드 값이 같으면 같은 객체로 만들기

package kr.co.infopub.chapter.s107;

public class Card {
	
	private String cardVal;
	
	public String getCardVal() {
		return cardVal;
	}
	
	public Card() {
		
		int suit = (int)(Math.random()*CardUtil.SUIT.length); // 0~1
		int value = (int)(Math.random()*CardUtil.VALUE.length); //0~9
		cardVal = CardUtil.SUIT[suit] + CardUtil.VALUE[value];
		
	}
	
	public Card(String s) {
		this.cardVal = s;
	}
	
	public Card(Card c) {
		this(c.getCardVal());
	}
	
	@Override
	public String toString() {
		return "[" + cardVal + "]";
	}
	
	//Eclipse-Source-Generate hashCode() and equals()를 이용하여 자동으로 만들기
	@Override
	public int hashCode() {
		final int prime = 31; 
		//equals() 오버라이딩하면 hashCode()를 오버라이딩해야 한다. 형식적으로 2자리 이상의 소수(PrimeNumber)를 더한다.
		int result = 1;
		result = prime * result + ((cardVal == null) ? 0 : cardVal.hashCode());
		
		return result;
	}
	
	// 카드 값과 카드 값을 일대일로 비교한다.
	@Override
	public boolean equals(Object obj) { //부모인 Object의 equlas() 메서드가 아규먼트를 Object로 받는다.
		Card cb = (Card)obj; //Card를 활용하기 위해 캐스팅한다.
		if(cardVal.equals(cb.getCardVal())) {
			return true;
		} else {
			return false;
		}
	}

}
