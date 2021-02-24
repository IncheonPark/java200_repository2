package kr.co.infopub.chapter.s104;

public class CardMain {
	
	public static void main(String[] args) {
		
		Card c1 = new Card("H4");
		Card c2 = new Card("H4");
		Card c3 = new Card(c1); //복사 생성자
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.hashCode());
		System.out.println(c1.equals(c2)); // hashCode 비교 - 중요 - false
		System.out.println(c1.equals(c3)); // hashCode 비교 - 중요 - false
		
		System.out.println(c1.getCardVal());
		System.out.println(c2.getCardVal());
		System.out.println(c1.getCardVal().hashCode());
		System.out.println(c2.getCardVal().hashCode());
		System.out.println(c1.getCardVal().equals(c2.getCardVal())); //true
		System.out.println(c1.getCardVal().equals(c3.getCardVal())); //true
		
		
		
		for(int i=0; i < CardUtil.SUIT.length; i++) {
			for (int j = 0; j < CardUtil.VALUE.length; j++) {
				Card c = new Card();
				System.out.printf("%s", c); // c.toString()
				System.out.print(c.hashCode()+"\t"); //해쉬코드 출력
			}
			System.out.println();
		}
		
	}

}
