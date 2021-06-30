/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ASUS
 */
public class Total {
    public String Potongan(double banyak,double harga){
        if(banyak < 12){
            harga = harga * banyak;
        } else if (banyak < 20) {
            harga = banyak * harga - (banyak * harga * 5 / 100);
        } else if (banyak < 144) {
            harga = banyak * harga - (banyak * harga * 10 / 100);
        } else {
            harga = banyak * harga - (banyak * harga * 25 / 100);
        }
        return Double.toString(harga);
    }
}
