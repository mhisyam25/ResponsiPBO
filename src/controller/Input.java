/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Barang;
import java.sql.*;
import java.util.logging.*;

public class Input {
    public boolean input(Barang barang){
    
    ConnectorDB myConnection = new ConnectorDB();
    PreparedStatement ps;    
    
    String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES (?,?,?)";
    
    try {
      ps = myConnection.getConnection().prepareStatement(query);
      ps.setString(1, barang.getNama());
      ps.setDouble(2, barang.getMassa());
      ps.setDouble(3, barang.getHarga());

      // jika berhasil
      if (ps.executeUpdate() > 0) {        
        System.out.println("Input berhasil");
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}
