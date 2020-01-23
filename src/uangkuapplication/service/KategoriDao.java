/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.Kategori;
import uangkuapplication.error.KategoriException;


/**
 *
 * @author Kyoto
 */
public interface KategoriDao {
    public void insertKategori(Kategori kategori) throws KategoriException;
    public void updateKategori(Kategori kategori) throws KategoriException;
    public void deleteKategori(int id) throws KategoriException;
    public Kategori getKategori(int id) throws KategoriException;
    public List<Kategori> getAllKategori() throws KategoriException;
}
