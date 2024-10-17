package csvFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvFileReaderVendorList {

    public static void main(String[] args) throws Exception {
        // Approach1 by using the scanner class

        File file = new File(System.getProperty("user.dir") + "\\Test data\\Vendorlist.csv");
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

