/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.service;

import java.sql.SQLException;
import java.util.List;
import uangkuapplication.entity.*;


/**
 *
 * @author Wildhevire
 */
public interface ITransaksi {
    public void insertPemasukan(EntityTransaksi transaksi) throws SQLException;
    public void insertPengeluaran(EntityTransaksi transaksi) throws SQLException;
    
    
    
    public EntityTransaksi getTransaksi(int id) throws SQLException;
    
    
    public List<EntityTransaksi> getAllPemasukan() throws SQLException;
    public List<EntityTransaksi> getAllPengeluarkan() throws SQLException;
    public List<EntityTransaksi> getAllTransaksi(int uid) throws SQLException;
    public List<EntityTransaksi> getAllPemasukanWithKategori() throws SQLException;
    public List<EntityTransaksi> getAllPengeluarkanWithKategori() throws SQLException;
    public List<EntityTransaksi> getDonutChartData() throws SQLException;
    public List<EntityTransaksi> getAreaChartData() throws SQLException;

}
