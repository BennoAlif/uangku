/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.error.RencanaException;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.service.IRencana;

/**
 *
 * @author Rizki Restu
 */
public class Rencana implements IRencana{
    
    private Connection connection;
    
    private final String insertRencana = "INSERT INTO RENCANA (uid, id_kategori, nominal, tgl_rencana, status, catatan) VALUES (?,?,?,?,?,?)";
    private final String updateRencana = "UPDATE rencana SET status = 'Selesai' where id=?";
    private final String deleteRencana = "DELETE FROM rencana WHERE id=?";
    private final String getById = "SELECT * FROM RENCANA WHERE id=?";
    private final String selectAll = "SELECT * FROM rencana INNER JOIN kategori ON rencana.id_kategori = kategori.id_kategori WHERE status='Belum Bayar'";
    private final String selectKategori = "SELECT nama_kategori FROM kategori WHERE id_kategori = ?";
    private final String selectAllTerbayar = "SELECT * FROM rencana INNER JOIN kategori ON rencana.id_kategori = kategori.id_kategori WHERE status='Selesai'";
    
    
    public Rencana(Connection connection) {
        this.connection = connection;
    }
    
   
    @Override
    public void insertRencana(EntityRencana rencana) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertRencana);
            statement.setInt(1, rencana.getUid());
            statement.setInt(2, rencana.getId_kategori());
            statement.setInt(3, rencana.getNominal());
            statement.setDate(4, (Date)rencana.getTgl_rencana());
            statement.setString(5, rencana.getStatus());
            statement.setString(6, rencana.getCatatan());
            statement.executeUpdate();
            
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
    }

    @Override
    public void deleteRencana(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(deleteRencana);
            statement.setInt(1, id);
            statement.executeUpdate();
            
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
    }

    @Override
    public void updateRencana(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateRencana);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
    }

    @Override
    public EntityRencana getRencana(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            EntityRencana rencana = null;
            
                        
            if (result.next()) {
                rencana = new EntityRencana();
                rencana.setId(result.getInt("id"));
                rencana.setUid(result.getInt("uid"));
                rencana.setId_kategori(result.getInt("id_kategori"));
                rencana.setNominal(result.getInt("nominal"));
                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
                rencana.setStatus(result.getString("status"));
                rencana.setCatatan(result.getString("catatan"));
            }else{
                throw new SQLException("Rencana dengan id "+id+" tidak ditemukan");
            }
            connection.commit();
            return rencana;
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
    }

    @Override
    public List<EntityRencana> selectAllRencana() throws SQLException {
        Statement statement = null;
        List<EntityRencana> list = new ArrayList<EntityRencana>();
        try {
            connection.setAutoCommit(false);
            
            
            statement = connection.createStatement();
            
            
            
            ResultSet result = statement.executeQuery(selectAll);
            EntityRencana rencana = null;
            
                        
            while (result.next()) {
                rencana = new EntityRencana();
                rencana.setId(result.getInt("id"));
                rencana.setUid(result.getInt("uid"));
                rencana.setId_kategori(result.getInt("id_kategori"));
                rencana.setNominal(result.getInt("nominal"));
                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
                rencana.setStatus(result.getString("status"));
                rencana.setCatatan(result.getString("catatan"));
                rencana.setNama(result.getString("nama_kategori"));
                list.add(rencana);
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
    }

    @Override
    public List<EntityRencana> selectAllTerbayarkan() throws SQLException {
        Statement statement = null;
        List<EntityRencana> list = new ArrayList<EntityRencana>();
        try {
            connection.setAutoCommit(false);
            
            
            statement = connection.createStatement();
            
            
            
            ResultSet result = statement.executeQuery(selectAllTerbayar);
            EntityRencana rencana = null;
            
                        
            while (result.next()) {
                rencana = new EntityRencana();
                rencana.setId(result.getInt("id"));
                rencana.setUid(result.getInt("uid"));
                rencana.setId_kategori(result.getInt("id_kategori"));
                rencana.setNominal(result.getInt("nominal"));
                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
                rencana.setStatus(result.getString("status"));
                rencana.setCatatan(result.getString("catatan"));
                rencana.setNama(result.getString("nama_kategori"));
                list.add(rencana);
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }

    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getKategori(int uid) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(selectKategori);
            statement.setInt(1, uid);
            ResultSet result = statement.executeQuery();
            EntityRencana rencana = null;
            String nama;
                        
            if (result.next()) {
                  nama = result.getString("nama_kategori");
//                rencana = new EntityRencana();
//                rencana.setId(result.getInt("id"));
//                rencana.setUid(result.getInt("uid"));
//                rencana.setId_kategori(result.getInt("id_kategori"));
//                rencana.setNominal(result.getInt("nominal"));
//                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
//                rencana.setStatus(result.getString("status"));
//                rencana.setCatatan(result.getString("catatan"));
            }else{
                throw new SQLException("Nama kategori tidak ditemukan");
            }
            connection.commit();
            return nama;
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
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }    
            }
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
