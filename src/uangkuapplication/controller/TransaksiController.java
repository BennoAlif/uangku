/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.controller;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.model.ModelTransaksi;
import uangkuapplication.impl.Pengguna;
import uangkuapplication.model.ModelTablePemasukan;
import uangkuapplication.view.MainFrame;
import uangkuapplication.view.PemasukanFrame;
import uangkuapplication.view.PengeluaranFrame;
import uangkuapplication.service.IPengguna;




/**
 *
 * @author Wildhevire
 */
public class TransaksiController {
    private ModelTransaksi model;
    private ModelTablePemasukan masuk;
    public void setModel(ModelTransaksi model) {
        this.model = model;
    }
    
    
    public void insertPemasukan(PemasukanFrame view){
        int idKategori = view.getIdKategori();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        Date tanggal = new Date(view.getDatePicker().convert().getDateWithDefaultZone().getTime());
        String catatan = view.getTxtCatatan().getText();
        model.setUid(UangkuApplication.UserID);
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTgl_transaksi(tanggal);
        model.setCatatan(catatan);
        model.setUangSekarang(UangkuApplication.Uang);
        
        try {
           
            model.insertPemasukan();
            UangkuApplication.Uang = model.getUangSekarang();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
        
    }
    public void insertPengeluaran(PengeluaranFrame view){
        int idKategori = view.getIdKategori();
        
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        Date tanggal = new Date(view.getDatePicker().convert().getDateWithDefaultZone().getTime());
        String catatan = view.getTxtCatatan().getText();
        model.setUid(UangkuApplication.UserID);
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTgl_transaksi(tanggal);
        model.setCatatan(catatan);
        model.setUangSekarang(UangkuApplication.Uang);

        try {
           
            model.insertPengeluaran();
            UangkuApplication.Uang = model.getUangSekarang();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    
    public List<EntityTransaksi> getAllPemasukan(){
        
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

        try {
            list = model.getAllPemasukan();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //masuk.setList(list);
        return list;
    }
    
    public List<EntityTransaksi> getAllPengeluaran(){
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

        try {
            list = model.getAllPengeluaran();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }
    
    public int getTotalPemasukan(){
        int total=0;
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        list = getAllPemasukan();
        for(int i = 0; i < list.size(); i++){
            total += list.get(i).getNominal();
        }
        return total;
    }
    public int getTotalPengeluaran(){
        int total=0;
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        list = getAllPengeluaran();
        for(int i = 0; i < list.size(); i++){
            total += list.get(i).getNominal();
        }
        return total;
    }
    
    public int getUangSekarang(){
        int uang = 0;
        try {
            uang = model.getUangSekarang();
            return uang;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uang;
    }
    public List<EntityTransaksi> getAllPemasukanKategory(){
        
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

        try {
            list = model.getAllPemasukanKategori();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //masuk.setList(list);
        return list;
    }
    public List<EntityTransaksi> getAllPengeluaranKategori(){
        
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

        try {
            list = model.getAllPengeluaranKategori();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //masuk.setList(list);
        return list;
    }
    
    public List<EntityTransaksi> getDonutChartData(){
        
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();

        try {
            list = model.getDonutChartData();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //masuk.setList(list);
        return list;
    }
    
    
}
