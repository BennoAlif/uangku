/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.model;

import java.sql.Date;
import java.sql.SQLException;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.entity.EntityRencana;
import uangkuapplication.error.RencanaException;
import uangkuapplication.event.RencanaListener;
import uangkuapplication.service.RencanaDao;

/**
 *
 * @author Rizki Restu
 */
public class ModelRencana {
    private int nominal, id;
    private String nama;
    private Date tglRencana;
    private String catatan;
    
    private RencanaListener listener;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
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
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public Date getTglRencana() {
        return tglRencana;
    }

    public void setTglRencana(Date tglRencana) {
        this.tglRencana = tglRencana;
        fireOnChange();
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
        fireOnChange();
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
            listener.onInsert(rencana);
        } 
    }
    
    public void insertRencana() throws SQLException, RencanaException{
       
        RencanaDao rencana = UangkuDatabase.getRencana();
        EntityRencana ren = new EntityRencana();
        ren.setNama(nama);
        ren.setNominal(nominal);
        ren.setTgl_rencana(tglRencana);
        ren.setCatatan(catatan);
        
        rencana.insertRencana(ren);
        fireOnInsert(ren);
    }
    public void updateRencana() throws SQLException, RencanaException{
       
        RencanaDao rencana = UangkuDatabase.getRencana();
        EntityRencana ren = new EntityRencana();
        ren.setNama(nama);
        ren.setNominal(nominal);
        ren.setTgl_rencana(tglRencana);
        ren.setCatatan(catatan);
        ren.setId(id);
        
        rencana.updateRencana(ren);
        fireOnUpdate(ren);
    }
    public void deleteRencana() throws SQLException, RencanaException{
       
        RencanaDao rencana = UangkuDatabase.getRencana();
        rencana.deleteRencana(id);
        fireOnDelete();
    }
}
