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
import uangkuapplication.service.RencanaDao;

/**
 *
 * @author Rizki Restu
 */
public class RencanaDaoImpl implements RencanaDao{
    
    private Connection connection;
    
    private final String insertRencana = "INSERT INTO RENCANA (uid, nama, nominal, tgl_rencana, status, catatan, id_kategori) VALUES (?,?,?,?,?,?,?)";
    private final String deleteRencana = "DELETE RENCANA WHERE id=?";
    private final String updateRencana = "UPDATE RENCANA uid=?, nama=?, nominal=?, tgl_rencana=?, status=?, catatan=?, id_kategori=? WHERE id=?";
    private final String getById = "SELECT * FROM RENCANA WHERE id=?";
    private final String selectAll = "SELECT * FROM RENCANA";

    public RencanaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
   
    @Override
    public void insertRencana(EntityRencana rencana) throws RencanaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertRencana);
            statement.setInt(1, rencana.getUid());
            statement.setString(2, rencana.getNama());
            statement.setInt(3, rencana.getNominal());
            statement.setDate(4, (Date) rencana.getTgl_rencana());
            statement.setString(5, rencana.getStatus());
            statement.setString(6, rencana.getCatatan());
            statement.setInt(7, rencana.getId_kategori());
            statement.executeUpdate();
            
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new RencanaException(e.getMessage());
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
    public void deleteRencana(int id) throws RencanaException {
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
            throw new RencanaException(e.getMessage());
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
    public void updateRencana(EntityRencana rencana) throws RencanaException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateRencana);
            statement.setInt(1, rencana.getUid());
            statement.setString(2, rencana.getNama());
            statement.setInt(3, rencana.getNominal());
            statement.setDate(4, (Date) rencana.getTgl_rencana());
            statement.setString(5, rencana.getStatus());
            statement.setString(6, rencana.getCatatan());
            statement.setInt(7, rencana.getId_kategori());
            statement.setInt(8, rencana.getId());
            statement.executeUpdate();
            
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new RencanaException(e.getMessage());
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
    public EntityRencana getRencana(int id) throws RencanaException {
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
                rencana.setNama(result.getString("nama"));
                rencana.setNominal(result.getInt("nominal"));
                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
                rencana.setStatus(result.getString("status"));
                rencana.setCatatan(result.getString("catatan"));
                rencana.setId_kategori(result.getInt("id_kategori"));
            }else{
                throw new RencanaException("Rencana dengan id "+id+" tidak ditemukan");
            }
            connection.commit();
            return rencana;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new RencanaException(e.getMessage());
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
    public List<EntityRencana> selectAllRencana() throws RencanaException {
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
                rencana.setNama(result.getString("nama"));
                rencana.setNominal(result.getInt("nominal"));
                rencana.setTgl_rencana(result.getDate("tgl_rencana"));
                rencana.setStatus(result.getString("status"));
                rencana.setCatatan(result.getString("catatan"));
                rencana.setId_kategori(result.getInt("id_kategori"));
                list.add(rencana);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new RencanaException(e.getMessage());
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
    
}
