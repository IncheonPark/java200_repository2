// 람다를 이용하여 카드 정렬하기

package kr.co.infopub.chapter.s108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardCase {
	
	// aggregation : CardCase는 Card로 구성된다.
	private List<Card> cards = new ArrayList<Card>();
	
	//내용 초기화
	public CardCase() {
		cards.clear();
	}
	
	// List 반환
	public List<Card> getCards() {
		return cards;
	}
	
	// List에 저장된 Card의 개수
	public int count() {
		return cards.size(); // 저장된 Card 개수
	}
	
	//List의 index번째 Card
	
	public Card getCard(int index) {
		return cards.get(index); // index번째 Card
	}
	
	// 서로 다른 카드 20장 만들기
	public void make() {
		cards.clear();
		int suit = CardUtil.SUIT.length;
		int value = CardUtil.VALUE.length;
		int count = 0;
		// 서로 다른 20개의 카드를 만든다.
		while(count != value*suit ) { //20이 되기 전까지
			Card c = new Card();
			if(!cards.contains(c)) { //리스트에 같은 카드가 없다면 실행 contains -> equals()를 이용해 비교
				cards.add(c);
				count++;
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards); // 카드 섞기
	}
	
	public void sort() {
		Comparator<Card> cmp = new Comparator<Card>() {
			@Override
			public int compare(Card c1, Card c2) {
				return c1.getCardVal().compareTo(c2.getCardVal());
			}
		};
		cards.sort(cmp);
	}
	
	//CardRomp 클래스가 없다.
	public void rsort() {
		cards.sort(new Comparator<Card>() {
			@Override
			public int compare(Card c1, Card c2) {
				return -c1.getCardVal().compareTo(c2.getCardVal());
			}
		});
	}
	
	// sort를 Lambda로 구현
	public void lambdasort() {
		cards.sort((c1, c2) -> {return c1.getCardVal().compareTo(c2.getCardVal());}); 
		//클래스와 메서드 식별자 삭제, 파라미터 타입 삭제
	}
	
	// rsort를 Lambda로 구현
	public void lambdarsort() {
		cards.sort((c1, c2) -> {return -c1.getCardVal().compareTo(c2.getCardVal());});
	}
	
	public void print() {
		int value = CardUtil.VALUE.length; //10
		for(int i = 0; i < cards.size(); i ++) { //20번 실행
			Card c = cards.get(i);
			System.out.printf("%s", c.toString());
			if((i+1)%value == 0) {
				System.out.println();
			}
		}
	}

}
