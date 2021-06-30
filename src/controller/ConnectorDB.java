/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;

public class ConnectorDB {
    String DBurl = "jdbc:mysql://localhost/barang";
    String DBusername = "root";
    String DBpassword = "";
    Connection conn;
    Statement stat;
    
    public ConnectorDB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi Gagal\n");
            System.out.println(ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
}
