/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityKategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.event.KategoriListener;
import uangkuapplication.service.IKategori;
import uangkuapplication.view.PemasukanFrame;
import uangkuapplication.main.UangkuApplication;

/**
 *
 * @author Kyoto
 */
public class ModelKategori {
    private int id;
    private String nama_kategori;

    private KategoriListener listener;

    public KategoriListener getListener() {
        return listener;
    }

    public void setListener(KategoriListener listener) {
        this.listener = listener;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(EntityKategori kategori){
        if (listener != null) {
            listener.onInsert(kategori);
        }
    }
    
    protected void fireOnUpdate(EntityKategori kategori){
        if (listener != null) {
            listener.onUpdate(kategori);
        }
    }
    
    protected void fireOnDelete(){
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertKategori() throws SQLException, KategoriException{
        IKategori dao = UangkuDatabase.getKategori();
        EntityKategori kategori = new EntityKategori();
        kategori.setNama_kategori(nama_kategori);
        
        dao.insertKategori(kategori);
        fireOnInsert(kategori);
    }
    
    public void updateKategori() throws SQLException, KategoriException{
        IKategori dao = UangkuDatabase.getKategori();
        EntityKategori kategori = new EntityKategori();
        kategori.setId(id);
        kategori.setNama_kategori(nama_kategori);
        
        dao.updateKategori(kategori);
       
        
        fireOnUpdate(kategori);
    }
    
    public void deleteKategori() throws SQLException, KategoriException{
        IKategori dao = UangkuDatabase.getKategori();
        dao.deleteKategori(id);
        fireOnDelete();
    }
    
    public void resetKategori(){
        setId(0);
        setNama_kategori("");
    }
}
