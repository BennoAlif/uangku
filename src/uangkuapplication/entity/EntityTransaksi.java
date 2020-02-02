/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.entity;
import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author Wildhevire
 */
public class EntityTransaksi {
    //properties
    private int id;
    private int uid;
    private int id_kategori;
    private int nominal;
    private Date tgl_transaksi;
    private String catatan;
    private String jenis_transaksi;

    
    //constructor
    public EntityTransaksi(){
        
    }
    
    public EntityTransaksi(int uid, int id_kategori, int nominal, Date tgl_transaksi, int uang_sekarang, String catatan, String jenis_transaksi) {
        this.uid = uid;
        this.id_kategori = id_kategori;
        this.nominal = nominal;
        this.tgl_transaksi = tgl_transaksi;
        this.catatan = catatan;
        this.jenis_transaksi = jenis_transaksi;
    }

    //getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.uid;
        hash = 97 * hash + this.id_kategori;
        hash = 97 * hash + this.nominal;
        hash = 97 * hash + Objects.hashCode(this.tgl_transaksi);
        hash = 97 * hash + Objects.hashCode(this.catatan);
        hash = 97 * hash + Objects.hashCode(this.jenis_transaksi);
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
        final EntityTransaksi other = (EntityTransaksi) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.uid != other.uid) {
            return false;
        }
        if (this.id_kategori != other.id_kategori) {
            return false;
        }
        if (this.nominal != other.nominal) {
            return false;
        }

        if (!Objects.equals(this.catatan, other.catatan)) {
            return false;
        }
        if (!Objects.equals(this.tgl_transaksi, other.tgl_transaksi)) {
            return false;
        }
        if (this.jenis_transaksi != other.jenis_transaksi) {
            return false;
        }
        return true;
    }
    
    
    
}
