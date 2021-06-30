/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.*;
import model.Barang;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EditBarang extends JFrame{
    ConnectorDB conn = new ConnectorDB();
    Barang barang = new Barang();
    Update edit = new Update();
    
    // DEKLARASI KOMPONEN
    JFrame window = new JFrame("Input Barang");

    JLabel ljudul = new JLabel("Input Barang");
    JLabel lnama = new JLabel("Nama");
    JLabel lmassa = new JLabel("Massa (gr)");
    JLabel lharga = new JLabel("Harga Satuan");
    
    JTextField tfnama = new JTextField();
    JTextField tfmassa = new JTextField();
    JTextField tfharga = new JTextField();
    
    JButton btnSubmit = new JButton("Submit");
    JButton btnReset = new JButton("Reset");
    JButton btnKembali = new JButton("Kembali");
    
    public EditBarang(Barang barang){
        System.out.println(barang.getId());
        System.out.println(barang.getNama());
        System.out.println(barang.getMassa());
        System.out.println(barang.getHarga());
        window.setLayout(null);
        window.setSize(500, 280);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan

        window.add(ljudul);
        window.add(lnama);
        window.add(tfnama);
        window.add(lmassa);
        window.add(tfmassa);
        window.add(lharga);
        window.add(tfharga);
        window.add(btnSubmit);
        window.add(btnReset);
        window.add(btnKembali);

        // SET BOUNDS (m,n,o,p) -> (sumbu-x,sumbu-y,panjang,tinggi)
        ljudul.setBounds(20, 5, 200, 30);
        lnama.setBounds(20, 35, 200, 30);
        lmassa.setBounds(20, 65, 200, 30);
        lharga.setBounds(20, 95, 200, 30);
        
        tfnama.setBounds(180, 35, 270, 30);
        tfmassa.setBounds(180, 65, 270, 30);
        tfharga.setBounds(180, 95, 270, 30);
        
        btnSubmit.setBounds(180, 140, 130, 25);
        btnReset.setBounds(320, 140, 130, 25);
        btnKembali.setBounds(10, 200, 460, 30);
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nama = tfnama.getText();
                    double massa = Double.parseDouble(tfmassa.getText());
                    double harga = Double.parseDouble(tfharga.getText());

                    if(massa < 0 || harga < 0){
                        throw new ArithmeticException("Bilangan Harus Positif");      
                    }
                    
                    barang.setBarang(nama, massa, harga);
                    
                    if(edit.edit(barang)){
                        window.dispose();
                        new MainMenu();
                        
                        JOptionPane.showMessageDialog(null, "Update Berhasil");
                    }else{
                        JOptionPane.showMessageDialog(null, "Update Gagal");
                    }

                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfnama.getText().equals("")||tfmassa.getText().equals("")||tfharga.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Massa dan Harga Harus Bilangan");
                    }
                    tfnama.setText("");
                    tfmassa.setText("");
                    tfharga.setText("");
                }
            }
        });
        
        btnReset.addActionListener((ActionEvent arg0) -> {
            tfnama.setText("");
            tfmassa.setText("");
            tfharga.setText("");
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MainMenu();
        });
    }
}
