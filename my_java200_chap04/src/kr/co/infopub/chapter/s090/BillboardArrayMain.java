//네이버 웹사이트에서 정보를 읽어 리스트에 저장하기

package kr.co.infopub.chapter.s090;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class BillboardArrayMain {

	public static void main(String[] args) {
		
		ArrayList<String> htmls = new ArrayList<String>();
		String newUrls = "https://www.naver.com/";
		URL url = null;
		try {
			url = new URL(newUrls);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"),8);
			String line = null;
			while((line = reader.readLine()) != null) {
				if(!line.trim().equals("")) {
					htmls.add(line.trim());
				}
			}
		} catch (Exception e) {
			System.out.println("Billboard Parsing error !!");
		}
		// ArrayList에 저장된 문자열을 출력
		for(String str : htmls) {
			System.out.println(str);
		}
		
	}

}
