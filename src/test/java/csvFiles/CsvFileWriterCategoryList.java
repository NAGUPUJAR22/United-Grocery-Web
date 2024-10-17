package csvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterCategoryList {

	public static void main(String[] args) throws Exception 
	{
		String csvFile=System.getProperty("user.dir")+"\\Test data\\CategoryList.csv";
		
		FileWriter writer=new FileWriter(csvFile);
		
		writer.append("SL NO,ParentCode,CategoryName\n");
		writer.append("1,CAT00158,Kids Dress");
		writer.close();
		System.out.println("CSV FILE CREATED AT:-"+csvFile);
				
				

	}

}
