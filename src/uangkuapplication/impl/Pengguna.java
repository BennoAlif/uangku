/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import uangkuapplication.entity.EntityPengguna;
import uangkuapplication.error.LoginException;
import uangkuapplication.service.IPengguna;

/**
 *
 * @author riski
 */
public class Pengguna implements IPengguna{

    private Connection connection;
    private final String registerQuery = "INSERT INTO pengguna (fullname,username,password) VALUES (?,?,?)";
    private final String loginQuery = "SELECT * FROM pengguna WHERE username=? AND password=?";
    private final String updateUang = "UPDATE pengguna SET uang=? WHERE uid=?";
    private final String getById = "SELECT uang FROM pengguna WHERE uid=?";
    private final String getFullnamebyID = "SELECT fullname FROM pengguna WHERE uid=?";
    private final String updateProfile = "UPDATE pengguna SET fullname=?, password=? WHERE uid=?";
    public Pengguna(Connection connection) {
        this.connection = connection;
    }

       
    @Override
    public void register(EntityPengguna login) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(registerQuery);
            statement.setString(1, login.getFullname());
            statement.setString(2,login.getUsername());
            statement.setString(3,login.getPassword());
            statement.execute();
            
          
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }finally{
            try {
                statement.close();
            } catch (SQLException e) {
            }
            
        }    
    }

    @Override
    public EntityPengguna login(String username, String password) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        EntityPengguna logInfo = null;
        try {
            statement = connection.prepareStatement(loginQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
            
            
            //loop through result record and populate it to some object
            while(result.next()){
                logInfo = new EntityPengguna();
                logInfo.setUid(result.getInt("uid"));
                logInfo.setFullname(result.getString("fullname"));
                logInfo.setUsername(result.getString("username"));
            }
           
            return logInfo;
            
          
            
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }finally{
            try {
                statement.close();
            } catch (SQLException e) {
            }
            
        }
        
    }

    @Override
    public void updateUang(int uid, int nominal) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateUang);
            statement.setInt(1, nominal);
            statement.setInt(2, uid);
            
            
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
    public int getUang(int uid) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, uid);
            
            ResultSet result = statement.executeQuery();
            int uang;
            
            if (result.next()) {
                uang = result.getInt("uang");
                
            }else{
                throw new SQLException("Kategori dengan id " + uid + " tidak ditemukan!");
            }
            connection.commit();
            return uang;
            
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
    public String getFullname(int uid) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getFullnamebyID);
            statement.setInt(1, uid);
            
            ResultSet result = statement.executeQuery();
            String name;
            
            if (result.next()) {
                name = result.getString("fullname");
                
            }else{
                throw new SQLException("Nama dengan id " + uid + " tidak ditemukan!");
            }
            connection.commit();
            return name;
            
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
    public void updateProfile(String fullname, String password,int uid) throws SQLException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateProfile);
            statement.setString(1, fullname);
            statement.setString(2, password);
            statement.setInt(3, uid);
            
            
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
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
    
}
