/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.model.ModelKategori;

import java.sql.Connection;
import java.sql.SQLException;
import uangkuapplication.service.ITransaksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import uangkuapplication.error.KategoriException;



/**
 *
 * @author Wildhevire
 */
public class Transaksi implements ITransaksi {
    
    private Connection connection;
  
    private final String insertPemasukanQuery = "INSERT INTO transaksi(uid,id_kategori,nominal, tgl_transaksi, uang_sekarang, catatan, jenis_transaksi ) VALUES (?,?,?,?,?,?,?)";
    private final String updateQuery = "";
    public Transaksi(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void insertPemasukan(EntityTransaksi transaksi) throws SQLException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPemasukanQuery, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, transaksi.getUid());
            statement.setInt(2, transaksi.getId_kategori());
            statement.setInt(3, transaksi.getNominal());
            statement.setInt(5, transaksi.getUang_sekarang());
            statement.setDate(4, transaksi.getTgl_transaksi());
            statement.setString(6, transaksi.getCatatan());
            statement.setString(7, "Masuk");

            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                transaksi.setId(result.getInt(1));
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new SQLException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public uangkuapplication.entity.EntityTransaksi getTransaksi(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertPengeluaran(EntityTransaksi transaksi) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityTransaksi> getTransaksi() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
