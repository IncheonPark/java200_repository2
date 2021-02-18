//xml저장

package kr.co.infopub.chapter.s096;

import kr.co.infopub.chapter.s093.RequestFromBillboardHot;
import kr.co.infopub.chapter.s094.BillboardPrint;

public class BillboardMain6 {
	
	public static void main(String[] args) {
		
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String a = "https://www.billboard.com/charts/hot-100/";
		String rs = rfw.getTimeDate(a);
		rfw.getBillboardData(a+rs);
		rfw.printBillboard();
		
		BillboardPrint.printToXML(rfw.getBillboards(), "billboard\\"+rs+".xml");
		
	}

}
