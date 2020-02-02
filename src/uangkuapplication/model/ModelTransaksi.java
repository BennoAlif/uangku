/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;
import java.sql.Date;
import java.sql.SQLException;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.event.TransaksiListener;
import uangkuapplication.service.ITransaksi;

/**
 *
 * @author Wildhevire
 */
public class ModelTransaksi {
    private int uid;
    private int id_kategori;
    private int nominal;
    private Date tgl_transaksi;
    private String catatan;
    
    
    TransaksiListener listener;
    
    public TransaksiListener getListener() {
        return listener;
    }

    public void setListener(TransaksiListener listener) {
        this.listener = listener;
    }
    protected void fireOnChange(){
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(EntityTransaksi transaksi){
        if (listener != null) {
            listener.onInsert(transaksi);
        }
    }
    
    protected void fireOnUpdate(EntityTransaksi transaksi){
        if (listener != null) {
            listener.onUpdate(transaksi);
        }
    }
    
    protected void fireOnDelete(){
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void insertPemasukan()throws SQLException{
        ITransaksi dao = UangkuDatabase.getTransaksi();
        EntityTransaksi transaksi = new EntityTransaksi();
        transaksi.setUid(uid);
        transaksi.setId_kategori(id_kategori);
        transaksi.setNominal(nominal);
        transaksi.setTgl_transaksi(tgl_transaksi);
        transaksi.setCatatan(catatan);
        dao.insertPemasukan(transaksi);
        
        fireOnInsert(transaksi);
        
    } 
    public void insertPengeluaran()throws SQLException{
        ITransaksi dao = UangkuDatabase.getTransaksi();
        EntityTransaksi transaksi = new EntityTransaksi();
        transaksi.setUid(uid);
        transaksi.setId_kategori(id_kategori);
        transaksi.setNominal(nominal);
        transaksi.setTgl_transaksi(tgl_transaksi);
        transaksi.setCatatan(catatan);
        
        dao.insertPengeluaran(transaksi);
        
        fireOnInsert(transaksi);
        
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public Date getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }
    

 

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
    
    
}
