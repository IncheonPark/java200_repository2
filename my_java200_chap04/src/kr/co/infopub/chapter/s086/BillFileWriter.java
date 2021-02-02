//빌보드 차트 정보를 파일로 저장하기

package kr.co.infopub.chapter.s086;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import kr.co.infopub.chapter.s083.Billboard;

public class BillFileWriter {
	
	public static void main(String[] args) {
		
		Billboard b1 = new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
		Billboard b2 = new Billboard(2, "Despacito", 2, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
		Billboard b3 = new Billboard(3, "Despacito", 3, "https://www.billboard.com/images/pref_images/q61808osztw.jpg","luis fonsi");
		
		ArrayList<Billboard> bblist = new ArrayList<>();
		bblist.add(b1);
		bblist.add(b2);
		bblist.add(b3);
		
		File f = new File("billboard");
		if(!f.exists())	{
			f.mkdirs();
		}
		//try (객체 생성 new){} 는 {}가 끝나면 자동으로 new 객체를 close()한다. finally 구문이 필요없는 편리한 예외 처리이다.
		//java.io는 closable(AutoClosable) 인터페이스를 구현했기 때문에 try(IO 객체 생성)는 {}가 끝나면 자동으로 close()된다.
		//"billboard" 디렉토리에 "bill.txt" 파일 이름으로 저장한다. "bill.txt"가 이미 있다면 내용을 모두 지우고 새로(false) 저장한다.
		try (PrintWriter pw = new PrintWriter(new FileWriter("billboard\\bill.txt",false),true)) {
			//한줄 저장하고 자동으로 파일로 확실하게 저장하도록 PrintWriter의 flush를 true로 한다.
			for(Billboard bb : bblist) {
				pw.println(bb);
				System.out.println("bill.txt 생성 성공.");
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
