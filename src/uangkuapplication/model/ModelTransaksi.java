/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.event.TransaksiListener;
import uangkuapplication.service.ITransaksi;
import uangkuapplication.service.IPengguna;
import uangkuapplication.model.ModelTablePemasukan;
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
    private int uangSekarang;
    private ModelTablePemasukan masuk;

    public int getUangSekarang(int id) throws SQLException{
        
        IPengguna daoPengguna = UangkuDatabase.getPengguna();
        uangSekarang = daoPengguna.getUang(id);
        return uangSekarang;
    }

    public void setUangSekarang(int uang) {
        
        this.uangSekarang = uang;
    }
    
    
    
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
        IPengguna daoPengguna = UangkuDatabase.getPengguna();
        EntityTransaksi transaksi = new EntityTransaksi();
        transaksi.setUid(uid);
        transaksi.setId_kategori(id_kategori);
        transaksi.setNominal(nominal);
        transaksi.setTgl_transaksi(tgl_transaksi);
        transaksi.setCatatan(catatan);
        dao.insertPemasukan(transaksi);
        
        daoPengguna.updateUang(uid, uangSekarang + nominal);
        
        fireOnInsert(transaksi);
        
    } 
    public void insertPengeluaran()throws SQLException{
        ITransaksi dao = UangkuDatabase.getTransaksi();
        IPengguna daoPengguna = UangkuDatabase.getPengguna();
        EntityTransaksi transaksi = new EntityTransaksi();
        transaksi.setUid(uid);
        transaksi.setId_kategori(id_kategori);
        transaksi.setNominal(nominal);
        transaksi.setTgl_transaksi(tgl_transaksi);
        transaksi.setCatatan(catatan);
        daoPengguna.updateUang(uid, uangSekarang - nominal);
        dao.insertPengeluaran(transaksi);
        
        fireOnInsert(transaksi);
        
    }
    
    public List<EntityTransaksi> getAllTransaksi() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAllPemasukan();
        
        return list;
    }
    
    public List<EntityTransaksi> getAllPemasukan() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAllPemasukan();
        return list;
    }
      
    public List<EntityTransaksi> getAllPengeluaran() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAllPengeluarkan();
        return list;
    }
    public List<EntityTransaksi> getAllPengeluaranKategori() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAllPengeluarkanWithKategori();
        return list;
    }
    public List<EntityTransaksi> getAllPemasukanKategori() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAllPemasukanWithKategori();
        return list;
    }
    
    public List<EntityTransaksi> getDonutChartData() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getDonutChartData();
        return list;
    }
    public List<EntityTransaksi> getAreaChartData() throws SQLException{
        List<EntityTransaksi> list = new ArrayList<EntityTransaksi>();
        ITransaksi dao = UangkuDatabase.getTransaksi();
        list = dao.getAreaChartData();
        return list;
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
