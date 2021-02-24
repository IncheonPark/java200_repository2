// 리스트에 서로 다른 카드 20개 저장하기

package kr.co.infopub.chapter.s106;

import java.util.ArrayList;
import java.util.Collections;
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
		Collections.sort(cards, new CardComparator());
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
