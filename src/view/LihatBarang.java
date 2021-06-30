/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Barang;
import controller.Read;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LihatBarang {
    Barang barang = new Barang();
    Read read = new Read();
    
    JFrame window = new JFrame("Lihat Data");
    
    JTable tabel;
    DefaultTableModel tableModel;
    Object namaKolom[] = {"ID", "Nama", "Massa (gr)", "Harga Satuan"};
    
    JScrollPane scrollPane;
    
    JButton btnKembali = new JButton("Kembali");
    
    public LihatBarang(){
        window.setLayout(null);
        window.setSize(850, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
       
        window.add(btnKembali);

        if(read.readAllData() == null){
            JOptionPane.showMessageDialog(null, "Tidak Ada Data");
            tabel = new JTable(null, namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }else{
            tabel = new JTable(read.readAllData(), namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }
        
        // SET BOUNDS (m,n,o,p) -> (sumbu-x,sumbu-y,panjang,tinggi)
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);

        scrollPane.setBounds(10, 5, 815, 500);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        btnKembali.setBounds(10, 520, 810, 30);
        
        tabel.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String id = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
                barang.getData(id);
                window.dispose();
                new InfoBarang(barang);
            }
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MainMenu();
        });
    }
}
