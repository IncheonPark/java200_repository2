// static 사용법 익히기

package kr.co.infopub.chapter.s108;

import kr.co.infopub.chapter.s103.Card;

public class CardUtil {
	
	public static final int SUTDA = 2;
	public static final String[] SUIT = {"H", "C"};
	public static final String[] VALUE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T" };
	
	public static int toVal(Card c) {
		return toVal(c.getCardVal().charAt(1)); // "H6"에서 '6'
	}
	
	public static int toVal(Card c, int index) {
		return toVal(c.getCardVal().charAt(index)); //index에 따라 SUIT 또는 VALUE 얻기
	}
	
	public static int toVal(char cc) {
		int tot = 0;
		switch (cc) {
		case 'A' : tot = 1; break;
		case 'T' : tot = 10;  break;
		case 'J' : tot = 11; break;
		case 'Q' : tot = 12; break;
		case 'K' : tot = 13; break;
		default : tot = cc-'0'; break; // '2'부터 '9'는  -> 'n'-'0' = n 식으로 반환된다.
		}
		return tot;
	}

}
