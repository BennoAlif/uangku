/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.controller;

import com.github.lgooddatepicker.components.DatePicker;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.model.ModelRencana;
import uangkuapplication.view.AnggaranFrame;
import uangkuapplication.view.MainFrame;

/**
 *
 * @author Rizki Restu
 */
public class RencanaController {
    private ModelRencana model;

    public void setModel(ModelRencana model) {
        this.model = model;
    }
    
    public void insertRencana(AnggaranFrame view){
        int idKategori = view.getIdKategori();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        String catatan = view.getTxtCatatan().getText();
        Date tanggal = new Date(view.getTglRencana().convert().getDateWithDefaultZone().getTime());
        model.setUid(UangkuApplication.UserID);
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTglRencana(tanggal);
        model.setCatatan(catatan);
        model.setStatus("Belum Bayar");
        
        try {
            model.setNama(model.getKategori(idKategori));
            model.insertRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    public void insertBayar(AnggaranFrame view){
        int idKategori = view.getIdKategori();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        String catatan = view.getTxtCatatan().getText();
        Date tanggal = new Date(view.getTglRencana().convert().getDateWithDefaultZone().getTime());
        model.setUid(UangkuApplication.UserID);
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTglRencana(tanggal);
        model.setCatatan(catatan);
        model.setStatus("Lunas");
        model.setNama(getKategori(idKategori));
        try {
           
            model.insertRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    public void updateRencana(AnggaranFrame view){
        Integer id = view.idRencana;
     
        model.setUid(id);
        
//        
        try {
           
            model.updateRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        } 
    }
    
    public String getKategori(int id){
        String nama = "";
        try {
           
            nama = model.getKategori(id);
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return nama;
    }
    public void deleteRencana(AnggaranFrame view){
        Integer id = view.idRencana;
     
        model.setUid(id);
        
        try {
           
            model.deleteRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    public List<EntityRencana> getAllRencana(){
        List<EntityRencana> list = new ArrayList<EntityRencana>();

        try {
            list = model.selectAllRencana(UangkuApplication.UserID);
            
        
        } catch (SQLException ex) {
        }
        
        
        return list;
    }
    public List<EntityRencana> getAllTerbayar(){
        List<EntityRencana> list = new ArrayList<EntityRencana>();

        try {
            list = model.selectAllTerbayar(UangkuApplication.UserID);
            
        
        } catch (SQLException ex) {
        }
        
        
        return list;
    }
    
    
}
