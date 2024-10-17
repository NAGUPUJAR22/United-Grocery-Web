package CsvFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class csvFileReader {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file=new File(System.getProperty("user.dir")+"\\Test data\\Inventory_template (8).csv");
		Scanner sc=new Scanner(file);
		sc.useDelimiter(",");
		while(sc.hasNext())
		{
			System.out.print(sc.next()+"\t");
		}
		sc.close();

	}

}
