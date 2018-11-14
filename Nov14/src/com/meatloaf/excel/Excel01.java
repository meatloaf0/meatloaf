package com.meatloaf.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel01 {
	public static void main(String[] args) {

		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		Label label = null;
		File file = new File("C:\\temp\\excel02.xls");
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("이름", "홍길동");
		hashMap.put("나이", "30");
		hashMap.put("출생연도", "=YEAR(NOW())-29");
		
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		hashMap2.put("이름", "김길동");
		hashMap2.put("나이", "23");
		hashMap2.put("출생연도", "=YEAR(NOW())-22");
		
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
//		HashMap<Integer, Integer> haha01 = new HashMap<Integer, Integer>();	//타입이 달라서 안돼 ~
//		arrayList.add(haha01);
		
		arrayList.add(hashMap);
		arrayList.add(hashMap2);
		
		try {
			workbook = Workbook.createWorkbook(file);
			workbook.createSheet("명단", 0);	// 1번째 sheet = 0
			sheet = workbook.getSheet(0);
			label = new Label(0,0,"이름");		// (0,0) -> 1,A
			sheet.addCell(label);
			label = new Label(1,0,"나이");		// (1,0) -> 1,B
			sheet.addCell(label);
			label = new Label(2,0,"연도");		// (2,0) -> 1,C
			sheet.addCell(label);
			
			HashMap<String, String> result = new HashMap<String, String>(); 
	
			for (int i = 0; i < 2; i++) {
				result = arrayList.get(i);
				label = new Label(0,i+1,result.get("이름"));
				sheet.addCell(label);
				label = new Label(1,i+1,result.get("나이"));
				sheet.addCell(label);
				label = new Label(2,i+1,result.get("출생연도"));
				sheet.addCell(label);
			}
			
			workbook.write();
			workbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
