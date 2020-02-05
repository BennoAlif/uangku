/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.sql.SQLException;
import java.util.List;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.error.RencanaException;

/**
 *
 * @author Rizki Restu
 */
public interface IRencana {
    
    public void insertRencana(EntityRencana rencana) throws SQLException;
    public void deleteRencana(int id) throws SQLException;
    public void updateRencana(EntityRencana rencana) throws SQLException;
    
    public String getKategori(int uid) throws SQLException;
    public EntityRencana getRencana(int id) throws SQLException;
    public List<EntityRencana> selectAllRencana() throws SQLException;
    
    public List<EntityRencana> selectAllTerbayarkan() throws SQLException;
}
