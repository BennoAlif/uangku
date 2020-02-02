/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.controller;
import java.sql.Date;
import javax.swing.JOptionPane;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.model.ModelTransaksi;
import uangkuapplication.view.MainFrame;
import uangkuapplication.view.PemasukanFrame;
import uangkuapplication.view.PengeluaranFrame;


/**
 *
 * @author Wildhevire
 */
public class TransaksiController {
    private ModelTransaksi model;

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
        try {
           
            model.insertPengeluaran();
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
        try {
           
            model.insertPengeluaran();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
    
    
}
