// main7 : csv 읽기

package kr.co.infopub.chapter.s094;

import java.io.BufferedReader;
import java.io.FileReader;

import kr.co.infopub.chapter.s093.RequestFromBillboardHot;

// csv
public class BillboardMain7 {
	
	//rank=1 --> 1
	public static String cut(String msg) {
		String val = msg.substring(msg.indexOf("=")+1);
		return val;
	}
	
//	String[] msgs = {"rank=1", "song=Despacito", "lastweek=1"
//			,"imagesrc=https://static.billboard.com/files/2021/02/Sabrina-Carpenter-Skin-screenshot-2021-billboard-1548-1612289327-compressed.jpg"
//			,"artist=luis fonsi" };
	
	public static void show(String msg) {
		System.out.println("----------------------");
		String[] msgs = msg.split(",");
		System.out.println(msgs[0]);
		String rank = cut(msgs[0]).trim();
		System.out.println(msgs[0].trim());
		System.out.println(cut(msgs[0]).trim());
		String song = cut(msgs[1]).trim();
		
		String lastweek = cut(msgs[2]).trim();
		String imagesrc = cut(msgs[3]).trim();
		String artist = cut(msgs[4]).trim();
		
		String sf = String.format("%s, %s, %s, %s, %s", 
				rank, song, lastweek, imagesrc, artist);
		System.out.println(sf);
	}
	
	public static void main(String[] args) {
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String a = "https://www.billboard.com/charts/hot-100/";
		String rs = rfw.getTimeDate(a);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("billboard\\"+rs+".csv"));
			String msg = "";
			while((msg = br.readLine()) != null) {
				show(msg);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
