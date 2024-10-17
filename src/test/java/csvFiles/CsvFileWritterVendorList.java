package csvFiles;

import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWritterVendorList 
{
     public static void main(String[] args) throws Exception
     {
		String csvFile=System.getProperty("user.dir")+"\\Test data\\Vendorlist.csv";
		
		FileWriter writer=new FileWriter(csvFile);
		 writer.append("SL NO,Vendor Name,Email,Phone,PaymentTermsCode,MerchandiseTypeCode,GovtIdCode,IdentityNumber,AddressLine1,AddressLine2,City,State,ZipCode,CountryCode,ManFEIN,TaxPaidFlag(true/false) \n");
		 writer.append("1,Nagaraj,raju@g.com,1234567890,PTCO,MTTR,GIPIN,123456,#123,City of okalama,Oklakhama,Alabama,45879,USA,8547226,true \n");
		 writer.append("2,Yashu,yashu@g.com,1234567891,PTCO,MTTR,GIPIN,123456,#123,City of okalama,Oklakhama,Alabama,45879,USA,8547226,true \n");
		 writer.append("3,Raghu,raghu@g.com,1234567892,PTCO,MTTR,GIPIN,123456,#123,City of okalama,Oklakhama,Alabama,45879,USA,8547226,true \n");
		 writer.append("4,Renuka,renuka@g.com,1234567893,PTCO,MTTR,GIPIN,123456,#123,City of okalama,Oklakhama,Alabama,45879,USA,8547226,true \n");
		 writer.append("5,Bheema,bheema@g.com,1234567894,PTCO,MTTR,GIPIN,123456,#123,City of okalama,Oklakhama,Alabama,45879,USA,8547226,true \n");
		 
		 writer.flush();
		 writer.close();
		 System.out.println("CSV FILE CREATED AT:"+csvFile);
	}
}
