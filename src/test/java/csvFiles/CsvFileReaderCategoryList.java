package csvFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvFileReaderCategoryList {

	public static void main(String[] args) throws FileNotFoundException 
	{
		 File file = new File(System.getProperty("user.dir") + "\\Test data\\CategoryList.csv");
	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            String[] columns = line.split(",");
	            
	            
	            for (String column : columns)
	            {
	                System.out.printf("%-20s", column);
	            }
	            System.out.println();
	        }
	        sc.close();

	}

}
