/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm046.entity;

/**
 *
 * @author Mohamad Ridwan
 */
public class entityBarang {
   private String IdBarang;
    private String NamaBarang;
    private String JenisBarang;
    private String Harga;
    private String Jumlah;
    
    public entityBarang(){
        
    }

    public entityBarang(String IdBarang, String NamaBarang, String JenisBarang, String Harga, String Jumlah) {
        this.IdBarang = IdBarang;
        this.NamaBarang = NamaBarang;
        this.JenisBarang = JenisBarang;
        this.Harga = Harga;
        this.Jumlah = Jumlah;
    }

    public String getIdBarang() {
        return IdBarang;
    }

    public void setIdBarang(String IdBarang) {
        this.IdBarang = IdBarang;
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String NamaBarang) {
        this.NamaBarang = NamaBarang;
    }

    public String getJenisBarang() {
        return JenisBarang;
    }

    public void setJenisBarang(String JenisBarang) {
        this.JenisBarang = JenisBarang;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setJumlah(String Jumlah) {
        this.Jumlah = Jumlah;
    }


    public Object getValue(int index) {
        switch (index) {
            case 0:
                return IdBarang;
            case 1:
                return NamaBarang;
            case 2:
                return JenisBarang;
            case 3:
                return Harga;
            case 4:
                return Jumlah;

            default:
                return null; 
        }
    }  
}
