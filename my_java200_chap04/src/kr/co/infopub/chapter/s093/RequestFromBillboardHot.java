//빌보드에서 이번주 차트 100 데이터 읽어와서 리스트에 저장 및 출력

package kr.co.infopub.chapter.s093;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import kr.co.infopub.chapter.s083.Billboard;
import kr.co.infopub.chapter.s092.RestDay;

public class RequestFromBillboardHot {
	
	ArrayList<Billboard> billboards = new ArrayList<Billboard>();
	
	public ArrayList<Billboard> getBillboards() {
		return billboards;
	}
	
	public RequestFromBillboardHot() {
		billboards.clear();
	}
	
	public void getBillboardData(String newUrls) {
		
		billboards.clear();
		System.out.println(newUrls);
		HttpGet request = new HttpGet(newUrls); // HttpGet 생성
		Document doc = null;
		// 자동 finally 처리용
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(request)) {
					
					StringBuffer sb = new StringBuffer();
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						String result = EntityUtils.toString(entity);
						sb.append(result); //모든 내용을 읽어온다.
					}
					
					doc = Jsoup.parse(sb.toString()); // 읽은 내용을 Document로 만든다.
					String r1="flex--column.flex--xy-center.";
				    String r2="flex--no-shrink > span.chart-element__rank__number";
				    String o1="span.chart-element__information__song.";
				    String o2="text--truncate.color--primary";
				    String i1="span.chart-element__information__artist.";
				    String i2="text--truncate.color--secondary";
				    String rank="li > button > span.chart-element__rank."+r1+r2;
				    String song="li > button > span.chart-element__information > "+o1+o2;
				    String singer="li > button > span.chart-element__information > "+i1+i2;
				    //String image="li > button > span.chart-element__image.flex--no-shrink";
				    
					Elements ranks = doc.select(rank); //랭킹 : 모든 내용에서 랭킹 찾기
					Elements songs = doc.select(song); //노래 : 모든 내용에서 노래 찾기
					Elements singers = doc.select(singer); //가수 : 모든 내용에서 가수 찾기
					//Elements images = doc.select(image); // 이미지 : 모든 내용에서 이미지 찾기
					for(int i=0; i < ranks.size(); i++) {
						Billboard board = new Billboard();
						board.setRank(Integer.parseInt(ranks.get(i).text())); //형변환
						board.setSong(songs.get(i).text());
						board.setArtist(singers.get(i).text());
						
						/*String ss=images.get(i).attr("style");
			        	if(ss!=null && !ss.trim().equals("") && ss.indexOf("https")!=-1) {
			        		ss=ss.substring(ss.indexOf("https"));
			        		ss=ss.substring(0,ss.length()-3);
			        	}
			        	board.setImagesrc(ss);*/
						
						billboards.add(board); // 빌보드 객체를 리스트에 저장
					}
				    
				} catch (IOException e) {
					System.out.println("Billboard Parsing error !!");
				}
		
	}
	
	//----------------------- getBillboardData 메서드 끝
	
	public void printBillboard() {
		for (Billboard ss : billboards) {
			System.out.println(ss);
		}
	}
	public String getTimeDate(String newUrls) {
		HttpGet request = new HttpGet(newUrls); // HttpClient를 이용하여
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		Document doc = null;
		String sdate = "";
		try {
			httpClient = HttpClients.createDefault(); //웹에 연결
			response = httpClient.execute(request); //결과 얻기
			StringBuffer sb = new StringBuffer(); //5000줄 정도 저장
			HttpEntity entity = response.getEntity();
			if(entity != null) {
				String result = EntityUtils.toString(entity);
				sb.append(result);
			}
			doc = Jsoup.parse(sb.toString());
			String id = "charts";
			Element eid = doc.getElementById(id);
			sdate = eid.attr("data-chart-date");
		} catch (IOException e) {
			System.out.println("Billboard Parsing error !!");
		}
		return sdate != null ? RestDay.saturday(sdate) : RestDay.saturday();
	}
	
	//-------------------------
	
	public static void main(String[] args) {
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String newUrls = "https://www.billboard.com/charts/hot-100/";
		String rs = rfw.getTimeDate(newUrls);
		System.out.println("이번 주 : " + rs);
		//rs = RestDay.toWantedDay(rs, 1); 1주 전
		rfw.getBillboardData(newUrls+rs); //리스트에 빌보드 객체들을 저장
		rfw.printBillboard(); //리스트에 저장한 빌보드 객체들 출력
	}

}
