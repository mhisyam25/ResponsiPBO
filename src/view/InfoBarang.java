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

public class InfoBarang extends JFrame{
    ConnectorDB conn = new ConnectorDB();
    Barang barang = new Barang();
    Total tot = new Total();
    Delete del = new Delete();
    
    JFrame window = new JFrame("Info Barang");

    JLabel lnama = new JLabel("Nama                              :");
    JLabel lmassa = new JLabel("Massa (gr)                     :");
    JLabel lharga = new JLabel("Harga Satuan                :");
    JLabel lbanyak = new JLabel("Banyak                           :");
    JLabel ltotal = new JLabel("Total                               :");
    JLabel linfonama = new JLabel(" ");
    JLabel linfomassa = new JLabel(" ");
    JLabel linfoharga = new JLabel(" ");
    JLabel linfobanyak = new JLabel(" ");
    
    public JTextField tfbanyak = new JTextField();
    
    JButton btnTotal = new JButton("Total Harga");
    JButton btnEdit = new JButton("Edit");
    JButton btnHapus = new JButton("Hapus");
    JButton btnKembali = new JButton("Kembali");
    
    public InfoBarang(Barang barang){
        window.setLayout(null);
        window.setSize(500, 280);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan

        window.add(lnama);
        window.add(lmassa);
        window.add(lharga);
        window.add(lbanyak);
        window.add(ltotal);
        window.add(linfonama);
        window.add(linfomassa);
        window.add(linfoharga);
        window.add(linfobanyak);
        window.add(tfbanyak);
        window.add(btnTotal);
        window.add(btnEdit);
        window.add(btnHapus);
        window.add(btnKembali);

        // SET BOUNDS (m,n,o,p) -> (sumbu-x,sumbu-y,panjang,tinggi)
        lnama.setBounds(20, 5, 200, 30);
        lmassa.setBounds(20, 35, 200, 30);
        lharga.setBounds(20, 65, 200, 30);
        lbanyak.setBounds(20, 95, 200, 30);
        ltotal.setBounds(20, 140, 200, 30);
        
        linfonama.setBounds(180, 5, 200, 30);
        linfomassa.setBounds(180, 35, 200, 30);
        linfoharga.setBounds(180, 65, 200, 30);
        linfobanyak.setBounds(180, 140, 200, 30);
        
        tfbanyak.setBounds(180, 95, 270, 30);
        
        btnKembali.setBounds(20, 200, 100, 25);
        btnEdit.setBounds(135, 200, 100, 25);
        btnHapus.setBounds(250, 200, 100, 25);
        btnTotal.setBounds(370, 200, 100, 25);
        
        double m = barang.getMassa();
        String massa = Double.toString(m);
        double h = barang.getHarga();
        String harga = Double.toString(h);
        
        linfonama.setText(barang.getNama()); 
        linfomassa.setText(massa);
        linfoharga.setText(harga);
        
        btnTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double banyak = Double.parseDouble(tfbanyak.getText());

                    if(banyak < 0){
                        throw new ArithmeticException("Bilangan Harus Positif");      
                    }
                    
                    linfobanyak.setText(tot.Potongan(banyak, barang.getHarga()));

                }catch(Exception ex){
                    System.out.print(ex.getMessage());
                    if (tfbanyak.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Harus diisi");
                    }else if ("Bilangan Harus Positif".equals(ex.getMessage())) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()); 
                    }else{
                        JOptionPane.showMessageDialog(null,"Banyak Barang Harus diisi");
                    }
                    tfbanyak.setText("");
                }
            }
        });
        
        btnEdit.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new EditBarang(barang);
        });
        
        btnHapus.addActionListener((ActionEvent arg0) -> {
            if(del.delete(barang)){
                JOptionPane.showMessageDialog(null, "Hapus Data Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE);
            }else{
                 JOptionPane.showMessageDialog(null, "Hapus Data Gagal","Pesan",JOptionPane.INFORMATION_MESSAGE);
            }
            window.dispose();
            new LihatBarang();
        });
        
        btnKembali.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new MainMenu();
        });
    }    
}
