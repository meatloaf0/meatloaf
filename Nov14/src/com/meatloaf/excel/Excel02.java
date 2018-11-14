package com.meatloaf.excel;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Excel02 {
	public void excel() {
		Workbook workbook = new HSSFWorkbook();		// ~ 2003	.xls
//		Workbook workbook2 = new XSSFWorkbook();	// 2003 ~	.xlsx
		
		Sheet sheet1 = workbook.createSheet("시트만듦");
		
		Row row = null;
		Cell cell = null;
		
		row = sheet1.createRow(0);
	
		cell = row.createCell(0);
		cell.setCellValue("이름");
		
		cell = row.createCell(1);
		cell.setCellValue("나이");
		
		cell = row.createCell(2);
		cell.setCellValue("연도");
		
		Row row2 = sheet1.createRow(1);
		
		cell = row2.createCell(0);
		cell.setCellValue("아아아");
		
		cell = row2.createCell(1);
		cell.setCellValue(22);		// 숫자로 입력됨
		
		cell = row2.createCell(2);
		cell.setCellValue("1999");	// 텍스트로 입력됨
		
		File file = new File("C:\\Temp\\poiExcel.xls");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
