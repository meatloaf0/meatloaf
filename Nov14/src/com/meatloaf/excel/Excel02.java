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
		
		Sheet sheet1 = workbook.createSheet("��Ʈ����");
		
		Row row = null;
		Cell cell = null;
		
		row = sheet1.createRow(0);
	
		cell = row.createCell(0);
		cell.setCellValue("�̸�");
		
		cell = row.createCell(1);
		cell.setCellValue("����");
		
		cell = row.createCell(2);
		cell.setCellValue("����");
		
		Row row2 = sheet1.createRow(1);
		
		cell = row2.createCell(0);
		cell.setCellValue("�ƾƾ�");
		
		cell = row2.createCell(1);
		cell.setCellValue(22);		// ���ڷ� �Էµ�
		
		cell = row2.createCell(2);
		cell.setCellValue("1999");	// �ؽ�Ʈ�� �Էµ�
		
		File file = new File("C:\\Temp\\poiExcel.xls");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
