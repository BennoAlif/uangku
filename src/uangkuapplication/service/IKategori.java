/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.error.KategoriException;


/**
 *
 * @author Kyoto
 */
public interface IKategori {
    public void insertKategori(EntityKategori kategori) throws KategoriException;
    public void updateKategori(EntityKategori kategori) throws KategoriException;
    public void deleteKategori(int id) throws KategoriException;
    public EntityKategori getKategori(int id) throws KategoriException;
    public List<EntityKategori> getAllKategori() throws KategoriException;
}
