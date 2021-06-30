/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.LihatBarang;
import java.sql.*;
import java.util.logging.*;

public class Read {
    public String[][] readAllData() {
    // untuk menghitung jumlah baris
    GetRowDB getRow = new GetRowDB();

    // untuk menyimpan data
    String data[][] = new String[getRow.getRow()][4];

    try {
      ConnectorDB conn = new ConnectorDB();
      PreparedStatement ps;
      ResultSet rs;

      String query = "Select * from `barang`";
      ps = conn.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0;
      while (rs.next()) { //konversi tabel ke string
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        n++;
      }
      return data;
    } catch (SQLException ex) {
      System.out.println("Read Data Gagal");
      Logger.getLogger(LihatBarang.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
}
