package kr.co.infopub.chapter.s105;

public class CardMain2 {
	
	public static void main(String[] args) {
		
		Card c1 = new Card("H4");
		Card c2 = new Card("H4");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.getCardVal());
		
		System.out.println(c2.getCardVal());
		System.out.println(c1.equals(c2)); //cardVal()을 비교한다.
		
		System.out.println((int)(c1.getCardVal().charAt(0)));
		System.out.println((int)(c1.getCardVal().charAt(1)));
		System.out.println((int)'c');
		System.out.println((int)'H');
		System.out.println((int)'A');
		
	}

}
