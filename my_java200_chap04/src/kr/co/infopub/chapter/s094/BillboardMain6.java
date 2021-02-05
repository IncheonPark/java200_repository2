package kr.co.infopub.chapter.s094;

import kr.co.infopub.chapter.s093.RequestFromBillboardHot;

public class BillboardMain6 {
	
	public static void main(String[] args) {
		
		RequestFromBillboardHot rfw = new RequestFromBillboardHot();
		String a = "http://www.billboard.com/charts/hot-100/";
		String rs = rfw.getTimeDate(a);
		rfw.getBillboardData(a+rs);
		rfw.printBillboard();
		BillboardPrint.printToCSV(rfw.getBillboards(), "billboard\\"+rs+".csv");
		//BillboardPrint.printToJSON(rfw.getBillboards(), "billboard\\"+rs+".json");
		//BillboardPrint.printToXML(rfw.getBillboards(), "billboard\\"+rs+".xml");
		
	}

}
