/*package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	
	@DataProvider(name="DataDriven")
	public String [][] getData() throws IOException{
		
		String xlfile=".\\testdata\\LD.xlsx";
		
		utility01 xlutil=new utility01(xlfile);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]= new String[totalrows][totalcols];
		
		for(int i=0;i<=totalrows;i++)
		{
			for(int j=0;j<=totalcols;j++) 
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
			}
			
		}
		
		return logindata;
	}

}*/
