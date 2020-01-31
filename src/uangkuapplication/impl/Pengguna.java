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
        String loginQuery = "SELECT * FROM pengguna WHERE username='"+username+"' AND password='"+password+"'";
        PreparedStatement statement = null;
        ResultSet result = null;
        EntityPengguna logInfo = null;
        try {
            statement = connection.prepareStatement(loginQuery);
            
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
    
        
    
}
