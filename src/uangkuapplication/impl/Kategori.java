/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.util.List;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.service.IKategori;

/**
 *
 * @author Kyoto
 */
public class Kategori implements IKategori{
    
    private Connection connection;

    public Kategori(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertKategori(EntityKategori kategori) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKategori(EntityKategori kategori) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKategori(int id) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntityKategori getKategori(int id) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntityKategori> getAllKategori() throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
