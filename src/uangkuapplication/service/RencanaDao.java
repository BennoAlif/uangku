/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.error.RencanaException;

/**
 *
 * @author Rizki Restu
 */
public interface RencanaDao {
    
    public void insertRencana(EntityRencana rencana) throws RencanaException;
    public void deleteRencana(int id) throws RencanaException;
    public void updateRencana(EntityRencana rencana) throws RencanaException;
    public EntityRencana getRencana(int id) throws RencanaException;
    public List<EntityRencana> selectAllRencana() throws RencanaException;
}
