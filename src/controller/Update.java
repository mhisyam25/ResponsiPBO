/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Integer.parseInt;
import model.Barang;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author ASUS
 */
public class Update {
    public boolean edit(Barang b){
    String query = "UPDATE `barang` SET `nama`=?,`massa`=?,`harga`=? WHERE `id`=?";
    PreparedStatement ps;
    System.out.println("idEdit " + b.getId());
    
    try {
      ConnectorDB conn = new ConnectorDB();
      ps = conn.getConnection().prepareStatement(query);
      ps.setString(1, b.getNama());
      ps.setDouble(2, b.getMassa());
      ps.setDouble(3, b.getHarga());
      
      int id = parseInt(b.getId());
      
      ps.setInt(4, id);
      
      int i = ps.executeUpdate();

      return i == 1; // jika change pin success
      
    } catch (SQLException ex) {
      Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
