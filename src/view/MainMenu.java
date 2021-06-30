/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainMenu extends JFrame{
    // DEKLARASI KOMPONEN
    JFrame window = new JFrame("Main Menu");

    JLabel ljudul = new JLabel("Main Menu");
    
    JButton btnTambah = new JButton("Tambah Barang");
    JButton btnLihat = new JButton("Lihat Barang");
  
    public MainMenu(){
        window.setLayout(null);
        window.setSize(380, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan

        window.add(ljudul);
        window.add(btnTambah);
        window.add(btnLihat);

        // SET BOUNDS (m,n,o,p) -> (sumbu-x,sumbu-y,panjang,tinggi)
        ljudul.setBounds(150, 10, 200, 30);

        btnTambah.setBounds(110, 50, 150, 30);
        btnLihat.setBounds(110, 90, 150, 30);
        
        btnTambah.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new InputBarang();
        });
        
        btnLihat.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new LihatBarang();
        });
    }
}
