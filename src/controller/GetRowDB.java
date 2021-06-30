/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.LihatBarang;
import java.sql.*;
import java.util.logging.*;

public class GetRowDB {
    public int getRow() {
    ConnectorDB conn = new ConnectorDB();
    PreparedStatement ps;
    ResultSet rs;
    int  n = 0;
    try {
      String query = "Select * from `barang`";
      ps = conn.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      while (rs.next()) {
        n++;
      }
      return n ;

    } catch (SQLException ex) {
      Logger.getLogger(LihatBarang.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -4;
  }
}
