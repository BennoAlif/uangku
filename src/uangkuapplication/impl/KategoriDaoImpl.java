/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.impl;

import java.sql.Connection;
import java.util.List;
import uangkuapplication.entity.Kategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.service.KategoriDao;

/**
 *
 * @author Kyoto
 */
public class KategoriDaoImpl implements KategoriDao{
    
    private Connection connection;

    public KategoriDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertKategori(Kategori kategori) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKategori(Kategori kategori) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKategori(int id) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kategori getKategori(int id) throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kategori> getAllKategori() throws KategoriException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
