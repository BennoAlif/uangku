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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.error.KategoriException;



/**
 *
 * @author Wildhevire
 */
public class Transaksi implements ITransaksi {
    
    private Connection connection;
  
    private final String insertTransaksi = "INSERT INTO transaksi(uid, id_kategori, nominal, tgl_transaksi, catatan, jenis_transaksi) VALUES (?,?,?,?,?,?)";
    private final String getAllTransaksi = "SELECT nominal, tgl_transaksi, jenis_transaksi FROM transaksi WHERE uid=?"; 
    private final String getPrefTransaksi = "SELECT * FROM transaksi ORDER BY ";
    public Transaksi(Connection connection) {
        this.connection = connection;
    }
    
    
    
    @Override
    public void insertPemasukan(EntityTransaksi transaksi) throws SQLException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertTransaksi, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, transaksi.getUid());
            statement.setInt(2, transaksi.getId_kategori());
            statement.setInt(3, transaksi.getNominal());
            statement.setDate(4, transaksi.getTgl_transaksi());
            statement.setString(5, transaksi.getCatatan());
            statement.setString(6, "Masuk");

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
    public void insertPengeluaran(EntityTransaksi transaksi) throws SQLException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertTransaksi, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, transaksi.getUid());
            statement.setInt(2, transaksi.getId_kategori());
            statement.setInt(3, transaksi.getNominal());
            statement.setDate(4, transaksi.getTgl_transaksi());
            statement.setString(5, transaksi.getCatatan());
            statement.setString(6, "Keluar");

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
    public EntityTransaksi getTransaksi(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            EntityTransaksi transaksi = null;
            
            if (result.next()) {
                transaksi = new EntityTransaksi();
                kategori.setId(result.getInt("id"));
                kategori.setNama_kategori(result.getString("nama_kategori"));
            }else{
                throw new SQLException("Kategori dengan id " + id + " tidak ditemukan!");
            }
            connection.commit();
            return transaksi;
            
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
        */
    }

   

    @Override
    public List<EntityTransaksi> getAllTransaksi() throws SQLException
    {
        
        Statement statement = null;
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(getAllTransaksi);
            EntityTransaksi transaksi = null;
            
            while (result.next()) {
                transaksi = new EntityTransaksi();
                transaksi.setNominal(result.getInt("nominal"));
                transaksi.setTgl_transaksi(result.getDate("tgl_transaksi"));
                transaksi.setJenis_transaksi(result.getString("jenis_transaksi"));
                list.add(transaksi);
            }
            connection.commit();
            return list;
            
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
    public List<EntityTransaksi> getAllPemasukan() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityTransaksi> getAllPengeluarkan() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
