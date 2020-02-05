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
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.error.RencanaException;
import uangkuapplication.event.RencanaListener;
import uangkuapplication.service.IRencana;

/**
 *
 * @author Rizki Restu
 */
public class ModelRencana {
    private int nominal, uid;
    private int id_kategori;
    private Date tglRencana;
    private String catatan, status, nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    private RencanaListener listener;

    public int getUid() {
        return uid;
    }

    public void setUid(int id) {
        this.uid = id;
        //fireOnChange();
    }
    
    public RencanaListener getListener() {
        return listener;
    }

    public void setListener(RencanaListener listener) {
        this.listener = listener;
    }
    
    
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
        //fireOnChange();
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
        //fireOnChange();
    }

    
    public Date getTglRencana() {
        return tglRencana;
    }

    public void setTglRencana(Date tglRencana) {
        this.tglRencana = tglRencana;
        //fireOnChange();
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
        //fireOnChange();
    }
    
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    protected void fireOnInsert(EntityRencana rencana){
        if (listener!=null) {
            listener.onInsert(rencana);
        }
        
    }
    protected void fireOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    protected void fireOnUpdate(EntityRencana rencana){
        if (listener!=null) {
            listener.onUpdate(rencana);
        } 
    }
    
    protected void fireOnBayar(EntityRencana rencana){
        if (listener!=null) {
            listener.onBayar(rencana);
        } 
    }
    
    public void insertRencana() throws SQLException{
       
        IRencana rencana = UangkuDatabase.getRencana();
        EntityRencana ren = new EntityRencana();
        ren.setUid(uid);
        ren.setId_kategori(id_kategori);
        ren.setNominal(nominal);
        ren.setTgl_rencana(tglRencana);
        ren.setCatatan(catatan);
        ren.setStatus(status);
        
        rencana.insertRencana(ren);
        fireOnInsert(ren);
    }
    public void updateRencana() throws SQLException{
       
        IRencana rencana = UangkuDatabase.getRencana();
        EntityRencana ren = new EntityRencana();
        ren.setId_kategori(id_kategori);
        ren.setNominal(nominal);
        ren.setTgl_rencana(tglRencana);
        ren.setCatatan(catatan);
        ren.setId(uid);
        
        rencana.updateRencana(ren);
        fireOnUpdate(ren);
    }
    
    
    public void deleteRencana() throws SQLException{
       
        IRencana rencana = UangkuDatabase.getRencana();
        rencana.deleteRencana(uid);
        fireOnDelete();
    }
    
    public List<EntityRencana> selectAllRencana() throws SQLException{
        List<EntityRencana> list = new ArrayList<EntityRencana>();
        IRencana dao = UangkuDatabase.getRencana();
        list = dao.selectAllRencana();
        return list;

    }
    public String getKategori(int uid) throws SQLException{
        IRencana dao = UangkuDatabase.getRencana();
        String list = dao.getKategori(uid);
        return list;
    }
}
