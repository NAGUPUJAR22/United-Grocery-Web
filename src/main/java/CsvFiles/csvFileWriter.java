package CsvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class csvFileWriter {

	public static void main(String[] args) throws IOException 
	{
		String csvFile = System.getProperty("user.dir")+"\\Test data\\example1.csv";
		
		FileWriter writer=new FileWriter(csvFile);
		
		writer.append("Name,Age,Email\n");
		writer.append("Nagu,25,naghu@gmail.com\n");
		writer.append("Yashu,24,yashu@gmail.com\n");
		writer.append("Renuka,42,john@gmail.com\n");
		writer.append("Raghu,22,raghu@gmail.com\n");
		writer.close();
		
		System.out.println("The csv file created"+csvFile);
	}

}
