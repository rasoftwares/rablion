package com.ra.stock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

/*public class readfromdb {
    private static final int BUFFER_SIZE = 4096;
 
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rabliondb";
        String user = "root";
        String password = "root";
 
        String filePath = "D:/test.csv";
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "SELECT csvfiles FROM csvlist WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
             statement.setString(1, "2923");
         
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("csvfiles");
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);
 
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
 */