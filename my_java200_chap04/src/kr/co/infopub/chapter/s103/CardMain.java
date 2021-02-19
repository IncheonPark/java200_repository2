package kr.co.infopub.chapter.s103;

public class CardMain {
	
	public static void main(String[] args) {
		
		String csuit1 = "H", cvalue1 = "6"; //suit + value
		String csuit2 = "H", cvalue2 = "3";
		
		Card c1 = new Card("H6");
		Card c2 = new Card(csuit1 + cvalue1);
		Card c3 = new Card();
		Card c4 = new Card(csuit2 + cvalue2);
		
		System.out.printf("c1 : %s, c2: %s, c3: %s,c4 : %s \n",  c1, c2, c3, c4);
		System.out.println(c1.equals(c2)); //해시코드는 다름 >> false
		System.out.println(c1.getCardVal().equals(c2.getCardVal())); //값 동일 "H6" >> true
		// 참조 타입은 equals()로 비교할 것.
		
	}

}
