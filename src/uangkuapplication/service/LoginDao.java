/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.Login;
import uangkuapplication.error.LoginException;



/**
 *
 * @author riski
 */
public interface LoginDao {
    public void insertLogin(Login Login) throws LoginException;
    public void updateLogin(Login Login) throws LoginException;
    public void delateLogin(Integer id) throws LoginException;
    public Login getLogin (int id) throws LoginException;
    public Login getLogin (String email) throws LoginException;
    public List <Login> selectAllLogin() throws LoginException;
        
    
}
