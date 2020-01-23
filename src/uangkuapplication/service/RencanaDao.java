/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.Rencana;
import uangkuapplication.error.RencanaException;

/**
 *
 * @author Rizki Restu
 */
public interface RencanaDao {
    
    public void createRencana(Rencana rencana) throws RencanaException;
    public void deleteRencana(Rencana rencana) throws RencanaException;
    public void updateRencana(Rencana rencana) throws RencanaException;
    public Rencana getRencana(int id) throws RencanaException;
    public List<Rencana> selectAllRencana() throws RencanaException;
}
