// 찾으려는 날짜의 빌보드 차트를 문자열에 저장하기

package kr.co.infopub.chapter.s092;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RequestFromBillboardHot {
	
	String result;
	
	public void getAllHtml(String newUrls) {
		HttpGet request = new HttpGet(newUrls); //HttpGet 생성
		// finally 처리용
		try (CloseableHttpClient httpClient = HttpClients.createDefault(); 
				CloseableHttpResponse response = httpClient.execute(request)) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
		} catch (IOException e) {
			System.out.println("Billboard Parsing error !!");
		}
	}
	
	public void printHtml() {
		System.out.println(result);
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
			if (entity != null) { // 결과가 있다면 결과에서 한줄씩 저장
				String result = EntityUtils.toString(entity);
				sb.append(result); //버퍼에 스트링 저장
			}
			doc = Jsoup.parse(sb.toString()); // 전체 내용을 HTML 파싱
			String id = "charts";
			// <div id="charts" data-chart-date="yyyy-MM-dd" >인 요소
			Element eid = doc.getElementById(id);
			sdate = eid.attr("data-chart-date");
			
		} catch (IOException e) {
			System.out.println("Billboard Parsing error !!");
		}
		return sdate != null ? RestDay.saturday(sdate) : RestDay.saturday();
	}
	
	public static void main(String[] args) {
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String newUrls = "https://www.billboard.com/charts/hot-100/";
		String rs = rfw.getTimeDate(newUrls);
		System.out.println("이번 주 : "+rs);
		// rs = RestDay.toWantedDay(rs, 1); //1주전
		//System.out.println("일주일 전 " +rs);
		rfw.getAllHtml(newUrls+rs); // hot-100 html을 읽어 문자열로 저장
		rfw.printHtml(); // 저장한 내용 출력
	}

	
}
