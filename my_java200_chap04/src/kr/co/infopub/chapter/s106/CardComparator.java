package kr.co.infopub.chapter.s106;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{
	
		@Override
		public int compare(Card a,Card b){
			//a가 b보다 크면 1, 작으면 -1, 같으면 0 반환.
			//문자열과 문자열을 비교해서 조건에 따라 숫자를 반환해야 한다.
			
			//카드 정렬 로직 구현
			if ((int)a.getCardVal().charAt(0) > (int)b.getCardVal().charAt(0)) {
				return 1;
			} 
			
			if ((int)a.getCardVal().charAt(0) < (int)b.getCardVal().charAt(0)) {
				return -1;
			}
			
			if ((int)a.getCardVal().charAt(0) == (int)b.getCardVal().charAt(0)){
				
				while((int)a.getCardVal().charAt(1) != 65 && (int)b.getCardVal().charAt(1) != 65) {
					
					if((int)a.getCardVal().charAt(1) > (int)b.getCardVal().charAt(1)) {
						return 1;
					} else {
						return -1;
					
					}
				}
				
				//카드 번호가 A일 경우 맨 앞으로 보낸다.
				if ((int)a.getCardVal().charAt(1) == 65) {
					return -1;
				}
				
				if ((int)b.getCardVal().charAt(1) == 65) {
					return 1;
				
			}
				
			
		}
			return 0;
	}
		
}
