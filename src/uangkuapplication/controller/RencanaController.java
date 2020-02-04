/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.controller;

import com.github.lgooddatepicker.components.DatePicker;
import java.sql.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
        
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTglRencana(tanggal);
        model.setCatatan(catatan);
        
        try {
           
            model.insertRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
    }
    public void updateRencana(AnggaranFrame view){
        
        Integer id = Integer.parseInt(view.getTxtID().getText());
        int idKategori = view.getIdKategori();
        int nominal = Integer.parseInt(view.getTxtNominal().getText());
        String catatan = view.getTxtCatatan().getText();
        Date tanggal = new Date(view.getTglRencana().convert().getDateWithDefaultZone().getTime());
        
        model.setId(id);
        model.setId_kategori(idKategori);
        model.setNominal(nominal);
        model.setTglRencana(tanggal);
        model.setCatatan(catatan);
        
        try {
           
            model.updateRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        } 
    }
    public void deleteRencana(AnggaranFrame view){
        Integer id = Integer.parseInt(view.getTxtID().getText());
        model.setId(id);
        
        try {
           
            model.deleteRencana();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}
