/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Rizki Restu
 */
public class EntityRencana {
    private Integer id;
    private Integer uid;
    private String nama;
    private Integer nominal;
    private Date tgl_rencana;
    private String status;
    private String catatan;
    private Integer id_kategori;
    
    public EntityRencana(){
        
    }
    //constructor
    public EntityRencana(Integer id, Integer uid, String nama, Integer nominal, Date tgl_rencana, String status, String catatan, Integer id_kategori) {
        this.id = id;
        this.uid = uid;
        this.nominal = nominal;
        this.tgl_rencana = tgl_rencana;
        this.status = status;
        this.catatan = catatan;
        this.id_kategori = id_kategori;
    }
    
    
    //getter & setter
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

        public int getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Date getTgl_rencana() {
        return tgl_rencana;
    }

    public void setTgl_rencana(Date tgl_rencana) {
        this.tgl_rencana = tgl_rencana;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(Integer id_kategori) {
        this.id_kategori = id_kategori;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + this.uid;
        hash = 23 * hash + Objects.hashCode(this.nama);
        hash = 23 * hash + this.nominal;
        hash = 23 * hash + Objects.hashCode(this.tgl_rencana);
        hash = 23 * hash + Objects.hashCode(this.status);
        hash = 23 * hash + Objects.hashCode(this.catatan);
        hash = 23 * hash + this.id_kategori;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntityRencana other = (EntityRencana) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.uid != other.uid) {
            return false;
        }
        if (this.nominal != other.nominal) {
            return false;
        }
        if (this.id_kategori != other.id_kategori) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.catatan, other.catatan)) {
            return false;
        }
        if (!Objects.equals(this.tgl_rencana, other.tgl_rencana)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
