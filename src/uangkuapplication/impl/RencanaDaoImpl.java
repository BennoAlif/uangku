/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.util.List;
import uangkuapplication.entity.Rencana;
import uangkuapplication.error.RencanaException;
import uangkuapplication.service.RencanaDao;

/**
 *
 * @author Rizki Restu
 */
public class RencanaDaoImpl implements RencanaDao{
    
    private Connection connection;

    public RencanaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void createRencana(Rencana rencana) throws RencanaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRencana(Rencana rencana) throws RencanaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRencana(Rencana rencana) throws RencanaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rencana getRencana(int id) throws RencanaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rencana> selectAllRencana() throws RencanaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
