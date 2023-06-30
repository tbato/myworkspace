/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ConnectDataBase {
    private Connection connect;
    private String url = "jdbc:mysql://localhost:3306/demo";
    private String username = "root";
    private String password = "";
   
    
    public ConnectDataBase(){        
    }
    public Connection getConnect(){
        try{
        connect = DriverManager.getConnection(url, username, password);
         }catch(SQLException e){
        e.printStackTrace();
    }
        return connect;
   }
    // Lấy dữ dòng dữ liệu từ database với id cho trước
    public boolean checkId(String id){ 
        boolean checkId = false;
        try {
            connect = getConnect();
            String query = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id.trim()));
            ResultSet rsm = statement.executeQuery();
            if(rsm.next()){
                checkId = true;
            }
            rsm.close();
            statement.close();
            connect.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return checkId;
    }
    
    public static void main(String[] args){
        ConnectDataBase connectDb = new ConnectDataBase();
        boolean checkId = connectDb.checkId("1");
        if(checkId == true){
            System.out.println("Đã tìm thấy khách hàng có mã số" + 1);
        }else{
            System.out.println("Không tìm thấy khách hàng nào có mã số trên");
        }
    }
    
}
