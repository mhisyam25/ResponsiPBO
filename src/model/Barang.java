/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConnectorDB;
import java.sql.*;
import java.util.logging.*;

public class Barang {
    private String nama, id;
    private double massa, harga;

    public void setBarang(String nama, double massa, double harga) {
        this.nama = nama;
        this.massa = massa;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getMassa() {
        return massa;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public String getId() {
        return id;
    }
    
    public void getData(String id) {
        ConnectorDB conn = new ConnectorDB();
        PreparedStatement ps;
        ResultSet rs;

        String query = "Select * from `barang` WHERE id=?";

        try {
            ps = conn.getConnection().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.id = id;
                this.nama = rs.getString(2);
                this.massa = rs.getDouble(3);
                this.harga = rs.getDouble(4);

                System.out.println(nama);
                System.out.println(massa);
                System.out.println(harga);
            }

        } catch (SQLException ex) {
            System.out.println("Data tidak ditemukan");
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
