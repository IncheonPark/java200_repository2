// 객체 비교를 이용하여 카드 정렬하기

package kr.co.infopub.chapter.s107;

public class CardCaseMain {
	
	public static void main(String[] args) {
		CardCase cc = new CardCase();
		cc.make();
		cc.print();
		System.out.println("-----------------");
		cc.shuffle();
		cc.print();
		System.out.println("-----------------");
		cc.sort();
		cc.print();
		System.out.println("-----------------");
		cc.rsort();
		cc.print();
	}

}
