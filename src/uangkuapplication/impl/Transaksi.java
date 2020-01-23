/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;
import java.sql.Connection;
import java.sql.SQLException;
import uangkuapplication.service.ITransaksi;

/**
 *
 * @author Wildhevire
 */
public class Transaksi implements ITransaksi {
    
    private Connection connection;
  
    private final String insertQuery = "INSERT INTO transaksi(uid,id_kategori,nominal, tgl_transaksi, uang_sekarang, ) values (?,?,?,?,?,?,?)";
    private final String updateQuery = "";
    public Transaksi(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void insertTransaksi(uangkuapplication.entity.Transaksi transaksi) throws SQLException {
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public uangkuapplication.entity.Transaksi getTransaksi(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
