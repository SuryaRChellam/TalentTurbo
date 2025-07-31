package testBase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingxlsx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream testfile = new FileInputStream("C:\\Users\\hp\\Documents\\Login User Credential.xlsx");
		
		XSSFWorkbook testbook = new XSSFWorkbook(testfile);
		
		XSSFSheet sheet = testbook.getSheet("Sheet2");
		
		int totalRows = sheet.getLastRowNum();
		int totalCells1 = sheet.getRow(1).getLastCellNum();
		
		System.out.println("no of rows :" + totalRows);
		System.out.println("no of cells :" + totalCells1);
		
		for (int r=0;r<=totalRows;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0;c<totalCells1;c++) {
				XSSFCell currentCell = currentRow.getCell(c);
				
				System.out.print(currentCell.toString()+"\t");
				
				
			}
			System.out.println();
			
			
		} 
		
		testbook.close();
		testfile.close();
		

	}

}
