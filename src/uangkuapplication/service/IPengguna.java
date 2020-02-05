/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import java.sql.SQLException;
import uangkuapplication.entity.EntityPengguna;
import uangkuapplication.error.LoginException;



/**
 *
 * @author riski
 */
public interface IPengguna {
    public void register(EntityPengguna login) throws SQLException;
    
    public EntityPengguna login(String username, String password) throws SQLException;
    
    public void updateUang(int uid, int nominal) throws SQLException;
    
    public int getUang(int uid) throws SQLException;
    public String getFullname(int uid) throws SQLException;
    
    public void updateProfile(String fullname, String password,int uid) throws SQLException;
    
}
