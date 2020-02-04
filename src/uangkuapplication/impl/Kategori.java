/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.service.IKategori;
import uangkuapplication.error.KategoriException;

/**
 *
 * @author Kyoto
 */
public class Kategori implements IKategori{
    
    private Connection connection;
    private final String insertKategori = "INSERT INTO kategori (nama_kategori) VALUES (?)";
    private final String updateKategori = "UPDATE kategori SET nama_kategori=? WHERE id=?";
    private final String deleteKategori = "DELETE FROM kategori WHERE id=?";
    private final String getById = "SELECT * FROM kategori WHERE id=?";
    private final String getAll = "SELECT * FROM kategori";
    private final String getByName = "SELECT id FROM kategori WHERE name=?";
    
    public Kategori(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertKategori(EntityKategori kategori) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertKategori, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, kategori.getNama_kategori());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                kategori.setId(result.getInt(1));
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
    public void updateKategori(EntityKategori kategori) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateKategori);
            statement.setString(1, kategori.getNama_kategori());
            statement.setInt(2, kategori.getId());
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deleteKategori(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteKategori);
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
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public EntityKategori getKategori(int id) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            EntityKategori kategori = null;
            
            if (result.next()) {
                kategori = new EntityKategori();
                kategori.setId(result.getInt("id"));
                kategori.setNama_kategori(result.getString("nama_kategori"));
            }else{
                throw new SQLException("Kategori dengan id " + id + " tidak ditemukan!");
            }
            connection.commit();
            return kategori;
            
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
    public List<EntityKategori> getAllKategori() throws SQLException {
        Statement statement = null;
        List<EntityKategori> list = new ArrayList<EntityKategori>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(getAll);
            EntityKategori kategori = null;
            
            while (result.next()) {
                kategori = new EntityKategori();
                kategori.setId(result.getInt("id_kategori"));
                kategori.setNama_kategori(result.getString("nama_kategori"));
                list.add(kategori);
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
    public int getIdKategori(String nama) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByName);
            statement.setString(1, nama);
            
            ResultSet result = statement.executeQuery();
            int hasil;
            
            if (result.next()) {
                hasil = result.getInt("id");
            }else{
                throw new SQLException("Kategori dengan nama " + nama + " tidak ditemukan!");
            }
            connection.commit();
            return 0;
            
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
    
}
