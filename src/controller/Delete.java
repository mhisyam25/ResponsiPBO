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

public class Delete {
    public boolean delete(Barang barang){
    
        String query = "DELETE FROM `barang` WHERE `id`=?";
        PreparedStatement ps;

        try {
            ConnectorDB conn = new ConnectorDB();
            ps = conn.getConnection().prepareStatement(query);
            
            ps.setInt(1, parseInt(barang.getId()));

            int i = ps.executeUpdate();

            return i == 1; // jika change pin success

       } catch (SQLException ex) {
            Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            return false;
       }
    }
}
