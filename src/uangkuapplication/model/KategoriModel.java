/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.sql.SQLException;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.Kategori;
import uangkuapplication.error.KategoriException;
import uangkuapplication.event.KategoriListener;
import uangkuapplication.service.KategoriDao;

/**
 *
 * @author Kyoto
 */
public class KategoriModel {
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
    
    protected void fireOnInsert(Kategori kategori){
        if (listener != null) {
            listener.onInsert(kategori);
        }
    }
    
    protected void fireOnUpdate(Kategori kategori){
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
        KategoriDao dao = UangkuDatabase.getKategoriDao();
        Kategori kategori = new Kategori();
        kategori.setNama_kategori(nama_kategori);
        
        dao.insertKategori(kategori);
        fireOnInsert(kategori);
    }
    
    public void updateKategori() throws SQLException, KategoriException{
        KategoriDao dao = UangkuDatabase.getKategoriDao();
        Kategori kategori = new Kategori();
        kategori.setId(id);
        kategori.setNama_kategori(nama_kategori);
        
        dao.updateKategori(kategori);
        fireOnUpdate(kategori);
    }
    
    public void deleteKategori() throws SQLException, KategoriException{
        KategoriDao dao = UangkuDatabase.getKategoriDao();
        dao.deleteKategori(id);
        fireOnDelete();
    }
    
    public void resetKategori(){
        setId(0);
        setNama_kategori("");
    }
}
