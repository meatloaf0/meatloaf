package com.meatloaf.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class mainn {

	public static void main(String[] args) {
		//데이터베이스 접속
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT * FROM userinfo";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			
			Row row = null;
			Cell cell = null;
			
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue("번호");
			cell = row.createCell(1);
			cell.setCellValue("아이디");
			cell = row.createCell(2);
			cell.setCellValue("비밀번호");
			cell = row.createCell(3);
			cell.setCellValue("이름");
			cell = row.createCell(4);
			cell.setCellValue("등급");
			cell = row.createCell(5);
			cell.setCellValue("전화번호");
			
			int count = 1;
			while (rs.next()) {
				UserData ud = new UserData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
				Row row2 = sheet.createRow(count++);
				cell = row2.createCell(0);
				cell.setCellValue(rs.getInt(1));
				cell = row2.createCell(1);
				cell.setCellValue(rs.getString(2));//?
				cell = row2.createCell(2);
				cell.setCellValue(rs.getString(3));
				cell = row2.createCell(3);
				cell.setCellValue(rs.getString(4));
				cell = row2.createCell(4);
				cell.setCellValue(rs.getInt(5));
				cell = row2.createCell(5);
				cell.setCellValue(rs.getString(6));
			}
			
			File file = new File("c:\\temp\\user2Excel.xls");
			FileOutputStream fileOut = new FileOutputStream(file);
			workbook.write(fileOut);
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}