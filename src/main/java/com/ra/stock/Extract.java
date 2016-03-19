package com.ra.stock;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Extract {

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub
  
  String url = "http://www.bseindia.com/download/BhavCopy/Equity/";
  String outputFileLocation ="C:/test";
  String outputFolder="C:/data";
  Extract e = new Extract();
  String dburl = "jdbc:mysql://localhost:3306/rabliondb";
  String Username = "root";
  String Password = "root123";

  String startDate = "01/01/2008";
  String lastDate = "31/12/2015";
  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
  Calendar st=Calendar.getInstance();
  Calendar lt=Calendar.getInstance();
  st.setTime(simpleDateFormat.parse(startDate));
  lt.setTime(simpleDateFormat.parse(lastDate));
  @SuppressWarnings("unused")
  List<Date> list=new ArrayList<>();
  
  DateFormat outputFormatter;
  String output;
  for (Date print = st.getTime(); !st.after(lt); st.add(Calendar.DAY_OF_YEAR, 1), 
                                                         print = st.getTime())
  {
	  
    outputFormatter = new SimpleDateFormat("ddMMyy");
    output = outputFormatter.format(print); 
   
    String date =output;
 
 
  e.functionB(url, outputFileLocation, date); //only download the zip file
  e.functionC(outputFileLocation, date,outputFolder); // extract the zip file
  e.functionD(date,outputFolder,dburl,Username,Password);  //upload into database by row wise
  //e.functionE(outputFileLocation, date); perform some operation....
  
}
 
}


 public void functionD( String date,String outputFolder, String dburl,String Username,String Password) throws Exception {
 
	   try {
         Connection conn = DriverManager.getConnection(dburl,Username,Password);

         String sql = "INSERT INTO csvlist (csvfiles) values (LOAD_FILE(?))";
         PreparedStatement statement = conn.prepareStatement(sql);

         statement.setString(1, outputFolder +"//"+ "EQ" + date + ".CSV");
         int row = statement.executeUpdate();
         if (row > 0) {
             System.out.println("File was inserted into db");
         }
         conn.close();
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
 }
 
public void functionC(String outputFileLocation, String date,String outputFolder) throws Exception 
            {
	 
	        File dir = new File(outputFolder);
	        if(!dir.exists()) dir.mkdirs();
	        FileInputStream fis;
	        byte[] buffer = new byte[1024];
	        try {
	            fis = new FileInputStream(outputFileLocation + "\\" +date +".ZIP");
	            ZipInputStream zis = new ZipInputStream(fis);
	            ZipEntry ze = zis.getNextEntry();
	            while(ze != null){
	                String fileName = ze.getName();
	                File newFile = new File(outputFolder+ File.separator + fileName);
	                System.out.println("Unzipping to "+newFile.getAbsolutePath());
	                new File(newFile.getParent()).mkdirs();
	                FileOutputStream fos = new FileOutputStream(newFile);
	                int len;
	                while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	                }
	                fos.close();
	                
	                zis.closeEntry();
	                ze = zis.getNextEntry();
	            }
	           
	            zis.closeEntry();
	            zis.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	         
	     
 }
	 
	
	  
 public void functionB(String url, String outputLocation, String date)throws Exception {
        System.out.println("Started Downloading file  for date " + date +
" to output location " + outputLocation);
        File outputFile;
        URL bse;
        BufferedInputStream breader ;
        @SuppressWarnings("unused")
		FileOutputStream fos;
        
        bse = new URL(url + "EQ"+ date + "_CSV.ZIP");
        outputFile = new File(outputLocation + "/" + date + ".zip");
        
        breader = new BufferedInputStream(bse.openStream());
                   
        
        FileUtils.writeByteArrayToFile(outputFile,IOUtils.toByteArray(breader));
                
        breader.close();
        
        System.out.println("Finished Downloading file  for date " + date +
" to output location " + outputLocation);
               
 }
 
 public void functionA() throws Exception {
  URL bse = new URL("http://www.bseindia.com/stock-share-price/SiteCache/IrBackupStockReach.aspx?scripcode=500470");
        BufferedReader in = new BufferedReader(new
InputStreamReader(bse.openStream()));

        String inputLine;
        
        inputLine = new String(IOUtils.toByteArray(in));
        
        System.out.println(inputLine);
  in.close();
 }
}




