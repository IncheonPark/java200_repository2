package kr.co.infopub.chapter.s106;

import java.util.Comparator;

import kr.co.infopub.chapter.s106.Card;
import kr.co.infopub.chapter.s106.CardUtil;

public class CardComp implements Comparator<Card> {
	
	@Override
	public int compare(Card c1, Card c2) {
		// 문자열 compareTo() - 사전식 비교
		if(c1.getCardVal().charAt(0) > c2.getCardVal().charAt(0)) {
			return 1;
		} else if(c1.getCardVal().charAt(0) < c2.getCardVal().charAt(0)) {
			return -1;
		} else {
			//toVal()을 쓰는 이유 -> A를 1로 바꾸기 위해 사용
			if(CardUtil.toVal(c1.getCardVal().charAt(1)) > CardUtil.toVal(c2.getCardVal().charAt(1))) {
				return 1; 
			} else if (CardUtil.toVal(c1.getCardVal().charAt(1)) < CardUtil.toVal(c2.getCardVal().charAt(1))) {
				return -1;
			} else 
				return 0;
		}
	}

}
