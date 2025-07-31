package testBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writingxlsx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\newfile00 .xlsx");
		
		XSSFWorkbook workbookWr = new XSSFWorkbook();
		
		XSSFSheet sheetWr = workbookWr.createSheet("Sample");
		
		/*XSSFRow row1 = sheetWr.createRow(0);
			row1.createCell(0).setCellValue("suryachellam97@gmail.com");
			row1.createCell(1).setCellValue("Surya@1997");
			row1.createCell(2).setCellValue("Candidate");
			
		XSSFRow row2 = sheetWr.createRow(1);
			row2.createCell(0).setCellValue("john.doe123@gmail.com");
			row2.createCell(1).setCellValue("John@1234");
			row2.createCell(2).setCellValue("Admin");

		XSSFRow row3 = sheetWr.createRow(2);
			row3.createCell(0).setCellValue("jane.smith2024@gmail.com");
			row3.createCell(1).setCellValue("Jane@5678");
			row3.createCell(2).setCellValue("HR");
			
		workbookWr.write(file);
		workbookWr.close();
		file.close();
		
		System.out.println("File Created");*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of rows :");
		int rowsNo = sc.nextInt();
		
		System.out.println("enter no of cells :");
		int cellsNo = sc.nextInt();
		
		for(int r=0;r<=rowsNo;r++) {
			XSSFRow currentRow = sheetWr.createRow(r);
			
			for (int c=0;c<cellsNo;c++) {
				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next()); 
			}
			
		}
		
		workbookWr.write(file);
		workbookWr.close();
		file.close();

		System.out.println("File Created");
	}

}
