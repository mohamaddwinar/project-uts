/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm046.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohamad Ridwan
 */
public class barangDatasource {
   private Connection connection;
    public barangDatasource(){
        connection = ConnectionUtil.getConnection();
    }

    public List(entityBarang) getAll(){
        List<entityBarang> list = new ArrayList<>();
        String sql = "select * from Barang;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            entityBarang brg;
            while(rs.next()){
                brg = new entityBarang();
                brg.setIdBarang(rs.getString("IdBarang"));
                brg.setNamaBarang(rs.getString("NamaBarang"));
                brg.setJenisBarang(rs.getString("JenisBarang"));
                brg.setHarga(rs.getString("Harga"));
                brg.setJumlah(rs.getString("Jumlah"));
                list.add(brg);
            }
        } 
        catch (Exception e) {
            System.out.println("Error Get All "+e.getMessage());
        }
        return list;
    }
    
    public entityBarang getByID(String IdBarang){
        String sql = "select * from Barang where IdBarang=?";
        entityBarang brg = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, IdBarang);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                brg = new entityBarang();
                brg.setIdBarang(rs.getString("IdBarang"));
                brg.setNamaBarang(rs.getString("NamaBarang"));
                brg.setJenisBarang(rs.getString("JenisBarang"));
                brg.setHarga(rs.getString("Harga"));
                brg.setJumlah(rs.getString("Jumlah"));
            }
        }
        catch (Exception e) {
            
        }
        return brg;
    }
    
    public boolean insert(entityBarang brg){
        boolean status = false;
        String sql = "insert into Barang values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brg.getIdBarang());
            statement.setString(2, brg.getNamaBarang());
            statement.setString(3, brg.getJenisBarang());
            statement.setString(4, brg.getHarga());
            statement.setString(5, brg.getJumlah());
            int result = statement.executeUpdate();
            status = result > 0;
        } 
        catch (Exception e) {
            
        }
        return status;
    }
    
    public boolean update(entityBarang brg){
        boolean status = false;
        String sql = "update Barang set NamaBarang=?, JenisBarang=?, Harga=?, Jumlah=?"+"where IdBarang=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brg.getNamaBarang());
            statement.setString(2, brg.getJenisBarang());
            statement.setString(3, brg.getHarga());
            statement.setString(4, brg.getJumlah());
            statement.setString(6, brg.getIdBarang());
            int result = statement.executeUpdate();
            status = result > 0;
        } 
        catch (Exception e) {
            
        }
        return status;
    }
    
    public boolean delete(entityBarang brg){
        boolean status = false;
        String sql = "delete from Barang where IdBarang=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, brg.getNamaBarang());
            int result = statement.executeUpdate();
            status = result > 0;
        } 
        catch (Exception e) {
            
        }
        return status;
    } 
}
