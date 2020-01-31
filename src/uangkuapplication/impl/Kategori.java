/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
<<<<<<< HEAD:src/uangkuapplication/impl/Kategori.java
import java.sql.SQLException;
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
>>>>>>> e713b7e094c870799e9ca0ee5940280ad5b19169:src/uangkuapplication/impl/KategoriDaoImpl.java
import java.util.List;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.service.IKategori;

/**
 *
 * @author Kyoto
 */
public class Kategori implements IKategori{
    
    private Connection connection;

<<<<<<< HEAD:src/uangkuapplication/impl/Kategori.java
    public Kategori(Connection connection) {
=======
    private final String insertKategori = "INSERT INTO kategori (nama_kategori) VALUES (?)";
    private final String updateKategori = "UPDATE kategori SET nama_kategori=? WHERE id=?";
    private final String deleteKategori = "DELETE FROM kategori WHERE id=?";
    private final String getById = "SELECT * FROM kategori WHERE id=?";
    private final String getAll = "SELECT * FROM kategori";
    
    public KategoriDaoImpl(Connection connection) {
>>>>>>> e713b7e094c870799e9ca0ee5940280ad5b19169:src/uangkuapplication/impl/KategoriDaoImpl.java
        this.connection = connection;
    }

    @Override
<<<<<<< HEAD:src/uangkuapplication/impl/Kategori.java
    public void insertKategori(EntityKategori kategori) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKategori(EntityKategori kategori) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKategori(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityKategori getKategori(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityKategori> getAllKategori() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
    public void insertKategori(Kategori kategori) throws KategoriException {
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
            throw new KategoriException(e.getMessage());
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
    public void updateKategori(Kategori kategori) throws KategoriException {
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
            throw new KategoriException(e.getMessage());
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
    public void deleteKategori(int id) throws KategoriException {
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
            throw new KategoriException(e.getMessage());
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
    public Kategori getKategori(int id) throws KategoriException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            Kategori kategori = null;
            
            if (result.next()) {
                kategori = new Kategori();
                kategori.setId(result.getInt("id"));
                kategori.setNama_kategori(result.getString("nama_kategori"));
            }else{
                throw new KategoriException("Kategori dengan id " + id + " tidak ditemukan!");
            }
            connection.commit();
            return kategori;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new KategoriException(e.getMessage());
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
    public List<Kategori> getAllKategori() throws KategoriException {
        Statement statement = null;
        List<Kategori> list = new ArrayList<Kategori>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(getAll);
            Kategori kategori = null;
            
            while (result.next()) {
                kategori = new Kategori();
                kategori.setId(result.getInt("id"));
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
            throw new KategoriException(e.getMessage());
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
>>>>>>> e713b7e094c870799e9ca0ee5940280ad5b19169:src/uangkuapplication/impl/KategoriDaoImpl.java
    }
    
}
