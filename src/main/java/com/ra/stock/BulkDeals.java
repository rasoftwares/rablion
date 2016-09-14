package com.ra.stock;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

 /*public class BulkDeals {

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub
  
  String url = "http://www.bseindia.com/markets/downloads/";
  String outputFileLocation ="C:/test";
  //String outputFolder="C:/data";
  BulkDeals e = new BulkDeals();
  String dburl = "jdbc:mysql://localhost:3306/csvdb";

  String Username = "root";
  String Password = "root123";

  String startDate = "01/08/2013";
  String lastDate = "31/08/2013";
  
  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
  Calendar st=Calendar.getInstance();
  Calendar lt=Calendar.getInstance();
  st.setTime(simpleDateFormat.parse(startDate));
  lt.setTime(simpleDateFormat.parse(lastDate));
  @SuppressWarnings("unused")
  List<Date> list=new ArrayList<>();
  
  //SimpleDateFormat outputFormatter;
 // String output;
  String Output;
  @SuppressWarnings("unused")
  int workdays= 0;
  while (lt.after(st)) {
  if (st.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && st.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
    	 Date Out= st.getTime();  
         workdays++;
         SimpleDateFormat outputFormatter = new SimpleDateFormat("ddMMMyyyy");
         Output = outputFormatter.format(Out); 
         //System.out.println(find);
         String date=Output;

         
         
e.functionB(url, outputFileLocation, date); //only download the zip file
e.functionC(date,outputFileLocation,dburl,Username,Password);  //upload into database by row wise
e.functionD(date,dburl,Username,Password); //read from database....
 
 }
  st.add(Calendar.DATE, 1);
 }

 }
 
 

 private static final int BUFFER_SIZE =8192;
 
 public void functionD(String date,String dburl,String Username,String Password) throws Exception {

	 String filepath="D://output"+"//"+ date + ".CSV"; 
	 
	 try {
         Connection conn = DriverManager.getConnection(dburl,Username,Password);

         String sql = "SELECT csvfiles FROM bulkdeals WHERE date=?";
         PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, date);
      
         ResultSet result = statement.executeQuery();
         if (result.next()) {
            Blob blob = result.getBlob("csvfiles");
             InputStream inputStream = blob.getBinaryStream();
             OutputStream outputStream = new FileOutputStream(filepath);

             int bytesRead = -1;
             byte[] buffer = new byte[BUFFER_SIZE];
             while ((bytesRead = inputStream.read(buffer)) != -1) {
                 outputStream.write(buffer, 0, bytesRead);
             }

             inputStream.close();
             outputStream.close();
             System.out.println("File saved to : "+filepath);
         }
         conn.close();
     } catch (SQLException ex) {
         ex.printStackTrace();
     } catch (IOException ex) {
         ex.printStackTrace();
     }
 }
 
 
 public void functionC( String date,String outputFileLocation, String dburl,String Username,String Password)  throws Exception {
	 
	 Connection conn = DriverManager.getConnection(dburl,Username,Password);
	    String INSERT_FILE = "insert into bulkdeals(csvfiles,date) values (?, ?)";

	    FileInputStream fis = null;
	    PreparedStatement ps = null;
	    try {
	      conn.setAutoCommit(false);
	      File file = new File(outputFileLocation +"//"+ date + ".CSV");
	      fis = new FileInputStream(file);
	      ps = conn.prepareStatement(INSERT_FILE);
	      ps.setString(2, date);
	      ps.setBinaryStream(1, fis, (int) file.length());
	      ps.executeUpdate();
	      conn.commit();
	    } finally {
	      ps.close();
	      fis.close();
	    }
	    System.out.println("Inserted into db sucessfuly"+date+".CSV");
	  }
	

	 
	 

	  
 public void functionB(String url, String outputLocation, String date)throws Exception {
        System.out.println("Started Downloading file  for date " + date +
" to output location " + outputLocation);
        File outputFile;
        URL bse;
        BufferedInputStream breader ;
        @SuppressWarnings("unused")
		FileOutputStream fos;
        
        bse = new URL(url + "Bulk_"+ date + ".CSV");
        outputFile = new File(outputLocation + "/" + date + ".CSV");
        
        breader = new BufferedInputStream(bse.openStream());
                   
        
        FileUtils.writeByteArrayToFile(outputFile,IOUtils.toByteArray(breader));
                
        breader.close();
        
        System.out.println("Finished Downloading file  for date " + date +
" to output location " + outputLocation);
               
 }
 
 	}


*/