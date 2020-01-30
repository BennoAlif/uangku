/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import uangkuapplication.entity.Login;
import uangkuapplication.error.LoginException;
import uangkuapplication.service.LoginDao;

/**
 *
 * @author riski
 */
public class LoginImpl implements LoginDao{

    private Connection connection;
    private final String registerQuery = "INSERT INTO pengguna (fullname,username,password) VALUES (?,?,?)";
    private final String loginQuery = "SELECT uid FROM pengguna WHERE username=? AND password=?";
    public LoginImpl(Connection connection) {
        this.connection = connection;
    }

       
    @Override
    public void register(Login login) throws SQLException {
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
    public void login(String username, String password) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(loginQuery);
            statement.setString(1, username);
            statement.setString(2, password);
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
    public void insertLogin(Login Login) throws LoginException {
       
    }

    @Override
    public Login getLogin(int id) throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login getLogin(String email) throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLogin(Login Login) throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delateLogin(Integer id) throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> selectAllLogin() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
