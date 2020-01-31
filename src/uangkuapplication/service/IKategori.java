/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.util.List;
import uangkuapplication.entity.EntityKategori;
import java.sql.SQLException;

/**
 *
 * @author Kyoto
 */
public interface IKategori {
    public void insertKategori(EntityKategori kategori) throws SQLException;
    public void updateKategori(EntityKategori kategori) throws SQLException;
    public void deleteKategori(int id) throws SQLException;
    public EntityKategori getKategori(int id) throws SQLException;
    public List<EntityKategori> getAllKategori() throws SQLException;
}
