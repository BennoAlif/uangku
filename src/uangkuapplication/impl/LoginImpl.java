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
    private final String insertLogin = "INSERT TO LOGIN (FULLNAME,USERNAME,PASSWORD) VALUES (?,?,?)";
       public LoginImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertLogin(Login Login) throws LoginException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertLogin);
            statement.setString(1,Login.getFullname());
            statement.setString(1,Login.getUsername());
            statement.setString(1,Login.getPassword());
            statement.executeUpdate();
            
          
            
        } catch (SQLException e) {
            throw new LoginException(e.getMessage());
        }finally{
            try {
                statement.close();
            } catch (SQLException e) {
            }
            
        }
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
