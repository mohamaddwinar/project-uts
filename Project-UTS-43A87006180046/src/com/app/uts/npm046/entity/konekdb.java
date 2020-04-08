/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm046.entity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Mohamad Ridwan
 */
public class konekdb {
  barangDatasource datasource = new barangDatasource();
    public static void main(String[] args){
        new konekdb().update();
        new konekdb().koneksi();
        new konekdb().select();
        new konekdb().insert();
        new konekdb().delete();
    }
    
    public void update(){
        entityBarang brg = datasource.getByID("001");
        brg.setNamaBarang("Buku");
        brg.setJenisBarang("Kertas");
        brg.setHarga("10000");
        brg.setJumlah("10");
        boolean sukses = datasource.update(brg);
        if(sukses){
            System.out.println("Update Sukses!");
        }
        else{
            System.out.println("Update Gagal!");
        }
    }
    
    public void koneksi(){
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("Inventory");
        ds.setPort(3306);
        ds.setUser("root");
        ds.setPassword("");
        try {
            Connection connection = ds.getConnection();
            System.out.println("Koneksi Database Sukses!");
        } 
        catch (SQLException ex) {
            System.out.println("Koneksi Database Gagal!");
            System.out.println("Error "+ex.getMessage());
        }
    }
    
    public void select(){
        entityBarang brg = datasource.getByID("001");
        if(brg != null){
            System.out.println("IdBarang: "+brg.getIdBarang()+" NamaBarang: "+brg.getNamaBarang());
        }
    }
    
    public void insert(){
        entityBarang brg  = new entityBarang();
        brg.setIdBarang("001");
        brg.setNamaBarang("Buku");
        brg.setJenisBarang("Kertas");
        brg.setHarga("10000");
        brg.setJumlah("10");
        boolean sukses = datasource.update(brg);
        if(sukses){
            System.out.println("Penambahan Sukses!");
        }
        else{
            System.out.println("Penambahan Gagal!");
        }
    }
    
    public void delete(){
        entityBarang brg = datasource.getByID("001");
        boolean sukses = datasource.delete(brg);
        if(sukses){
            System.out.println("Penghapusan Sukses!");
        }
        else{
            System.out.println("Penghapusan Gagal!");
        }
    }   
}
