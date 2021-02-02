//빌보드 차트를 리스트에 저장하고 출력하기

package kr.co.infopub.chapter.s085;

import java.util.ArrayList;

import kr.co.infopub.chapter.s083.Billboard;

public class BillboardArrayMain {
	
	public static void main(String[] args) {
		
		ArrayList<Billboard> bills = new ArrayList<>();
		bills.add(new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi"));
		bills.add(new Billboard(2, "Despacito", 2, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi"));
		bills.add(new Billboard(3, "Despacito", 3, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi"));
		System.out.println(bills.size());
		showAbout(bills.get(0));
		bills.remove(1);
		System.out.println(bills.size());
		System.out.println("----------------");
		for(Billboard bb : bills) {
			showAbout(bb);
		}
		
		
	}
	
	public static void showAbout(Billboard bb ) {
		
		String sf = String.format("%d, %s, %d, %s, %s",  bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
		System.out.println(sf);
		
	}

}
