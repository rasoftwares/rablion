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

public class ExtractAndRetrive {

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub
  
  String url = "http://www.bseindia.com/download/BhavCopy/Equity/";
  String outputFileLocation ="C:/test";
  String outputFolder="C:/data";
  String retriveFileFolder="D://output";
  String Query="SELECT csvfiles FROM csvlist WHERE date=?";
  String fieldName="csvfiles";
  String insertquery= "insert into csvlist(csvfiles,date) values (?, ?)";
  ExtractAndRetrive e = new ExtractAndRetrive();
  String dburl = "jdbc:mysql://localhost:3306/csvdb";
  String Username = "root";
  String Password = "root123";

  String startDate = "01/01/2014";
  String lastDate = "16/02/2014";
  
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
         SimpleDateFormat outputFormatter = new SimpleDateFormat("ddMMyy");
         Output = outputFormatter.format(Out); 
         //System.out.println(find);
         String date=Output;

         
         
e.functionB(url, outputFileLocation, date); //only download the zip file
e.functionC(outputFileLocation, date,outputFolder); // extract the zip file
e.functionD(date,outputFolder,insertquery,dburl,Username,Password);  //upload into database by row wise
e.functionE(date,Query,retriveFileFolder,fieldName,dburl,Username,Password); //read from database....
 
 }
  st.add(Calendar.DATE, 1);
 }

 }
 
 // Function E :Retrive file from database....
 
 private static final int BUFFER_SIZE = 4096;
 
 public void functionE(String date,String Query,String retriveFileFolder,String fieldName,String dburl,String Username,String Password) throws Exception {

	    String filepath=retriveFileFolder +"//"+ date + ".CSV"; 
	 
	 	 try {
         Connection conn = DriverManager.getConnection(dburl,Username,Password);

         String sql = Query;
         PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, date);
      
         ResultSet result = statement.executeQuery();
         if (result.next()) {
            Blob blob = result.getBlob(fieldName);
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
 
 //Function D:Insert file into databse.....
 public void functionD( String date,String outputFolder,String insertquery, String dburl,String Username,String Password)  throws Exception {
	 
	 Connection conn = DriverManager.getConnection(dburl,Username,Password);
	    String INSERT_FILE =insertquery;
	    FileInputStream fis = null;
	    PreparedStatement ps = null;
	    try {
	      conn.setAutoCommit(false);
	      File file = new File(outputFolder +"//"+ "EQ" + date + ".CSV");
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
	

	 
//Function C: Unzip file....	 
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
	 
	
	// Function B :Download bhavcopy file from bse site...  
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
 
 //Function A: link
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




