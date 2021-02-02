//네이버 웹사이트에서 정보 읽어오기

package kr.co.infopub.chapter.s089;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BillboardMain3 {
	
	public static void main (String[] args) {
		
		String newUrls="https://www.naver.com/";
		URL url = null; //웹사이트 경로를 찾는 URL 클래스를 선언한다.
		try {
			url = new URL(newUrls); //주소 찾기
			//찾은 주소지에 빨대(reader) 꽂기
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"), 8);
			String line = null;
			while ((line = reader.readLine()) != null ) { //한 줄씩 읽어서
				if(!line.trim().equals("")) { //공백이 아니면 출력한다.
					System.out.println(line.trim());
				}
			}
		} catch (Exception e) {
			System.out.println("Billboard Parsing error !! ");
		}
		
		
	}

}
