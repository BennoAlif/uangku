/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import java.sql.SQLException;
import uangkuapplication.entity.Login;
import uangkuapplication.error.LoginException;



/**
 *
 * @author riski
 */
public interface LoginDao {
    public void register(Login login) throws SQLException;
    public void login(String username, String password) throws SQLException;
            
            
    public void insertLogin(Login Login) throws LoginException;
    public void updateLogin(Login Login) throws LoginException;
    public void delateLogin(Integer id) throws LoginException;
    public Login getLogin (int id) throws LoginException;
    public Login getLogin (String email) throws LoginException;
    public List <Login> selectAllLogin() throws LoginException;
        
    
}
